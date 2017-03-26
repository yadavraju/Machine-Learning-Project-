package com.paddy.kmeans;
public class FindMinDistanceAmongThreeCluster {

	public int getMinimumDistance(double distance_with_cluster_first,
			double distance_with_cluster_second, double distance_with_cluster_third,double distance_with_cluster_fourth) {
		
		if (distance_with_cluster_first < distance_with_cluster_second
				&& distance_with_cluster_first < distance_with_cluster_third
                                && distance_with_cluster_first < distance_with_cluster_fourth) {
			return 1;

		} else if(distance_with_cluster_second < distance_with_cluster_first
				&& distance_with_cluster_second < distance_with_cluster_third
                                && distance_with_cluster_second < distance_with_cluster_fourth) {
			return 2;

		}else if(distance_with_cluster_third < distance_with_cluster_first
				&& distance_with_cluster_third < distance_with_cluster_second
                                && distance_with_cluster_third < distance_with_cluster_fourth) {
			return 3;

		}else{
			return 4;
		}
	}

}
