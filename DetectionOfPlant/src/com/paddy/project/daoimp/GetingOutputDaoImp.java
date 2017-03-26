/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.project.daoimp;

import com.paddy.project.operation.OperationUtility;
import com.paddy.DBConnection.DBConnection;
import com.paddy.project.model.MatchingPercent;
import com.sun.corba.se.impl.util.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GetingOutputDaoImp {
    
    PreparedStatement ps=null;
    ResultSet rs=null;
    Connection con=null;
    ArrayList<Double> output_difference_list;
    ArrayList<String> storeDisease_Name;
    ArrayList<Double> storeDisease_Output;
    String outputDiseaeName=null;
    double percetMatched=0;
    MatchingPercent matchingPercent;
    OperationUtility Outility;
   
    
    public String getDetectedDiseaseName(double output){
    con=DBConnection.getConnention();
    output_difference_list=new ArrayList<Double>();
    storeDisease_Name=new ArrayList<String>();
    storeDisease_Output=new ArrayList<Double>();
    
   
        try {
            ps=con.prepareStatement("select disease_name,target_output from diseasetable");
            rs=ps.executeQuery();
            while(rs.next()){
            String name=rs.getString("disease_name");
            String target_output=rs.getString("target_output");
            double tOutput=Double.valueOf(target_output);
            storeDisease_Output.add(tOutput);
            storeDisease_Name.add(name);
            double d=tOutput-output;// calculating difference between calculated output and desired output to get minimum difference
            output_difference_list.add(Math.abs(d));
            }
            // get minimum difference value index in output_difference_list list 
            Outility=new OperationUtility();
            int minimum_value_index=Outility.getIndex(output_difference_list);
            
            outputDiseaeName=storeDisease_Name.get(minimum_value_index);//geting disease name of that selected index
            double out=storeDisease_Output.get(minimum_value_index);//get output value of selected index
            
            double percent_matched=Outility.getPercentageMatched(out,output);// get percentage matched
           
            
            matchingPercent=new MatchingPercent();
            matchingPercent.settMatchPercentage(percent_matched);// set matched percentage to some indermediate variable 
            
            if(outputDiseaeName!=null){// if disease name is not null
            return outputDiseaeName;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GetingOutputDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  return null;  
}
}