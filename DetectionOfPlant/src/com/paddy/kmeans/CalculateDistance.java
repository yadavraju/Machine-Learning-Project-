package com.paddy.kmeans;

public class CalculateDistance {
	double distance = 0;

	public double getDistance(int red, int green, int blue,
			FirstClusterModel f_clusterModel) {

		distance = Math.sqrt((Math.pow((red - f_clusterModel.getC1_red()), 2)
				+ Math.pow((green - f_clusterModel.getC1_green()), 2) + Math.pow(
				(blue - f_clusterModel.getC1_blue()), 2)));

		return distance;
	}

	public double getDistance(int red, int green, int blue,
			SecondClusterModel s_ClusterModel) {
		distance = Math.sqrt((Math.pow((red - s_ClusterModel.getC2_red()), 2)
				+ Math.pow((green - s_ClusterModel.getC2_green()), 2) + Math.pow(
				(blue - s_ClusterModel.getC2_blue()), 2)));

		return distance;
	}

	public double getDistance(int red, int green, int blue,
			ThirdClusterModel t_ClusterModel) {
		distance =  Math.sqrt((Math.pow((red - t_ClusterModel.getC3_red()), 2)
				+ Math.pow((green - t_ClusterModel.getC3_green()), 2) + Math.pow(
				(blue - t_ClusterModel.getC3_blue()), 2)));

		return distance;
	}
        
        public double getDistance(int red, int green, int blue,
			FourthClusterModel fourth_ClusterModel) {
		distance =  Math.sqrt((Math.pow((red - fourth_ClusterModel.getC4_red()), 2)
				+ Math.pow((green - fourth_ClusterModel.getC4_green()), 2) + Math.pow(
				(blue - fourth_ClusterModel.getC4_blue()), 2)));

		return distance;
	}

}
