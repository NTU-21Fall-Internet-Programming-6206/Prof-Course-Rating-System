package org.ci6206.model;

public class Professor {
    private String professorName;
    private String title;
    private String emailAddress;

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
}
