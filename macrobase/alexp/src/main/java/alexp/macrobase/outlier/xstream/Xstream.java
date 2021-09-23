/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 *    IsolationForest.java
 *    Copyright (C) 2012-16 University of Waikato, Hamilton, New Zealand
 *
 *    https://github.com/Waikato/weka-trunk
 *
 */
package alexp.macrobase.outlier.xstream;

import alexp.macrobase.outlier.MultiMetricClassifier;
import alexp.macrobase.outlier.Trainable;
import alexp.macrobase.outlier.Updatable;
import alexp.macrobase.utils.DataFrameUtils;
import alexp.macrobase.utils.MathUtils;
import static com.github.chen0040.data.utils.NumberUtils.toInt;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

public class Xstream extends MultiMetricClassifier implements Trainable, Updatable {

    // The subsample size
    private int subsampleSize = 256;

    // training set size, the maximum number of elements that will be used during the training (from the beginning of each batch)
    // can be used to avoid shuffling of all elements (during trees generation) in very big batches
    private int trainSize = 100000;
    private int k = 50;
    private int chains = 50;
    private int windows = 1;
    private int windowSize = 128;
    private int depth = 10;
    private boolean retrainOnEachInput = true;
    private String labelColumnName = "is_anomaly"; // This parameter has to be inherited by the MultiMetricClassifier
    private String subspaceColumnName = "subspaces";
    private String orderedWindow = "_WINDOW";
    // output of Classifier
    private DataFrame output;
    private DataFrame input;
    private boolean trainable = true;
    BufferedWriter writer;

    public Xstream(String[] columns) {
        super(columns);
    }

    /**
     * Builds the forest.
     */
    public void buildClassifier(List<double[]> instances) throws Exception {

    }
    public void run_xstream(String dataset){
        /*
        String command = "cmd";
        ProcessBuilder builder;
        Process p;
        try{
            for(int i = 0; i < -1; i++){
                windows = (trainSize*2 / windowSize);
                builder = new ProcessBuilder(command, "/C xstream --c="+chains+" --k="+k+" --rowstream --nwindows="+windows+" --scoringbatch="+windowSize+" --input=" +dataset);
                //builder = new ProcessBuilder(command, "/C xstream -h");
                builder.redirectErrorStream(true);
                builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                //System.out.println(builder.directory().toString());
                p = builder.start();
                
                p.waitFor();
            }

        }
        catch ( Exception e){
            System.out.println(e);
        }
        */
    }
    @Override
    public void train(DataFrame input) throws Exception {
        FileWriter fileWriter = new FileWriter("scores", false);
        fileWriter.close();
        String command = "cmd";
        ProcessBuilder builder;
        Process p;
        //buildClassifier(DataFrameUtils.toRowArray(input, columns));
        if(trainable){
                //windows = (trainSize*2 / windowSize);
                builder = new ProcessBuilder("./xstream",  "--c="+chains,"--k="+k,"--nwindows="+1,"--d="+depth,"--initsample="+ windowSize,"--scoringbatch="+windowSize);
                //builder = new ProcessBuilder(command, "/C xstream -h");
                builder.redirectErrorStream(true);
                builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                //System.out.println(builder.directory().toString());
                p = builder.start();
                
                OutputStream stdin = p.getOutputStream();
                InputStream stdout = p.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
                writer = new BufferedWriter(new OutputStreamWriter(stdin));
                /*
                for(int i=0; i < input.getNumRows(); i++){
                    for(int j=0; j < input.getRow(i).getVals().size(); j++){
                        writer.write((j+1) +":"+input.getRow(i).getVals().get(j).toString() + " ");
                     }
                     writer.write("\n");
                }
                writer.flush();
                
                Scanner scanner = new Scanner(stdout);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                */
                trainable = false;
        }
    }

    /**
     * Returns distribution of scores.
     */
    public double score(double[] inst) {
        return 0;
    }

    private void outputBuilder(DataFrame windowDF) {
        // IF Shingle is true, then the windowDF will be synchronized to the window Scores
        List<double[]> windowData = DataFrameUtils.toRowArray(windowDF, columns);
        double[] windowLabels = windowDF.getDoubleColumnByName(labelColumnName);
        double[] windowSubspaces = windowDF.getDoubleColumnByName(subspaceColumnName);
        List<double[]> synData = new ArrayList<>();
        double[] synLabels = new double[windowData.size()];
        double[] synSubspaces = new double[windowData.size()];
        for (int i = 0; i < windowData.size(); i++) {
            synData.add(windowData.get(i));
            synLabels[i] = windowLabels[i];
            synSubspaces[i] = windowSubspaces[i];
        }
        List<double[]> dimensions = new ArrayList<>();
        for (int d = 0; d < synData.get(0).length; d++) {
            double[] dimValues = new double[synData.size()];
            for (int i = 0; i < synData.size(); i++) {
                dimValues[i] = synData.get(i)[d];
            }
            dimensions.add(dimValues);
        }
        // Find the window order for each data point
        double[] windowOrder = new double[windowData.size()];
        for (int i = 0; i < windowOrder.length; i++) {
            windowOrder[i] = windows;
        }
        // Build the new partial output
        DataFrame tempDF = new DataFrame();
        if (output != null) {
            // add the feature columns
            for (int c = 0; c < columns.length; c++) {
                tempDF.addColumn(columns[c], ArrayUtils.addAll(output.getDoubleColumnByName(columns[c]), dimensions.get(c)));
            }
            // add the label (ground truth) column
            tempDF.addColumn(labelColumnName, ArrayUtils.addAll(output.getDoubleColumnByName(labelColumnName), synLabels));

            // add the subspace (ground truth) column
            tempDF.addColumn(subspaceColumnName, ArrayUtils.addAll(output.getDoubleColumnByName(subspaceColumnName), synSubspaces));
            // add the window order column
            tempDF.addColumn(orderedWindow, ArrayUtils.addAll(output.getDoubleColumnByName(orderedWindow), windowOrder));
            // update the new output
            output = tempDF.copy();
        } else {
            // add the feature columns
            for (int c = 0; c < columns.length; c++) {
                tempDF.addColumn(columns[c], dimensions.get(c));
            }
            // add the label (ground truth) column
            tempDF.addColumn(labelColumnName, synLabels);

            // add the subspace (ground truth) column
            tempDF.addColumn(subspaceColumnName, synSubspaces);
            // add the window order column
            tempDF.addColumn(orderedWindow, windowOrder);
            // update the new output
            output = tempDF.copy();
        }
    }
    
    @Override
    public void update(DataFrame input) throws Exception {
        if(!trainable){
                for(int i=0; i < input.getNumRows(); i++){
                    for(int j=input.getRow(i).getVals().size()-2; j > 1 ; j--){
                        writer.write((j+1) +":"+input.getRow(i).getVals().get(j).toString() + " ");
                     }
                    
                     writer.write("\n");
                }
                writer.flush();
        }
    }

    @Override
    public void process(DataFrame input) throws Exception {

        outputBuilder(input.copy());
    }

    public DataFrame getResults() {
       

        try {
            //output = input.copy();
            writer.write("END\n");
            writer.flush();

        } catch (IOException ex) {
            Logger.getLogger(Xstream.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[] resultColumn = new double[output.getNumRows()];

        try{
        TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) { 
            Logger.getLogger(Xstream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          File scores = new File("scores");
          Scanner scan = new Scanner(scores);
          int i = -1;
          System.out.println(scan.hasNextDouble());
          while (scan.hasNextDouble() && i < output.getNumRows()) {    
            double data = scan.nextDouble();          
            if(i!= -1) resultColumn[i] = -1 * data;
            i++;
          }
          scan.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        output.addColumn(outputColumnName, resultColumn);
        return output;
    }
    public void setSubsampleSize(int n) {
        subsampleSize = n;
    }
    public void setNumK(int n) {
        k = n;
    }
    public void setNumChains(int n){
        chains = n;
    }
    public void setNumWindows(int n){
        windows = n;
    }
    public void setWindowSize(int n){
        windowSize = n;
    }
    public void setTrainSize(int trainSize) {
        this.trainSize = trainSize;
    }
    public void setDepth(int depth){
        this.depth = depth;
    }
    public void setRetrainOnEachInput(boolean retrainOnEachInput) {
        this.retrainOnEachInput = retrainOnEachInput;
    }
    public void setInput(DataFrame inp){
        input = inp;
    }
    public void closeWriter() throws IOException{
        writer.close();
    }

}

    /**
     * Inner class for building and using an isolation tree.
     */

