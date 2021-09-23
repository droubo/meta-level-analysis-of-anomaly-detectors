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
package alexp.macrobase.outlier.loda;

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
import org.apache.commons.lang3.ArrayUtils;

public class loda extends MultiMetricClassifier implements Trainable, Updatable {

    // The subsample size
    private int subsampleSize = 256;

    // training set size, the maximum number of elements that will be used during the training (from the beginning of each batch)
    // can be used to avoid shuffling of all elements (during trees generation) in very big batches
    private int trainSize = 100000;
    private int windows = 1;
    private int windowSize = 128;
    double latestWindowCounter = 1;
    private String labelColumnName = "is_anomaly"; // This parameter has to be inherited by the MultiMetricClassifier
    private String subspaceColumnName = "subspaces";
    private String orderedWindow = "_WINDOW";
    // output of Classifier
    private DataFrame output;
    BufferedWriter writer;

    public loda(String[] columns) {
        super(columns);
    }

    /**
     * Builds the forest.
     */
    public void buildClassifier(List<double[]> instances) throws Exception {

    }
    public void run_loda(String dataset) throws IOException{
        FileWriter fileWriter = new FileWriter("scores", false);
        fileWriter.close();
        String command = "cmd";
        ProcessBuilder builder;
        Process p;
        try{
            for(int i = 0; i < 1; i++){
                builder = new ProcessBuilder(command, "/C cd LODA_new && matlab.exe -wait -nosplash -nodesktop -nodisplay -nojvm -r \"run_loda C:\\Users\\Droubo\\Desktop\\MaBase\\macrobase\\" + dataset +" " + windowSize + " " + 128 + " \"dense\"  \"two-window\" 20 \"C:\\Users\\Droubo\\Desktop\\MaBase\\macrobase\\scores\"\";,quit; " + " && cd ..");
                
                builder.redirectErrorStream(true);
                builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                p = builder.start();
                
                p.waitFor();
            }

        }
        catch ( Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void train(DataFrame input) throws Exception {
        return;
    }

    /**
     * Returns distribution of scores.
     */
    public double score(double[] inst) {
        return 0;
    }

    private void outputBuilder(DataFrame windowDF) {
        
        double[] windowOrder = new double[128];
        for (int i = 0; i < windowOrder.length; i++) {
            
            windowOrder[i] = latestWindowCounter;
        }
        latestWindowCounter++;
        if (output != null) {
            DataFrame tempDF = new DataFrame();
            // add all feature columns
            for (String column : columns) {
                tempDF.addColumn(column, ArrayUtils.addAll(output.getDoubleColumnByName(column), windowDF.getDoubleColumnByName(column)));
            }
            // add the label (ground truth) column
            tempDF.addColumn(labelColumnName, ArrayUtils.addAll(output.getDoubleColumnByName(labelColumnName), windowDF.getDoubleColumnByName(labelColumnName)));

            // add the subspace (ground truth) column
            tempDF.addColumn(subspaceColumnName, ArrayUtils.addAll(output.getDoubleColumnByName(subspaceColumnName), windowDF.getDoubleColumnByName(subspaceColumnName)));

            // add the scores column
            //tempDF.addColumn(outputColumnName, ArrayUtils.addAll(output.getDoubleColumnByName(outputColumnName), windowScores));
            // add the window order column
            tempDF.addColumn(orderedWindow, ArrayUtils.addAll(output.getDoubleColumnByName(orderedWindow), windowOrder));
            output = tempDF.copy();
        } else {
            //windowDF.addColumn(outputColumnName, windowScores);
            windowDF.addColumn(orderedWindow, windowOrder);
            output = windowDF.copy();
        }
    }
    
    @Override
    public void update(DataFrame input) throws Exception {
        return;
    }

    @Override
    public void process(DataFrame input) throws Exception {

        outputBuilder(input.copy());
    }

    public DataFrame getResults() {
       

        //output = input.copy();

        double[] resultColumn = new double[output.getNumRows()];

        
        
        try {
          File scores = new File("scores");
          Scanner scan = new Scanner(scores);
          int i = 0;
          //scan.nextDouble();
          while (scan.hasNextDouble() && i < output.getNumRows()) {
            double data = scan.nextDouble();
            resultColumn[i] = -1 * data;
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
    public void setNumWindows(int n){
        windows = n;
    }
    public void setWindowSize(int n){
        windowSize = n;
    }
    public void setTrainSize(int trainSize) {
        this.trainSize = trainSize;
    }
    public void closeWriter() throws IOException{
        writer.close();
    }

}

    /**
     * Inner class for building and using an isolation tree.
     */

