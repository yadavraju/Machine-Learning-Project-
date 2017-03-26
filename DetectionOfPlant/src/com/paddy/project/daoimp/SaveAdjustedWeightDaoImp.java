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


public class SaveAdjustedWeightDaoImp {
    Connection con=null;
    PreparedStatement ps=null;
    int rs=0;
    PreparedStatement ps1=null;
    int rs1=0;
    PreparedStatement ps2=null;
    ResultSet rs2=null;
    PreparedStatement ps3=null;
    ResultSet rs3=null;
    int rs4=0;
    int rs5=0;
int k=0;
    public boolean saveWeightAtHiddenLayer(double[][] weight_at_hidden_layer) {
   
    
      con=DBConnection.getConnention();
      boolean weight_already_exist=false;
       try {
            ps2=con.prepareStatement("select * from adjusted_weight_at_hidden_layer ");
            rs2=ps2.executeQuery();
            if(rs2.next()){
            weight_already_exist=true;
            }
             ps2=null;
             rs2=null;
        } catch (Exception e) {
        }
        if(weight_already_exist){
            try {
                //delete all the weight for resaving the new adjusted weight
                ps2=con.prepareStatement("delete adjusted_weight_at_hidden_layer from adjusted_weight_at_hidden_layer ");
                rs5=ps2.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(SaveAdjustedWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
      
      
        try {
            for(int i=0;i<weight_at_hidden_layer.length;i++){
                k++;
                System.out.println("at"+k);
            ps=con.prepareStatement("insert into adjusted_weight_at_hidden_layer(id,w1,w2,w3,w4,w5,w6,w7,w8) values(null,?,?,?,?,?,?,?,?) ");
            
            String w1=String.valueOf(weight_at_hidden_layer[i][0]);
            String w2=String.valueOf(weight_at_hidden_layer[i][1]);
            String w3=String.valueOf(weight_at_hidden_layer[i][2]);
            String w4=String.valueOf(weight_at_hidden_layer[i][3]);
            String w5=String.valueOf(weight_at_hidden_layer[i][4]);
            String w6=String.valueOf(weight_at_hidden_layer[i][5]);
            String w7=String.valueOf(weight_at_hidden_layer[i][6]);
            String w8=String.valueOf(weight_at_hidden_layer[i][7]);
            ps.setString(1,w1);
            ps.setString(2,w2);
            ps.setString(3,w3);
            ps.setString(4,w4);
            ps.setString(5,w5);
            ps.setString(6,w6);
            ps.setString(7,w7);
            ps.setString(8,w8);
            rs=ps.executeUpdate();
            ps=null;
            
            }
            if(rs>0){
                con.close();
                return true;
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SaveAdjustedWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }

    public boolean saveWeightAtOutputLayer(double[] weight_at_output_layer) {
        boolean weight_already_exist=false;
       con = DBConnection.getConnention();
        try {
            ps3=con.prepareStatement("select * from adjusted_weight_at_output_layer ");
            rs3=ps3.executeQuery();
            if(rs3.next()){
            weight_already_exist=true;
            }
             ps3=null;
             rs3=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(weight_already_exist){
            try {
                //delete all the weight for resaving the new adjusted weight
                ps3=con.prepareStatement("delete adjusted_weight_at_output_layer from adjusted_weight_at_output_layer ");
                rs4=ps3.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(SaveAdjustedWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        try {
            ps1=con.prepareStatement("insert into adjusted_weight_at_output_layer(w1,w2,w3,w4,w5,w6,w7,w8) values(?,?,?,?,?,?,?,?) ");
            for(int i=0;i<weight_at_output_layer.length;i++){
            String weight=String.valueOf(weight_at_output_layer[i]);
            ps1.setString(i+1, weight);
            }
          rs1=ps1.executeUpdate();
        if(rs1>0){
        return true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(SaveAdjustedWeightDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
}
