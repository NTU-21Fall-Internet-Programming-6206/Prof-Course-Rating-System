package org.ci6206.model;

public class Course {
    private String courseID;
    private String professorName;
    private String courseName;

    public Course() {}

    public Course(String courseId, String professorName, String courseName) {
        this.courseID = courseId;
        this.professorName = professorName;
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
