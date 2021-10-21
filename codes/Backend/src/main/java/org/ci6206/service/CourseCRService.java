package org.ci6206.service;

import org.ci6206.dbAPI.CourseCRDBAO;
import org.ci6206.model.CourseCR;

import java.util.List;

public class CourseCRService {
    public static CourseCR create(String professorName, String username, String courseID, int rating) throws Exception {
        CourseCR courseCR = new CourseCR(professorName, username, courseID, rating);
        CourseCRDBAO con = new CourseCRDBAO();
        con.addCourseCR(courseCR);
        return courseCR;
    }

    public static CourseCR create(String professorName, String username, String courseID, int rating, String comment) throws Exception {
        CourseCR courseCR = new CourseCR(professorName, username, courseID, rating, comment);
        CourseCRDBAO con = new CourseCRDBAO();
        con.addCourseCR(courseCR);
        return courseCR;
    }

    public static List<CourseCR> getInfo(String courseID) throws Exception {
        CourseCRDBAO con = new CourseCRDBAO();
        return con.findCourseCRWithCourseId(courseID);
    }

    public static void remove(String courseID, String username) throws Exception {
        CourseCRDBAO con = new CourseCRDBAO();
        con.deleteCourseCRWithCourseIdAndUsername(courseID, username);
    }
}
