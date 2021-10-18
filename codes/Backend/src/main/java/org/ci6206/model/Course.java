package org.ci6206.model;

public class Course {
    private String courseID;
    private String professorName;
    private String courseName;

    public Course(String courseID, String professorName, String courseName) {
        this.courseID = courseID;
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
}
