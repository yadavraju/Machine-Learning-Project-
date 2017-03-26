/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nce.project;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author paras
 */
public class FeatureExtractionForTest {
    
     BufferedImage image;
    int count = 0;
    int red_bin = 0;
    int green_bin = 0;
    int blue_bin = 0;

    int bin_1 = 0;
    int bin_2 = 0;
    int bin_3 = 0;
    int bin_4 = 0;
    int bin_5 = 0;
    int bin_6 = 0;
    int bin_7 = 0;
    int bin_8 = 0;
    int total = 0;
    int actual_total = 0;

    ArrayList<String> features;
    
    public ArrayList<String> getBinFeatures(BufferedImage image) {

        for (int h = 1; h < image.getHeight(); h++) {
            for (int w = 1; w < image.getWidth(); w++) {
                Color color = new Color(image.getRGB(w, h));

                actual_total++;
                int green = color.getGreen();
                int red = color.getRed();
                int blue = color.getBlue();
                if (red != 200 && green != 200 && blue != 200) {
                    total++;
                    if (red < 127) {
                        red_bin = 0;
                    } else {
                        red_bin = 1;

                    }
                    if (green < 127) {
                        green_bin = 0;
                    } else {
                        green_bin = 1;

                    }
                    if (blue_bin < 127) {
                        blue_bin = 0;
                    } else {
                        blue_bin = 1;

                    }

                    if (red_bin == 0 && green_bin == 0 && blue_bin == 0) {
                        bin_1++;

                    } else if (red_bin == 0 && green_bin == 0 && blue_bin == 1) {
                        bin_2++;
                    } else if (red_bin == 0 && green_bin == 1 && blue_bin == 0) {
                        bin_3++;
                    } else if (red_bin == 0 && green_bin == 1 && blue_bin == 1) {
                        bin_4++;
                    } else if (red_bin == 1 && green_bin == 0 && blue_bin == 0) {
                        bin_5++;

                    } else if (red_bin == 1 && green_bin == 0 && blue_bin == 1) {
                        bin_6++;
                    } else if (red_bin == 1 && green_bin == 1 && blue_bin == 0) {
                        bin_7++;
                    } else {
                        bin_8++;
                    }
                }

            }
        }
        double bin1 = (double) bin_1 / (double) total;
        double bin2 = (double) bin_2 / (double) total;
        double bin3 = (double) bin_3 / (double) total;
        double bin4 = (double) bin_4 / (double) total;
        double bin5 = (double) bin_5 / (double) total;
        double bin6 = (double) bin_6 / (double) total;
        double bin7 = (double) bin_7 / (double) total;
        double bin8 = (double) bin_8 / (double) total;

        String t1 = new DecimalFormat("##.######").format(bin1);
        String t2 = new DecimalFormat("##.######").format(bin2);
        String t3 = new DecimalFormat("##.######").format(bin3);
        String t4 = new DecimalFormat("##.######").format(bin4);
        String t5 = new DecimalFormat("##.######").format(bin5);
        String t6 = new DecimalFormat("##.######").format(bin6);
        String t7 = new DecimalFormat("##.######").format(bin7);
        String t8 = new DecimalFormat("##.######").format(bin8);
        features = new ArrayList<String>();
        features.add(t1);
        features.add(t2);

        features.add(t3);
        features.add(t4);
        features.add(t5);
        features.add(t6);
        features.add(t7);
        features.add(t8);

	//	double[] features=new double[]{t1,t2,t3,t4,t5,t6,t7,t8};
        return features;
    }
    
}
