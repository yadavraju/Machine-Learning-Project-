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


public class SaveDiseaseCountDaoImp {

    Connection con = null;
    int rs = 0;
    ResultSet rs1 = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
    PreparedStatement ps5=null;
    ResultSet rs5=null;
    ResultSet rs3 = null;
    int rs2 = 0;
    int rs4 = 0;
    int row_count=0;
    
    // saving no of images that the disease folder contains
    public boolean saveDiseaseImageCount(int disease_image_count, String disease_name) {
        con = DBConnection.getConnention();
        boolean disease_already = false;
        try {
            ps3 = con.prepareStatement("select * from disease_image_count_table ");
            rs3 = ps3.executeQuery();
            while (rs3.next()) {
                String dName = rs3.getString("disease_name");
                if (dName.equalsIgnoreCase(disease_name)) {
                    disease_already = true;
                    break;
                } else {
                    disease_already = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (disease_already) {//checking whether the same disease is in the database if yes then delete the data

            try {
                ps4 = con.prepareStatement("delete disease_image_count_table  from disease_image_count_table   where disease_name in('" + disease_name + "')");
                rs4 = ps4.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SaveDiseaseCountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        try {
            ps2 = con.prepareStatement("insert into disease_image_count_table(disease_image_count_id,disease_image_count,disease_name) values(null,?,?)");
            ps2.setInt(1, disease_image_count);
            ps2.setString(2, disease_name);
            rs2 = ps2.executeUpdate();
            if (rs2 > 0) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaveDiseaseCountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


    public boolean saveDiseaseCount(int disease_count) {
        con = DBConnection.getConnention();
        try {
            ps5=con.prepareStatement("select * from disease_image_count_table");
            rs5=ps5.executeQuery();
            while(rs5.next()){
            row_count++;
            }
        } catch (Exception e) {
        }
        
        try {
            ps = con.prepareStatement("select * from Disease_count_Table");
            rs1 = ps.executeQuery();
            if (!rs1.next()) {//if the table is empty then insert first
                ps1 = con.prepareStatement("insert into Disease_count_Table(disease_count) values(?) ");
                ps1.setInt(1, row_count);
                rs = ps1.executeUpdate();

            } else {// else update the table
                ps1 = con.prepareStatement("update Disease_count_Table set disease_count= " + row_count + " ");
                rs = ps1.executeUpdate();
            }
            if (rs > 0) {
                con.close();
                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(SaveDiseaseCountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    
}
