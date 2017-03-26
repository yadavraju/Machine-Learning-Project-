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
import java.util.ArrayList;

/**
 *
 * @author Raju
 */
public class FeaturesSaveDaoImp {

    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    ResultSet rs1 = null;

    int rs2 = 0;
    int rs = 0;
    Connection con;
     boolean alreadyDiseaseInDataBase = false;

    public boolean saveFeatures(String disease_name, ArrayList<String> bin_feature, int disease_image_count) {
        con = DBConnection.getConnention();
        System.out.println(disease_image_count);

        
            if (disease_image_count == 1) {   // checking the first entry to database 
               try{
                ps1 = con.prepareStatement("select Disease_name from FeatureTable");
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    String name = rs1.getString("Disease_name");
                    if (name.equalsIgnoreCase(disease_name)) {// checking if same disease is in database
                        alreadyDiseaseInDataBase = true;
                        break;
                    }
                    else{
                        alreadyDiseaseInDataBase=false;
                    }
                }
               }catch(Exception e){
               e.printStackTrace();
               }
                try{
                if (alreadyDiseaseInDataBase) {
                    
                    ps2 = con.prepareStatement("delete featuretable  from featuretable   where Disease_name in('"+disease_name+"')");
                    rs2 = ps2.executeUpdate();
                   

                }
                }catch(Exception e){
                e.printStackTrace();
                }

            }
             try{
            ps = con.prepareStatement("insert into FeatureTable(Disease_name,bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8) values(?,?,?,?,?,?,?,?,?) ");
            ps.setString(1, disease_name);

            for (int i = 0; i < bin_feature.size(); i++) {

                ps.setString(i + 2, bin_feature.get(i).toString());
            }
            rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
                }catch(Exception e){
                e.printStackTrace();
                }

        
        return false;

    }

}
