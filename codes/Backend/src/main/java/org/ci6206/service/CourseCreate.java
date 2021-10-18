package org.ci6206.service;

import org.ci6206.model.Course;
import org.ci6206.util.MD5Util;

public class CourseCreate {
    public Course create(String professorName, String courseName) {
        Course course = new Course(professorName, courseName);
        String hashID = MD5Util.getMD5(courseName);
        course.setCourseID(hashID);
        return course;
    }
}
