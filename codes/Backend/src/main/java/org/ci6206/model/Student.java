package org.ci6206.model;

public class Student {
    private String username;
    private String emailAddress;

    private String password;
    private String salt;

    public Student() {}

    public Student(String username, String emailAddress) {
        this.username = username;
        this.emailAddress = emailAddress;
        
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}

