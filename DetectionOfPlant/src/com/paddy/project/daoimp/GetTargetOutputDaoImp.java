/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.project.daoimp;

import com.paddy.DBConnection.DBConnection;
import com.paddy.project.model.InputPattern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GetTargetOutputDaoImp {

    PreparedStatement ps=null;
    ResultSet rs=null;
    PreparedStatement ps1=null;
    ResultSet rs1=null;
    Connection con=null;
    PreparedStatement ps3=null;
    ResultSet rs3=null;
    
   int k=0;
    int disease_count=0;
    int total_disease_image_count=0;
    String[] disease_name;
    int[] disesase_image_count;
    double[] TargetOutput;
    
    public double[] getTargetOutput()  {
        con=DBConnection.getConnention();
        try {
            ps=con.prepareStatement("select * from disease_count_table ");
            rs=ps.executeQuery();
           if(rs.next()){
            disease_count=rs.getInt("disease_count");
            }
           disease_name=new String[disease_count];
           disesase_image_count=new int[disease_count];
        }catch(SQLException e){
        e.printStackTrace();
        }
        try{
           ps1=con.prepareStatement("select disease_image_count,disease_name from disease_image_count_table ");
           rs1=ps1.executeQuery();
          for(int i=0;i<disease_count;i++){
          if(rs1.next()){
           disesase_image_count[i]=rs1.getInt("disease_image_count");
           total_disease_image_count=total_disease_image_count+disesase_image_count[i];
           disease_name[i]=rs1.getString("disease_name");
          }
          }
          //setting total no of pattern or images to model so that we can use it in future as total input pattern
            InputPattern iPattern=new InputPattern();
            iPattern.setTotal_input_pattern(total_disease_image_count);
        }
       catch (SQLException ex) {
            Logger.getLogger(GetTargetOutputDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            TargetOutput=new double[total_disease_image_count];
            for(int i=0;i<disease_count;i++){
            ps3=con.prepareStatement("select target_output from diseasetable where disease_name='"+disease_name[i]+"'");
            rs3=ps3.executeQuery();
            while(rs3.next()){
            String t_out=rs3.getString("target_output");
            double t_output=Double.valueOf(t_out);
             for(int j=0;j<disesase_image_count[i];j++)  {
                 TargetOutput[k]=t_output;
                 k++;
                 
             }
            }
            ps3=null;
            rs3=null;
            
            }
            if(k>0){
                
            return TargetOutput;
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    
    
}
