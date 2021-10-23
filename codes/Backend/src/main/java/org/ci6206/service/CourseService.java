package org.ci6206.service;

import org.ci6206.dbAPI.CourseDBAO;
import org.ci6206.model.Course;
import org.ci6206.util.MD5Util;

import java.util.List;

public class CourseService {
    public static List<Course> getInfo() throws Exception {
        CourseDBAO con = new CourseDBAO();
        return con.findAllCourse();
    }

    public static List<Course> getInfo(String courseName) throws Exception {
        CourseDBAO con = new CourseDBAO();
        return con.findCourseWithCourseName(courseName);
    }

    public static void create(String courseId, String professorName, String courseName) throws Exception {
        Course course = new Course(courseId, professorName, courseName);
        CourseDBAO con = new CourseDBAO();
        con.addCourse(course);
    }
}
