package org.ci6206.dbAPI;

import java.sql.*;
import org.ci6206.model.Token;

public class TokenDBAO {
    Connection con;
    private boolean conFree = true;

    // Database configuration
    public static String url = "jdbc:mysql://localhost:3306/prof_course_rating_system";
    public static String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "panzer123";

    public TokenDBAO() throws Exception {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.out.println("Exception in TokenDBAO: " + ex);
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

    public boolean addToken(Token newToken) {
        boolean status = false;
        try {
            String insertStatement = "insert into Token (username, token) values (?, ?)";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(insertStatement);
            prepStmt.setString(1, newToken.getUsername());
            prepStmt.setString(2, newToken.getToken());

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

    public Token findTokenWithUsername(String username) {
        try {
            String selectStatement = "Select * from Token where username = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, username);


            ResultSet rs = prepStmt.executeQuery();
            
            Token resultToken = null;
            if(rs.next()) {
                resultToken = new Token(rs.getString("username"), rs.getString("token"));
            }

            
            prepStmt.close();
            releaseConnection();
            return resultToken;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }

    public Token findUsernameWithToken(String token) {
        try {
            String selectStatement = "Select * from Token where token = ?";
            getConnection();

            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, token);


            ResultSet rs = prepStmt.executeQuery();
            
            Token resultToken = null;
            if(rs.next()) {
                resultToken = new Token(rs.getString("username"), rs.getString("token"));
            }

            
            prepStmt.close();
            releaseConnection();
            return resultToken;

        } catch (SQLException ex) {
            releaseConnection();
            ex.printStackTrace();
        }
        return null;
    }
}
