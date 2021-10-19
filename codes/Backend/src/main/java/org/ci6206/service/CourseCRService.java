package org.ci6206.service;

import org.ci6206.model.CourseCR;

public class CourseCRService {
    public static CourseCR create(String professorName, String username, String courseID, int rating) {
        CourseCR courseCR = new CourseCR(professorName, username, courseID, rating);
        // todo: dao.insert(courseCR)
        return courseCR;
    }

    public static CourseCR create(String professorName, String username, String courseID, int rating, String comment) {
        CourseCR courseCR = new CourseCR(professorName, username, courseID, rating, comment);
        // todo: dao.insert(courseCR)
        return courseCR;
    }

    public static CourseCR getInfo(String courseID) {
        CourseCR courseCR = new CourseCR();
        // todo: dao.search(courseID)
        return courseCR;
    }

    public static void remove(String courseID, String username) {
        // todo: dao.search(courseID, username), remove it.
    }
}
