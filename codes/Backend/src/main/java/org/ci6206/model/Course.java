package org.ci6206.model;

public class Course {
    private String courseID;
    private String courseName;
    private String professorName;

    public Course(String courseID, String courseName, String professorName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.professorName = professorName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessorName() {
        return professorName;
    }
}
