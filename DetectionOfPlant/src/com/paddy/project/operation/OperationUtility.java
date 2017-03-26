package com.paddy.project.operation;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paras
 */
public class OperationUtility {
    double percetMatched=0;
    
//calculating the index of list that contains minimum value
public int getIndex(ArrayList<Double> list){
    int index=list.indexOf(Collections.min(list));
    return index;
}

    public double getPercentageMatched(double out, double output) {
       if(out>output){
            percetMatched=(output/out)*100;
            }else{
             percetMatched=(out/output)*100;
            }
       return percetMatched ;
    }
    
    /**
     * this method will calculates the description about the clustered images ie percentage of most affected part
     * less affected part and non affected part
    */
    public List<Integer> getDescriptionOfClusteredImages(List<BufferedImage> listOfClusteredImage){
        int totalPixelcount=0,clusterFirstPixelCount=0,clusterSecondPixelCount=0,clusterThirdPixelCount=0,
            clusterFourthPixelCount=0;
        int affectedPercent;
        List<Integer> descriptionList=new ArrayList<Integer>();
        
        //index zero of listOfClusteredImage contains first cluster image 
        for(int h = 1; h < listOfClusteredImage.get(0).getHeight(); h++) {
            for (int w = 1; w < listOfClusteredImage.get(0).getWidth(); w++) {
                //we only calculate the total pixels of the image in first cluster and use in all cluster 
                //since every cluster's image has same number of pixel count
                totalPixelcount++;
                Color color = new Color(listOfClusteredImage.get(0).getRGB(w, h));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if(red==0 && green==0 && blue==0){
                    clusterFirstPixelCount++;
                }
            }
        }
        //calculate affected percentage of part of leaf in first cluster
        affectedPercent=(clusterFirstPixelCount*100)/totalPixelcount;
        descriptionList.add(affectedPercent);
        
        //index one of listOfClusteredImage contains second cluster image 
        for(int h = 1; h < listOfClusteredImage.get(1).getHeight(); h++) {
            for (int w = 1; w < listOfClusteredImage.get(1).getWidth(); w++) {
                Color color = new Color(listOfClusteredImage.get(1).getRGB(w, h));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if(red==0 && green==0 && blue==0){
                    clusterSecondPixelCount++;
                }
            }
        }
        //calculate affected percentage of part of leaf in second cluster
        affectedPercent=(clusterSecondPixelCount*100)/totalPixelcount;
        descriptionList.add(affectedPercent);
        
        //index two of listOfClusteredImage contains third cluster image 
        for(int h = 1; h < listOfClusteredImage.get(2).getHeight(); h++) {
            for (int w = 1; w < listOfClusteredImage.get(2).getWidth(); w++) {
                Color color = new Color(listOfClusteredImage.get(2).getRGB(w, h));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if(red==0 && green==0 && blue==0){
                    clusterThirdPixelCount++;
                }
            }
        }
        //calculate affected percentage of part of leaf in third cluster
        affectedPercent=(clusterThirdPixelCount*100/totalPixelcount);
        descriptionList.add(affectedPercent);
        
        //index third of listOfClusteredImage contains fourth cluster image 
        for(int h = 1; h < listOfClusteredImage.get(3).getHeight(); h++) {
            for (int w = 1; w < listOfClusteredImage.get(3).getWidth(); w++) {
                Color color = new Color(listOfClusteredImage.get(3).getRGB(w, h));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if(red==0 && green==0 && blue==0){
                    clusterFourthPixelCount++;
                }
            }
        }
        //calculate affected percentage of part of leaf in fourth cluster
        affectedPercent=(clusterFourthPixelCount*100/totalPixelcount);
        descriptionList.add(affectedPercent);
        
        if(descriptionList.size()>0){
            return descriptionList;
        }
        return null;
    }
    
}
