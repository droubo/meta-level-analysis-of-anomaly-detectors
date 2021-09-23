package alexp.macrobase.outlier.estorm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import alexp.macrobase.outlier.mcod.Data;
import alexp.macrobase.outlier.mcod.measurements.MesureMemoryThread;
import alexp.macrobase.outlier.mcod.mtree.MTreeClass;
import alexp.macrobase.outlier.mcod.utils.Utils;

public class ExactStorm {

    private double maxDistance = 1; // maxDistance in paper
    private int minNeighborCount = 30; // minNeighborCount in paper
    private int windowSize = 1000; // windowSize in paper
    private int slide = 500;

    public static MTreeClass mtree = new MTreeClass();
    // store list id in increasing time arrival order
    public static ArrayList<DataStormObject> dataList = new ArrayList<>();

    public double avgCurrentNeighbor = 0;
    public static double avgAllWindowNeighbor = 0;

    public ExactStorm(double maxDistance, int minNeighborCount, int windowSize, int slide) {
        this.maxDistance = maxDistance;
        this.minNeighborCount = minNeighborCount;
        this.windowSize = windowSize;
        this.slide = slide;
    }

    public  boolean isSameSlide(DataStormObject d1, DataStormObject d2) {
        return (d1.arrivalTime() - 1) / slide == (d2.arrivalTime() - 1) / slide;
    }

    public ArrayList<Data> detectOutlier(ArrayList<Data> data, int currentTime) {

        ArrayList<Data> outliers = new ArrayList<>();

        long startTime = Utils.getCPUTime();
        /**
         * remove expired data from dataList and mtree
         */
        if (slide != windowSize) {
            int index = -1;
            for (int i = 0; i < dataList.size(); i++) {
                DataStormObject d = dataList.get(i);
                if (d.arrivalTime() <= currentTime - windowSize) {
                    // mark here for removing data from datalist later
                    index = i;
                    // remove from mtree
//                for(DataStormObject d2: dataList){
//                    if(d2.arrivalTime > d.arrivalTime){
//                        if(d2.nn_before.contains(d))
//                            d2.nn_before.remove(d);
//                    }
//                }
                    long startTime3 = Utils.getCPUTime();
                    mtree.remove(d);
                    d.nn_before.clear();
                    MesureMemoryThread.timeForIndexing += Utils.getCPUTime() - startTime3;
                } else {
                    break;
                }
            }
            for (int i = index; i >= 0; i--) {

                dataList.remove(i);
            }
        } else {
            dataList.clear();
            mtree = null;
            mtree = new MTreeClass();

        }
        MesureMemoryThread.timeForExpireSlide += Utils.getCPUTime() - startTime;

        startTime = Utils.getCPUTime();

        for (Data d : data) {

            DataStormObject ob = new DataStormObject(d);
            /**
             * do range query for ob
             */
            long startTime4 = Utils.getCPUTime();
            MTreeClass.Query query = mtree.getNearestByRange(ob, maxDistance);
            MesureMemoryThread.timeForQuerying += Utils.getCPUTime() - startTime4;

            ArrayList<DataStormObject> queryResult = new ArrayList<>();
            for (MTreeClass.ResultItem ri : query) {
                queryResult.add((DataStormObject) ri.data);
                if (ri.distance == 0) {
                    ob.values[0] += (new Random()).nextDouble() / 1000000;
                }
            }

            Collections.sort(queryResult, new DataStormComparator());

            queryResult.stream().filter((dod) -> (dod.arrivalTime() > currentTime - windowSize)).filter((dod) -> (dod != null)).map((dod) -> {
                if (isSameSlide(dod, ob)) {
                    ob.count_after++;
                } else {

                    if (ob.nn_before.size() < minNeighborCount) {
                        ob.nn_before.add(0, dod);
                    }
                }
                return dod;
            }).forEach((dod) -> {
                dod.count_after++;
            });//                Utils.computeUsedMemory();

            /**
             * store object into mtree
             */
//            Utils.computeUsedMemory();
            long startTime2 = Utils.getCPUTime();
            mtree.add(ob);
            MesureMemoryThread.timeForIndexing += Utils.getCPUTime() - startTime2;

            dataList.add(ob);

        }

        // do outlier detection
        dataList.stream().forEach((d) -> {
            /**
             * Count preceeding neighbors
             */
            // System.out.println(d.values[0]);
            int pre = 0;
            pre = d.nn_before.stream().filter((nn_before) -> (nn_before.arrivalTime() > currentTime - windowSize)).map((_item) -> 1).reduce(pre, Integer::sum);
            if (pre + d.count_after < minNeighborCount) {
                outliers.add(d);
            }
        }); // System.out.println("#outliers: "+count_outlier);

        //count the avg length of neighbors list
        for (DataStormObject d : dataList) {
            avgCurrentNeighbor += d.nn_before.size();
        }
        avgCurrentNeighbor = avgCurrentNeighbor / dataList.size();
        avgAllWindowNeighbor += avgCurrentNeighbor;

        MesureMemoryThread.timeForNewSlide += Utils.getCPUTime() - startTime;
        return outliers;

    }

    public void processFirstWindow(ArrayList<Data> data, int currentTime, int W, int slide) {
        for (Data d : data) {
            DataStormObject ob = new DataStormObject(d);
            mtree.add(ob);
            dataList.add(ob);
        }
        for (DataStormObject d : dataList) {
            MTreeClass.Query query = mtree.getNearestByRange(d, maxDistance);

            ArrayList<DataStormObject> queryResult = new ArrayList<>();
            for (MTreeClass.ResultItem ri : query) {
                queryResult.add((DataStormObject) ri.data);
                if (ri.distance == 0) {
                    d.values[0] += (new Random()).nextDouble() / 1000000;
                }
            }

            Collections.sort(queryResult, new DataStormComparator());
            for (DataStormObject dob : queryResult) {

                if (dob.arrivalTime() >= d.arrivalTime()) {
                    d.count_after++;
                } else if (dob.arrivalTime() >= currentTime - windowSize && dob.arrivalTime() < d.arrivalTime()) {
                    if (d.nn_before.size() < minNeighborCount) {
                        d.nn_before.add(dob);
                    }
                }
            }

        }
    }
}


class DataStormComparator implements Comparator<DataStormObject> {

    @Override
    public int compare(DataStormObject o1, DataStormObject o2) {
        if (o1.arrivalTime() < o2.arrivalTime()) {
            return 1;
        } else if (o1.arrivalTime() == o2.arrivalTime()) {
            return 0;
        } else {
            return -1;
        }
    }
}

class DataStormObject extends Data {

    public int count_after;
    public ArrayList<DataStormObject> nn_before;

    public double frac_before = 0;

    public DataStormObject(Data d) {
        super(d.arrivalTime(), d.values);
        nn_before = new ArrayList<>();
        this.values = d.values;

    }

}
