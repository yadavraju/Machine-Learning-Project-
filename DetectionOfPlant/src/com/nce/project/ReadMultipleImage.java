/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nce.project;

import com.paddy.project.daoimp.FeaturesSaveDaoImp;
import com.paddy.project.daoimp.SaveDiseaseCountDaoImp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author paras
 */
public class ReadMultipleImage {
    public static  File dir;
	static  String[] EXTENSIONS;
	static  FilenameFilter IMAGE_FILTER ;
	static FeaturesSaveDaoImp featureSaveDaoImp;
    
   public ReadMultipleImage(String directory){
       
                 System.out.println(directory+"/");
		dir = new File(directory+"/");
		EXTENSIONS = new String[]{"gif", "png", "bmp","jpg","JPG","PNG" };
		IMAGE_FILTER = new FilenameFilter() {

	        @Override
	        public boolean accept(final File dir, final String name) {
	            for (final String ext : EXTENSIONS) {
	                if (name.endsWith("." + ext)) {
	                    return (true);
	                }
	            }
	            return (false);
	        }
	    };
       
   } 
   
   public boolean extractAndSaveFeaures(int disease_count,String disease_name){
		//public static void main(String[] arg){
		
    	System.out.println("at extractAndSaveFeaures ");
        System.out.println(" disease count = "+disease_count);
        int disease_image_count=0;
        boolean flag=false;
         boolean dtest=false;
         boolean disease_image_count_status = false;
        if (dir.isDirectory()) { // make sure it's a directory
             featureSaveDaoImp=new FeaturesSaveDaoImp();
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                
            	disease_image_count++;
            
                BufferedImage img = null;
                FeatureExtractForTraining feature=new FeatureExtractForTraining();
                try {
                    img = ImageIO.read(f);

                    // you probably want something more involved here
                    // to display in your UI
                    /*System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());*/
                    ArrayList<String> bin_feature=feature.getBinFeatures(img); 
                    System.out.println(bin_feature);
                   
                    boolean ftest=featureSaveDaoImp.saveFeatures(disease_name,bin_feature,disease_image_count);//disease name can be taken from the drop down list
                    if(ftest){
                     flag=true;
                    }
                    else{
                        flag=false;
                    }
                    
                } catch (final IOException e) {
                    // handle errors here
                }
            }
             if(flag){
                 SaveDiseaseCountDaoImp s=new SaveDiseaseCountDaoImp();
                  disease_image_count_status= s.saveDiseaseImageCount(disease_image_count,disease_name);
                
                 if(disease_image_count_status){
                      dtest=s.saveDiseaseCount(disease_count);
               
                 }    
                 
              }
           
        }
       
        return dtest;
	}
   
    
    
}
