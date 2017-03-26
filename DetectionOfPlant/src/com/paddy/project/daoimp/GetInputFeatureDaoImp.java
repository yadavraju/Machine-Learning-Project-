/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.project.daoimp;

import com.paddy.DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class GetInputFeatureDaoImp {
    PreparedStatement ps=null;
    ResultSet rs=null;
    PreparedStatement ps1=null;
    ResultSet rs1=null;
    Connection con=null;
    int total_feature_array=0;
    double[][] inputFeature;
    public double[][] getInputFeature() {
        con=DBConnection.getConnention();
         try {
            ps=con.prepareStatement(" select disease_image_count from disease_image_count_table ");
            rs=ps.executeQuery();
            while(rs.next()){
            total_feature_array=total_feature_array+rs.getInt("disease_image_count");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        try {
            inputFeature=new double[total_feature_array][8];
            ps1=con.prepareStatement("select bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8 from featuretable");
            rs1=ps1.executeQuery();
            for(int i=0;i<inputFeature.length;i++){
            if(rs1.next()){
            String bin_1=rs1.getString("bin1");
            double bin1=Double.valueOf(bin_1);
            inputFeature[i][0]=bin1;
            String bin_2=rs1.getString("bin2");
            double bin2=Double.valueOf(bin_2);
            inputFeature[i][1]=bin2;
            String bin_3=rs1.getString("bin3");
            double bin3=Double.valueOf(bin_3);
            inputFeature[i][2]=bin3;
            String bin_4=rs1.getString("bin4");
            double bin4=Double.valueOf(bin_4);
            inputFeature[i][3]=bin4;
            String bin_5=rs1.getString("bin5");
            double bin5=Double.valueOf(bin_5);
            inputFeature[i][4]=bin5;
            String bin_6=rs1.getString("bin6");
            double bin6=Double.valueOf(bin_6);
            inputFeature[i][5]=bin6;
            String bin_7=rs1.getString("bin7");
            double bin7=Double.valueOf(bin_7);
            inputFeature[i][6]=bin7;
            String bin_8=rs1.getString("bin8");
            double bin8=Double.valueOf(bin_8);
            inputFeature[i][7]=bin8;
            
            }
            
            }
            if(!rs1.next()){
            return inputFeature;
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    
    
    
}
