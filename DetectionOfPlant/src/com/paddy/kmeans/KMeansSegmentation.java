package com.paddy.kmeans;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class KMeansSegmentation {

    BufferedImage image;
    BufferedImage image1;
    BufferedImage cluster_image1;
    BufferedImage cluster_image2;
    BufferedImage cluster_image3;
    BufferedImage cluster_image4;
    CalculateDistance calculateDistance;
    FirstClusterModel f_ClusterModel;
    SecondClusterModel s_ClusterModel;
    ThirdClusterModel t_ClusterModel;
    FourthClusterModel fourth_ClusterModel;
    FindMinDistanceAmongThreeCluster minDistanceAmongThreeCluster;
    ArrayList<FirstClusterModel> firstModelList;
    ArrayList<SecondClusterModel> secondModelList;
    ArrayList<ThirdClusterModel> thirdModelList;
    CalculateCenterOfCluster calculateCenterOfCluster;
    double error = 0;
    int count = 0;
    ArrayList<BufferedImage> cluster_list=null;
    public ArrayList<BufferedImage> clustering( BufferedImage originalImage,BufferedImage im1,BufferedImage im2,BufferedImage im3,BufferedImage im4) {
        cluster_image1=im1;
        cluster_image2=im2;
        cluster_image3=im3;
        cluster_image4=im4;
        
        calculateDistance = new CalculateDistance();

        minDistanceAmongThreeCluster = new FindMinDistanceAmongThreeCluster();

        try {
            image=originalImage;
            
            //this loop calculates the center of the all three cluster
            /*do {
                int c1 = 0, c2 = 0, c3 = 0;
                count++;

                firstModelList = new ArrayList<FirstClusterModel>();
                secondModelList = new ArrayList<SecondClusterModel>();
                thirdModelList = new ArrayList<ThirdClusterModel>();

                for (int h = 1; h < image.getHeight(); h++) {
                    for (int w = 1; w < image.getWidth(); w++) {
                        // creating object of all three cluster model
                        f_ClusterModel = new FirstClusterModel();
                        s_ClusterModel = new SecondClusterModel();
                        t_ClusterModel = new ThirdClusterModel();

                        Color color = new Color(image.getRGB(w, h));
                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();

                        // calculating the distance with all the cluster's center
                        double distance_with_cluster_first = calculateDistance
                                .getDistance(red, green, blue, f_ClusterModel);
                        double distance_with_cluster_second = calculateDistance
                                .getDistance(red, green, blue, s_ClusterModel);
                        double distance_with_cluster_third = calculateDistance
                                .getDistance(red, green, blue, t_ClusterModel);

			// finding the minimum distance so that the pixel can add to
                        // that cluster
                        int distance = minDistanceAmongThreeCluster
                                .getMinimumDistance(distance_with_cluster_first,
                                        distance_with_cluster_second,
                                        distance_with_cluster_third);

                        if (distance == 1) {// if the return value is 1 meaning the
                            // given pixel is close to cluster first
                            f_ClusterModel.setRed(red);
                            f_ClusterModel.setGreen(green);
                            f_ClusterModel.setBlue(blue);
                            firstModelList.add(f_ClusterModel);
                            c1++;

                        } else if (distance == 2) {// if the return value is 2
                            // meaning the given pixel is
                            // close to cluster second
                            s_ClusterModel.setRed(red);
                            s_ClusterModel.setGreen(green);
                            s_ClusterModel.setBlue(blue);
                            secondModelList.add(s_ClusterModel);
                            c2++;

                        } else if (distance == 3) {// if the return value is 3
                            // meaning the given pixel is
                            // close to cluster third
                            t_ClusterModel.setRed(red);
                            t_ClusterModel.setGreen(green);
                            t_ClusterModel.setBlue(blue);
                            thirdModelList.add(t_ClusterModel);
                            c3++;

                        }

                    }// end width loop
                }// end height loop   c1=45203and c2=57901and c3=10878==113982

                // now time to find the new center of all three cluster (r,g.b)
                calculateCenterOfCluster = new CalculateCenterOfCluster();
                double error1 = calculateCenterOfCluster.calculateCenterOfFirstCluster(firstModelList);
                double error2 = calculateCenterOfCluster.calculateCenterOfSecondCluster(secondModelList);
                double error3 = calculateCenterOfCluster.calculateCenterOfThirdCluster(thirdModelList);
                error = (error1 + error2 + error3) / 3;

                System.out.println("error=" + error);
                System.out.println("c1=" + c1 + "and c2=" + c2 + "and c3=" + c3);

            } while (error >= 0.001);// end of the clustering process
            //print the new center of all three cluster
            System.out.println(FirstClusterModel.c1_red+','+FirstClusterModel.c1_green+','+FirstClusterModel.c1_blue);
            System.out.println(SecondClusterModel.c2_red+','+SecondClusterModel.c2_green+','+SecondClusterModel.c2_blue);
            System.out.println(ThirdClusterModel.c3_red+','+ThirdClusterModel.c3_green+','+ThirdClusterModel.c3_blue);
            */
            int t = 0, t1 = 0, t2 = 0;
            // now time to print the image of the cluster
            image1=originalImage;
   
            f_ClusterModel = new FirstClusterModel();
            s_ClusterModel = new SecondClusterModel();
            t_ClusterModel = new ThirdClusterModel();
            fourth_ClusterModel=new FourthClusterModel();
            cluster_list=new ArrayList<BufferedImage>();
            for(int h = 1; h < image1.getHeight(); h++) {
                for (int w = 1; w < image1.getWidth(); w++) {
                    Color color1 = new Color(image1.getRGB(w, h));
                    int red = color1.getRed();
                    int green = color1.getGreen();
                    int blue = color1.getBlue();

                    //calculating the distance with all the cluster's center
                    double distance_with_cluster_first = calculateDistance
                            .getDistance(red, green, blue, f_ClusterModel);
                    double distance_with_cluster_second = calculateDistance
                            .getDistance(red, green, blue, s_ClusterModel);
                    double distance_with_cluster_third = calculateDistance
                            .getDistance(red, green, blue, t_ClusterModel);
                    double distance_with_cluster_fouth = calculateDistance
                            .getDistance(red, green, blue, fourth_ClusterModel);
                    

		    // finding the minimum distance so that the pixel can add to
                    // that cluster
                    int cluster_value = minDistanceAmongThreeCluster
                            .getMinimumDistance(distance_with_cluster_first,
                                    distance_with_cluster_second,
                                    distance_with_cluster_third,
                                    distance_with_cluster_fouth);

                    if (cluster_value == 1) {// if the return value is 1 meaning the
                        // given pixel is close to cluster first
                        Color newColor = new Color(0,0,0);// set black if the pixels close to first cluster

                       // image1.setRGB(w, h, newColor.getRGB());
                        cluster_image1.setRGB(w, h, newColor.getRGB());
                        
                       
                    } else if (cluster_value == 2) {// if the return value is 2
                       
                        // meaning the given pixel is
                        // close to cluster second
                       Color newColor = new Color(0,0,0);// set black if the pixels close to second cluster

                      
                        cluster_image2.setRGB(w, h, newColor.getRGB());
                        

                    } else if (cluster_value == 3) {// if the return value is 3
                        // meaning the given pixel is close to cluster third
                        Color newColor = new Color(0,0,0);// set black if the pixels close to third cluster

                     
                        cluster_image3.setRGB(w, h, newColor.getRGB());
                        
                       
                    }
                    else if (cluster_value == 4) {// if the return value is 3
                        // meaning the given pixel is close to cluster fourth
                        Color newColor = new Color(0,0,0);// set black if the pixels close to third cluster

                        cluster_image4.setRGB(w, h, newColor.getRGB());
                        
                         t2++;

                    }

                }//end width loop
            }//end height loop
            cluster_list.add(cluster_image1);
            cluster_list.add(cluster_image2);
            cluster_list.add(cluster_image3);
            cluster_list.add(cluster_image4);
           
            System.out.println(count);
            System.out.println("cluster 1 count="+t+"and 2 count="+t1+"and third="+t2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     return cluster_list;
    }

}
