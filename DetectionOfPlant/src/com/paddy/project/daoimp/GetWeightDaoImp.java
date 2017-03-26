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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GetWeightDaoImp {

    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Connection con = null;
    double[][] weighta_at_hidden_layer=null;
    double[] weight_at_output_layer=null;

    public double[][] getWeightAtHiddenLayer() {
        double[][] weight_at_hidden_layer = new double[][]{
            {0.62, 0.42, 0.35, -0.12, 0.53, 0.75, 0.21, 0.82},
            {0.55, -0.17, 0.53, 0.49, 0.76, 0.59, 0.19, 0.20},
            {0.62, 0.42, 0.35, -0.12, 0.53, 0.75, 0.21, 0.82},
            {0.55, -0.17, 0.53, 0.49, 0.76, 0.59, 0.19, 0.20},
            {0.62, 0.42, 0.35, -0.12, 0.53, 0.75, 0.21, 0.82},
            {0.55, -0.17, 0.53, 0.49, 0.76, 0.59, 0.19, 0.20},
            {0.62, 0.42, 0.35, -0.12, 0.53, 0.75, 0.21, 0.82},
            {0.55, -0.17, 0.53, 0.49, 0.76, 0.59, 0.19, 0.20}};
        return weight_at_hidden_layer;
        }

        
    

    public double[] getWeightAtOutputLayer() {

        double[] weight_at_output_layer = new double[]{0.35, 0.81, 0.52, 0.71,0.52, 0.42, 0.36, 0.65};
        return weight_at_output_layer;
        }
    
    public double[][] getAdjustedWeightAtHiddenLayer(){
        con=DBConnection.getConnention();
        try {
            weighta_at_hidden_layer=new double[8][8];
            ps=con.prepareStatement("select * from adjusted_weight_at_hidden_layer");
            rs=ps.executeQuery();
            for(int i=0;i<8;i++){
            if(rs.next()){
            String weight1=rs.getString("w1");
            double w1=Double.valueOf(weight1);
            weighta_at_hidden_layer[i][0]=w1;
            String weight2=rs.getString("w2");
            double w2=Double.valueOf(weight2);
            weighta_at_hidden_layer[i][1]=w2;
            String weight3=rs.getString("w3");
            double w3=Double.valueOf(weight3);
            weighta_at_hidden_layer[i][2]=w3;
            String weight4=rs.getString("w4");
            double w4=Double.valueOf(weight4);
            weighta_at_hidden_layer[i][3]=w4;
            String weight5=rs.getString("w5");
            double w5=Double.valueOf(weight5);
            weighta_at_hidden_layer[i][4]=w5;
            String weight6=rs.getString("w6");
            double w6=Double.valueOf(weight6);
            weighta_at_hidden_layer[i][5]=w6;
            String weight7=rs.getString("w7");
            double w7=Double.valueOf(weight7);
            weighta_at_hidden_layer[i][6]=w7;
            String weight8=rs.getString("w8");
            double w8=Double.valueOf(weight8);
            weighta_at_hidden_layer[i][7]=w8;
                
                
            }
            }
            
            if(!rs.next()){
            return weighta_at_hidden_layer;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GetWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return null;
    }
    public double[] getAdjustedWeightAtOutputLayer(){
        try {
            weight_at_output_layer=new double[8];
            ps1=con.prepareStatement("select * from adjusted_weight_at_output_layer");
            rs1=ps1.executeQuery();
           
            while(rs1.next()){
                String weight1=rs1.getString("w1");
                double w1=Double.valueOf(weight1);
            weight_at_output_layer[0]=w1;
            String weight2=rs1.getString("w2");
                double w2=Double.valueOf(weight2);
            weight_at_output_layer[1]=w2;
             String weight3=rs1.getString("w3");
                double w3=Double.valueOf(weight3);
            weight_at_output_layer[2]=w3;
             String weight4=rs1.getString("w4");
                double w4=Double.valueOf(weight4);
            weight_at_output_layer[3]=w4;
             String weight5=rs1.getString("w5");
                double w5=Double.valueOf(weight5);
            weight_at_output_layer[4]=w5;
                 String weight6=rs1.getString("w6");
                double w6=Double.valueOf(weight6);
            weight_at_output_layer[5]=w6;
             String weight7=rs1.getString("w7");
                double w7=Double.valueOf(weight7);
            weight_at_output_layer[6]=w7;
             String weight8=rs1.getString("w8");
                double w8=Double.valueOf(weight8);
            weight_at_output_layer[7]=w8;
            }
            if(!rs1.next()){
            return weight_at_output_layer;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GetWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
        
        
        

    

}
