package org.ci6206.service;

import org.ci6206.model.Course;

import java.util.ArrayList;

public class CourseInfo {
    public ArrayList<Course> getInfo() {
        ArrayList<Course> courses = new ArrayList<>();
        // todo: search for all the courses from database, add them to courses
        return courses;
    }

    public Course getInfo(String courseName) {
        // todo: search for the course by its name
        Course course = new Course();
        return course;
    }
}
