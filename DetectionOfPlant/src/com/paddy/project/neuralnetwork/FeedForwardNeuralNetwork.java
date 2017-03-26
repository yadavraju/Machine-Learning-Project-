/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.project.neuralnetwork;

import static com.paddy.project.neuralnetwork.BackPropagationNeuralNetwork.weight_at_hidden_layerr;
import static com.paddy.project.neuralnetwork.BackPropagationNeuralNetwork.weight_at_output_layerr;

/**
 *
 * @author paras
 */
public class FeedForwardNeuralNetwork {

    public int no_of_hidden_neuron = 8;
    public int no_of_input_index = 8;
    public double[] input_to_hidden_layer;
    public double input_to_output_layer;
    public double[] output_of_hidden_layer;
    public double output_of_output_layer;
    double[] input;
    double[][] weight_at_hidden_layer;
    double[] weight_at_output_layer;
   
    /**
     *
     * @param inputFeature
     * @param weight_at_hidden_layer
     * @param weight_at_ouput_layer
     * @return
     */
    public double testNeralNetwork(double[] inputFeature, double[][] weight_at_hidden_layer, double[] weight_at_ouput_layer) {
       this.input=inputFeature;
       this.weight_at_hidden_layer=weight_at_hidden_layer;
       this.weight_at_output_layer=weight_at_ouput_layer;
       for(double w:weight_at_ouput_layer){
       System.out.println(w);
       }
          calculateHiddenLayerOutPut();
          calculateOutputLayerOutPut();  
           
          return output_of_output_layer;
          
        
        
    }

    private void calculateHiddenLayerOutPut() {
        input_to_hidden_layer = new double[no_of_hidden_neuron];
        output_of_hidden_layer = new double[no_of_hidden_neuron];
        // hidden layer loop starting
        for (int h = 0; h < no_of_hidden_neuron; h++) {
            input_to_hidden_layer[h] = 0;
            // input index loop
            for (int in = 0; in < no_of_input_index; in++) {
                input_to_hidden_layer[h] = input_to_hidden_layer[h]
                        + weight_at_hidden_layer[in][h] * input[in];

            }
            output_of_hidden_layer[h] = 1 / (1 + Math
                    .exp(-input_to_hidden_layer[h]));

        }
	
       
    }

    private void calculateOutputLayerOutPut() {
      input_to_output_layer = 0.0;

        for (int h = 0; h < no_of_hidden_neuron; h++) {

            input_to_output_layer = input_to_output_layer
                    + weight_at_output_layer[h] * output_of_hidden_layer[h];

        }

        output_of_output_layer = 1 / (1 + Math.exp(-input_to_output_layer));
       System.out.println("output_of_output_layer");
       
    }
   
}
