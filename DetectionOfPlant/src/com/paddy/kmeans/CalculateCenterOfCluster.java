package com.paddy.kmeans;

import java.util.ArrayList;

public class CalculateCenterOfCluster {
	int center_red=0;
	int center_green=0;
	int center_blue=0;
	FirstClusterModel fm;
	SecondClusterModel sm;
	ThirdClusterModel tm;
	public double calculateCenterOfFirstCluster(ArrayList<FirstClusterModel> firstModelList) {

     for(int i=0;i<firstModelList.size();i++){
    	 //adding all the red , green and blue values correspondingly
    	 FirstClusterModel fModel=firstModelList.get(i);
    	 center_red=center_red+fModel.getRed();
    	 center_green=center_green+fModel.getGreen();
    	 center_blue=center_blue+fModel.getBlue();
    	 
     }
     //calculating the center  
     center_red=center_red/firstModelList.size();
     center_green=center_green/firstModelList.size();
     center_blue=center_blue/firstModelList.size();
     System.out.println("red of center="+center_red);
     fm=new FirstClusterModel();
     int red_difference=center_red-fm.getC1_red();
     int green_difference=center_green-fm.getC1_green();
     int blue_difference=center_blue-fm.getC1_blue();
     double error=Math.sqrt(red_difference*red_difference+green_difference*green_difference+blue_difference*blue_difference);
     
     fm.setC1_red(center_red);
     fm.setC1_green(center_green);
     fm.setC1_blue(center_blue);
     center_red=0;
     center_green=0;
     center_blue=0;
     
     return error;
     
	}
	public double calculateCenterOfSecondCluster(
			ArrayList<SecondClusterModel> secondModelList) {
		for(int i=0;i<secondModelList.size();i++){
			SecondClusterModel sModel=secondModelList.get(i);
	    	 center_red=center_red+sModel.getRed();
	    	 center_green=center_green+sModel.getGreen();
	    	 center_blue=center_green+sModel.getBlue();
	    	 
	     }
	     center_red=center_red/secondModelList.size();
	     center_green=center_green/secondModelList.size();
	     center_blue=center_blue/secondModelList.size();
	     sm=new SecondClusterModel();
	     int red_difference=center_red-sm.getC2_red();
	     int green_difference=center_green-sm.getC2_green();
	     int blue_difference=center_blue-sm.getC2_blue();
	     double error=Math.sqrt(red_difference*red_difference+green_difference*green_difference+blue_difference*blue_difference);

	     sm.setC2_red(center_red);
	     sm.setC2_green(center_green);
	     sm.setC2_blue(center_blue);


		center_red=0;
	     center_green=0;
	     center_blue=0;
	     return error;
		
	}
	public double calculateCenterOfThirdCluster(
			ArrayList<ThirdClusterModel> thirdModelList) {
		for(int i=0;i<thirdModelList.size();i++){
			ThirdClusterModel tModel=thirdModelList.get(i);
	    	 center_red=center_red+tModel.getRed();
	    	 center_green=center_green+tModel.getGreen();
	    	 center_blue=center_blue+tModel.getBlue();
	    	 
	     }
	     center_red=center_red/thirdModelList.size();
	     center_green=center_green/thirdModelList.size();
	     center_blue=center_blue/thirdModelList.size();
	     tm=new ThirdClusterModel();
	     int red_difference=center_red-tm.getC3_red();
	     int green_difference=center_green-tm.getC3_green();
	     int blue_difference=center_blue-tm.getC3_blue();
	     double error=Math.sqrt(red_difference*red_difference+green_difference*green_difference+blue_difference*blue_difference);

	     
	     tm.setC3_red(center_red);
	     tm.setC3_green(center_green);
	     tm.setC3_blue(center_blue);
		
		
		
		center_red=0;
	     center_green=0;
	      center_blue=0;
	      
	      return error;
		
	}

}
