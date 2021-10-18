package org.ci6206.model;

public class Student {
    private String username;
    private String emailAddress;

    private String password;
    private String salt;

    public Student(String username, String emailAddress, String password, String salt) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.salt = salt;
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
}
