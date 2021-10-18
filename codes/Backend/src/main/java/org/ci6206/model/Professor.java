package org.ci6206.model;

public class Professor {
    private String professorName;
    private String title;
    private String emailAddress;

    public Professor() {}

    public Professor(String professorName, String title, String emailAddress) {
        this.professorName = professorName;
        this.title = title;
        this.emailAddress = emailAddress;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
