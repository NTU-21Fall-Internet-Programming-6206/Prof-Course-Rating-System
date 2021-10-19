package org.ci6206.model;

public class CourseCR {
    private String professorName;
    private String username;

    private String courseID;
    private int rating;
    private String comment;

    public CourseCR() {}

    public CourseCR(String professorName, String username, String courseID, int rating) {
        this.professorName = professorName;
        this.username = username;
        this.courseID = courseID;
        this.rating = rating;
    }

    public CourseCR(String professorName, String username, String courseID, int rating, String comment) {
        this.professorName = professorName;
        this.username = username;
        this.courseID = courseID;
        this.rating = rating;
        this.comment = comment;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getUsername() {
        return username;
    }

    public String getCourseID() {
        return courseID;
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

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
