package org.ci6206.model;

public class ProfessorCR {
    private String professorName;
    private String username;

    private int rating;
    private String comment;

    public ProfessorCR() {}

    public ProfessorCR(String professorName, String username, int rating, String comment) {
        this.professorName = professorName;
        this.username = username;
        this.rating = rating;
        this.comment = comment;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
