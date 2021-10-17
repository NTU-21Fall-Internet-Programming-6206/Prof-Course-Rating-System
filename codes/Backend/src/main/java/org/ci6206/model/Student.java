package org.ci6206.model;

public class Student {
    private String username;
    private String password;
    private String emailAddress;
    private String salt;

    public Student(String username, String password, String emailAddress) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
