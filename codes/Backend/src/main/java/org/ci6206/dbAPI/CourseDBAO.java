package org.ci6206.dbAPI;

import java.sql.*;
import java.util.*;
import org.ci6206.model.Course;

public class CourseDBAO {

    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://rm-t4ny77i38s58u80cq9o.mysql.singapore.rds.aliyuncs.com:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "ci6206";
    public static String password = "ci6206wudi*";

    public CourseDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in CourseDBAO: " + ex);
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

    public boolean addCourse(Course newCourse) {
        boolean status = false;
        try {
            String insertStatement = "insert into Courses (course_id, Professor_name, Course_name) values (?, ?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newCourse.getCourseID());
            prepStmt.setString(2, newCourse.getProfessorName());
            prepStmt.setString(3, newCourse.getCourseName());
            

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


    public List<Course> findCourseWithCourseName(String CourseName) {
        try {
            String selectStatement = "Select * from Courses where Course_name = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, CourseName);


            ResultSet rs = prepStmt.executeQuery();
            
            List<Course> rsCourse = new ArrayList<Course>();
            while(rs.next()) {
                Course currentCourse = new Course(rs.getString("course_id"), rs.getString("professor_name"), rs.getString("course_name"));
                rsCourse.add(currentCourse);
            }

            prepStmt.close();
            releaseConnection();
            return rsCourse;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

    public List<Course> findCourseWithProfessorName(String professorName) {
        try {
            String selectStatement = "Select * from Courses where professor_name = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, professorName);


            ResultSet rs = prepStmt.executeQuery();
            
            List<Course> rsCourse = new ArrayList<Course>();
            while(rs.next()) {
                Course currentCourse = new Course(rs.getString("course_id"), rs.getString("professor_name"), rs.getString("course_name"));
                rsCourse.add(currentCourse);
            }

            prepStmt.close();
            releaseConnection();
            return rsCourse;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }


    public List<Course> findAllCourse() {
        try {
            String selectStatement = "Select * from Courses";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);

            ResultSet rs = prepStmt.executeQuery();
            
            List<Course> allCourse = new ArrayList<Course>();
            while(rs.next()) {
                Course currentCourse = new Course(rs.getString("course_id"), rs.getString("professor_name"), rs.getString("course_name"));
                allCourse.add(currentCourse);
            }

            prepStmt.close();
            releaseConnection();
            return allCourse;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

}
