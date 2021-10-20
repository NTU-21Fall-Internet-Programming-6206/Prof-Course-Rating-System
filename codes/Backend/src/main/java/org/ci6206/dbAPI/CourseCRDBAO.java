package org.ci6206.dbAPI;

import java.sql.*;
import java.util.*;
import org.ci6206.model.CourseCR;

public class CourseCRDBAO {

    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://localhost:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "panzer123";

    public CourseCRDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in CourseCRDBAO: " + ex);
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

    public boolean addCourseCR(CourseCR newCourseCR) {
        boolean status = false;
        try {
            String insertStatement = "insert into CR_on_Course (professor_name, username, course_id, rate, comment) values (?, ?, ?, ?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newCourseCR.getProfessorName());
            prepStmt.setString(2, newCourseCR.getUsername());
            prepStmt.setString(3, newCourseCR.getCourseID());
            prepStmt.setInt(4, newCourseCR.getRating());
            prepStmt.setString(5, newCourseCR.getComment());
            

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


    public List<CourseCR> findCourseCRWithCourseId(String CourseId) {
        try {
            String selectStatement = "Select * from CR_on_Course where course_id = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, CourseId);


            ResultSet rs = prepStmt.executeQuery();
            
            List<CourseCR> rsCourseCR = new ArrayList<CourseCR>();
            while(rs.next()) {
                CourseCR currentCourseCR = new CourseCR(rs.getString("professor_name"), 
                                                        rs.getString("username"), 
                                                        rs.getString("course_id"), 
                                                        rs.getInt("rate"), 
                                                        rs.getString("comment"));
                rsCourseCR.add(currentCourseCR);
            }

            prepStmt.close();
            releaseConnection();
            return rsCourseCR;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteCourseCRWithCourseIdAndUsername(String courseId, String username) {
        boolean status = false;
        try {
            String selectStatement = "delete from cr_on_course where course_id = ? and username = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, courseId);
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