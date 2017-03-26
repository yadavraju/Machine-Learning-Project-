/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.project.neuralnetwork;

import com.paddy.project.daoimp.SaveAdjustedWeightDaoImp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackPropagationNeuralNetwork {

    public int no_of_hidden_neuron = 8;
    public int no_of_pattern=0;
    public int no_of_input_index = 8;
    public double[] input_to_hidden_layer;
    public double input_to_output_layer;
    public double[] output_of_hidden_layer;
    public double output_of_output_layer;
    public double[] error;
    public static double total_error = 0.0;
    public double LEARNING_RATE = 0.1;
    int total_iteration = 0;
    double[] input_of_hidden_neuron = new double[no_of_hidden_neuron];
    static double[][] weight_at_hidden_layerr=null;
    static double[][] momentum_at_hidden_layerr=new double[8][8];
    
    static double[] weight_at_output_layerr=null;
    static double[] momentum_at_output_layerr = new double[8];
    
    double BETA = 0.95;
    double[][] inputFeature=null;
    double[] target_output=null;
    
    boolean useAdaptive =false;
    boolean useMomentum = false;
    
    SaveAdjustedWeightDaoImp saveAdjustedWt;
    public BackPropagationNeuralNetwork(int no_of_pattern) {
        this.no_of_pattern=no_of_pattern;
         System.out.println(no_of_pattern);
        error = new double[no_of_pattern];  
    }
    public boolean trainNeuralNetwork(double[][] inputFeature, double[][] weight_at_hidden_layer, double[] weight_at_output_layer, double[] target_output){
        this.weight_at_hidden_layerr=weight_at_hidden_layer;
        this.weight_at_output_layerr=weight_at_output_layer;
        this.inputFeature=inputFeature;
        this.target_output=target_output;
        
        // Open a text file!
//        BufferedWriter chart_file = null;
//        try
//        {
//            FileWriter fstream = new FileWriter("D:/log.csv", false);  //false means don't append
//            chart_file = new BufferedWriter(fstream);
//        }
//        catch (IOException e){
//            System.err.println("Error: " + e.getMessage());
//        }
        
        
        
        double last_error = 0.0;
        
        for (int p = 0; p < no_of_pattern; p++) {
        
            calculateHiddenLayerOutPut(p);
            calculateOutputLayerOutPut(p);
            doBackpropagation(p);

        }

        total_error = calculateTotalError();
        last_error = total_error;
        
//        try {
//            // Write in file total_iteration, total_error
//            chart_file.write(String.valueOf(total_iteration) + ", " + String.valueOf(total_error) + "\n");
//        } catch (IOException ex) {
//            Logger.getLogger(BackPropagationNeuralNetwork.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        while (total_error >= 0.0363) {
            total_iteration++;
            for (int p = 0; p < no_of_pattern; p++) {
           
                calculateHiddenLayerOutPut(p);
                calculateOutputLayerOutPut(p);
                doBackpropagation(p);

            }
            total_error = calculateTotalError();
            System.out.println("total_error-----------------------------"+total_error);
            
//            try {
//                // Write in file total_iteration, total_error
//                chart_file.write(String.valueOf(total_iteration) + ", " + String.valueOf(total_error) + "\n");
//            } catch (IOException ex) {
//                Logger.getLogger(BackPropagationNeuralNetwork.class.getName()).log(Level.SEVERE, null, ex);
//            }
            if (useAdaptive){
                if (total_error/last_error > 1.04){
                    LEARNING_RATE *= 0.7;
                } else {
                    LEARNING_RATE *= 1.05;
                }
                last_error = total_error;
            }            
        }
        //save adjusted weight at database
       saveAdjustedWt=new SaveAdjustedWeightDaoImp();
       boolean wtStatus=saveAdjustedWt.saveWeightAtHiddenLayer(weight_at_hidden_layerr);
       boolean wt_at_output_status=saveAdjustedWt.saveWeightAtOutputLayer(weight_at_output_layerr);
       System.out.println("total epochs=" + total_iteration);
//        try {
//            chart_file.close();
//            //close file
//        } catch (IOException ex) {
//            Logger.getLogger(BackPropagationNeuralNetwork.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
       if(wt_at_output_status){
       return true;
       }
        
  return false;
  }
   

    private void calculateHiddenLayerOutPut( int p) {

        input_to_hidden_layer = new double[no_of_hidden_neuron];
        output_of_hidden_layer = new double[no_of_hidden_neuron];
        // hidden layer loop starting
        for (int h = 0; h < no_of_hidden_neuron; h++) {
            input_to_hidden_layer[h] = 0;
            // input index loop
            for (int in = 0; in < no_of_input_index; in++) {
                input_to_hidden_layer[h] = input_to_hidden_layer[h]
                        + weight_at_hidden_layerr[in][h] * inputFeature[p][in];

            }
            output_of_hidden_layer[h] = 1 / (1 + Math
                    .exp(-input_to_hidden_layer[h]));

        }
		// input_to_hidden_layer = null;

    }

    private void calculateOutputLayerOutPut(int p) {

        input_to_output_layer = 0.0;

        for (int h = 0; h < no_of_hidden_neuron; h++) {

            input_to_output_layer = input_to_output_layer
                    + weight_at_output_layerr[h] * output_of_hidden_layer[h];

        }

        output_of_output_layer = 1 / (1 + Math.exp(-input_to_output_layer));

        error[p] = target_output[p] - output_of_output_layer;
        if (p == 0) {
            System.out.println("atp0=" + output_of_output_layer);
        }
        if (p == 7) {
            System.out.println("atp7=" + output_of_output_layer);
        }
        if (p == 8) {
            System.out.println("atp8=" + output_of_output_layer);
        }
        if (p == 15) {
            System.out.println("atp15=" + output_of_output_layer);
        }
        if (p == 16) {
            System.out.println("atp16=" + output_of_output_layer);
        }
        if (p == 23) {
            System.out.println("atp23=" + output_of_output_layer);
        }
        if (p == 24) {
            System.out.println("atp24=" + output_of_output_layer);
        }
        if (p == 31) {
            System.out.println("atp31=" + output_of_output_layer);
        }
        if (p == 32) {
            System.out.println("atp32=" + output_of_output_layer);
        }
        if (p == 39) {
            System.out.println("atp39=" + output_of_output_layer);
        }
        if (p == 40) {
            System.out.println("atp40=" + output_of_output_layer);
        }
        if (p == 47) {
            System.out.println("atp47=" + output_of_output_layer);
        }
        if (p == 48) {
            System.out.println("atp48=" + output_of_output_layer);
        }
        if (p == 55) {
            System.out.println("atp55=" + output_of_output_layer);
        }
        if (p == 56) {
            System.out.println("atp56=" + output_of_output_layer);
        }
        if (p == 63) {
            System.out.println("atp63=" + output_of_output_layer);
        }

    }

    private void doBackpropagation(int p) {

        // hidden layer loop starting
        for (int h = 0; h < no_of_hidden_neuron; h++) {
            // adjusting weight at output layer
            double temp_weight = LEARNING_RATE * error[p]
                    * output_of_hidden_layer[h] * output_of_output_layer
                    * (1 - output_of_output_layer);
            double temp_weight_with_momentum = temp_weight + BETA * momentum_at_output_layerr[h];
            if (useMomentum){
                weight_at_output_layerr[h] = weight_at_output_layerr[h] + temp_weight_with_momentum;
            }else {
                weight_at_output_layerr[h] = weight_at_output_layerr[h] + temp_weight;
            }
            momentum_at_output_layerr[h] = temp_weight;

        }
        // hidden layer loop starting
        for (int h = 0; h < no_of_hidden_neuron; h++) {
            // input index loop
            for (int in = 0; in < no_of_input_index; in++) {
                double temp_weight = LEARNING_RATE * error[p] * inputFeature[p][in]
                        * output_of_hidden_layer[h]
                        * (1 - output_of_hidden_layer[h]);
                double temp_weight_with_momentum = temp_weight + BETA * momentum_at_hidden_layerr[in][h];
                
                if (useMomentum){
                    weight_at_hidden_layerr[in][h] = weight_at_hidden_layerr[in][h]
                            + temp_weight_with_momentum;
                } else {
                    weight_at_hidden_layerr[in][h] = weight_at_hidden_layerr[in][h]
                            + temp_weight;
                }
                momentum_at_hidden_layerr[in][h] = temp_weight;

            }

        }

    }

    private double calculateTotalError() {
       double temp_total_error = 0.0;
		for (int i = 0; i < error.length; i++) {
			temp_total_error = temp_total_error + error[i] * error[i] * 0.01;
		}

		// total_error=temp_total_error/error.length;
		return temp_total_error;
    }

}
