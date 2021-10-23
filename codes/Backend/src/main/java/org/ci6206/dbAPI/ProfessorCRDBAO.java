package org.ci6206.dbAPI;

import java.sql.*;
import java.util.*;
import org.ci6206.model.ProfessorCR;

public class ProfessorCRDBAO {

    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://rm-t4ny77i38s58u80cq9o.mysql.singapore.rds.aliyuncs.com:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "ci6206";
    public static String password = "ci6206wudi*";

    public ProfessorCRDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in ProfessorCRDBAO: " + ex);
            throw new Exception("Couldn't open connection to database: " + ex.getMessage());
        }
    }

    public void remove() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected synchronized Connection getConnection() {
        while (conFree == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        conFree = false;
        notify();

        return con;
    }

    protected synchronized void releaseConnection() {
        while (conFree == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        conFree = true;
        notify();
    }

    
    public boolean addProfessorCR(ProfessorCR newProfessorCR) {
        boolean status = false;
        try {
            String insertStatement = "insert into CR_on_professor (professor_name, username, rate, comment) values (?, ?, ?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newProfessorCR.getProfessorName());
            prepStmt.setString(2, newProfessorCR.getUsername());
            prepStmt.setInt(3, newProfessorCR.getRating());
            prepStmt.setString(4, newProfessorCR.getComment());

            int rs = prepStmt.executeUpdate();
            status = true;

            System.out.println(rs);
            prepStmt.close();
            releaseConnection();

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return status;
    }


    public List<ProfessorCR> findProfessorCRWithProfessorName(String professorName) {
        try {
            String selectStatement = "Select * from CR_on_professor where professor_name = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, professorName);


            ResultSet rs = prepStmt.executeQuery();
            
            List<ProfessorCR> rsProfessorCR = new ArrayList<ProfessorCR>();
            while(rs.next()) {
                ProfessorCR currentProfessorCR = new ProfessorCR(rs.getString("professor_name"), 
                                                        rs.getString("username"), 
                                                        rs.getInt("rate"), 
                                                        rs.getString("comment"));
                rsProfessorCR.add(currentProfessorCR);
            }

            prepStmt.close();
            releaseConnection();
            return rsProfessorCR;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteProfessorCRWithProfessorNameAndUsername(String professor_name, String username) {
        boolean status = false;
        try {
            String selectStatement = "delete from cr_on_professor where professor_name = ? and username = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, professor_name);
            prepStmt.setString(2, username);


            int rs = prepStmt.executeUpdate();
            
            status = true;

            prepStmt.close();
            releaseConnection();
            return status;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return status;
    }
}