package org.ci6206.service;

import org.ci6206.model.Course;
import org.ci6206.util.MD5Util;

import java.util.ArrayList;

public class CourseService {
    public static ArrayList<Course> getInfo() {
        ArrayList<Course> courses = new ArrayList<>();
        // todo: search for all the courses from database, add them to courses
        return courses;
    }

    public static Course getInfo(String courseName) {
        // todo: search for the course by its name
        Course course = new Course();
        return course;
    }

    public static Course create(String professorName, String courseName) {
        Course course = new Course(professorName, courseName);
        String hashID = MD5Util.getMD5(courseName);
        course.setCourseID(hashID);
        // todo: dao.insert()
        return course;
    }
}
