package org.ci6206.service;

import org.ci6206.dbAPI.CourseDBAO;
import org.ci6206.model.Course;

import java.util.List;

public class CourseService {
    public static List<Course> getCourseList() throws Exception {
        CourseDBAO con = new CourseDBAO();
        return con.findAllCourse();
    }

    public static List<Course> getCourseListWithCourseName(String courseName) throws Exception {
        CourseDBAO con = new CourseDBAO();
        return con.findCourseWithCourseName(courseName);
    }

    public static List<Course> getCourseListWithProfessorName(String professorName) throws Exception {
        CourseDBAO con = new CourseDBAO();
        return con.findCourseWithProfessorName(professorName);
    }

    public static boolean create(String courseId, String professorName, String courseName) throws Exception {
        Course course = new Course(courseId, professorName, courseName);
        CourseDBAO con = new CourseDBAO();
        return con.addCourse(course);
    }
}
