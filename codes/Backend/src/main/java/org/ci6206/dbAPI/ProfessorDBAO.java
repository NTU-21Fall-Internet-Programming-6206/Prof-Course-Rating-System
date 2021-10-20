package org.ci6206.dbAPI;

import java.sql.*;
import java.util.*;
import org.ci6206.model.Professor;

public class ProfessorDBAO {

    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://localhost:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "panzer123";

    public ProfessorDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in ProfessorDBAO: " + ex);
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

    public boolean addProfessor(Professor newProfessor) {
        boolean status = false;
        try {
            String insertStatement = "insert into Professors (professor_name, title, email_address) values (?, ?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newProfessor.getProfessorName());
            prepStmt.setString(2, newProfessor.getTitle());
            prepStmt.setString(3, newProfessor.getEmailAddress());
            

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


    public Professor findProfessorWithProfessorName(String professorName) {
        try {
            String selectStatement = "Select * from Professors where professor_name = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, professorName);


            ResultSet rs = prepStmt.executeQuery();
            
            Professor resultProfessor = null;
            if(rs.next()) {
                resultProfessor = new Professor(rs.getString("professor_name"), rs.getString("title"), rs.getString("email_address"));
            }

            prepStmt.close();
            releaseConnection();
            return resultProfessor;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

    public List<Professor> findAllProfessor() {
        try {
            String selectStatement = "Select * from Professors";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);

            ResultSet rs = prepStmt.executeQuery();
            
            List<Professor> allProfessor = new ArrayList<Professor>();
            while(rs.next()) {
                Professor currentProfessor = new Professor(rs.getString("professor_name"), rs.getString("title"), rs.getString("email_address"));
                allProfessor.add(currentProfessor);
            }

            prepStmt.close();
            releaseConnection();
            return allProfessor;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

}
