package org.ci6206.dbAPI;

import java.sql.*;
import org.ci6206.model.Student;

public class StudentDBAO {

    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://localhost:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "panzer123";

    public StudentDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in StudentDBAO: " + ex);
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

    public boolean addStudent(Student newStudent) {
        boolean status = false;
        try {
            String insertStatement = "insert into Students (username, email_address, password, salt) values (?, ?, ?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newStudent.getUsername());
            prepStmt.setString(2, newStudent.getEmailAddress());
            prepStmt.setString(3, newStudent.getPassword());
            prepStmt.setString(4, newStudent.getSalt());

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


    public Student findStudentWithUsername(String username) {
        try {
            String selectStatement = "Select * from Students where username = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, username);


            ResultSet rs = prepStmt.executeQuery();
            
            Student resultStudent = null;
            if(rs.next()) {
                resultStudent = new Student(rs.getString("username"), rs.getString("email_address"));
                resultStudent.setPassword(rs.getString("password"));
                resultStudent.setSalt(rs.getString("salt"));
            }

            
            prepStmt.close();
            releaseConnection();
            return resultStudent;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }


}
