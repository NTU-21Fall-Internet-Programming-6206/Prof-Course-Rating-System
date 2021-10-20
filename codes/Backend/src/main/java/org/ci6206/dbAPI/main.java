package org.ci6206.dbAPI;

import org.ci6206.dbAPI.*;
import org.ci6206.model.*;

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String[] args) {
        try {
        System.out.println("x");
        StudentDBAO studentDBAO = new StudentDBAO();
        
        Student studentB = new Student("B", "asd@ntu.edu.sg");
        studentB.setPassword("123456");
        studentB.setSalt("salt");
        System.out.println(studentB);

        //studentDBAO.addStudent(studentB);
        Student findResult = studentDBAO.findStudentWithUsername("B");
        System.out.println(findResult);
        System.out.println(findResult.getUsername());

        Student noResult = studentDBAO.findStudentWithUsername("C");
        System.out.println(noResult);
        

        ProfessorDBAO professorDBAO = new ProfessorDBAO();

        Professor professorB= new Professor("B", "B", "B");
        //professorDBAO.addProfessor(professorB);
        Professor findProfessor = professorDBAO.findProfessorWithProfessorName("B");
        System.out.println(findProfessor.getProfessorName());
        List<Professor> professorList = professorDBAO.findAllProfessor();
        System.out.println(professorList.toString());
        
        CourseDBAO courseDBAO = new CourseDBAO();
        Course courseB = new Course("B", "B", "B");
        //courseDBAO.addCourse(courseB);
        List<Course> coursefindResult = courseDBAO.findCourseWithCourseName("B");
        System.out.println(coursefindResult.toString());
        System.out.println(coursefindResult.get(0).getCourseID());
        coursefindResult = courseDBAO.findCourseWithProfessorName("B");
        System.out.println(coursefindResult.toString());
        System.out.println(coursefindResult.get(0).getCourseID());
        coursefindResult = courseDBAO.findAllCourse();
        System.out.println(coursefindResult.toString());
        System.out.println(coursefindResult.get(0).getCourseID());

        CourseCRDBAO courseCRDBAO = new CourseCRDBAO();
        CourseCR courseCRC = new CourseCR("B", "B", "B", 3);
        courseCRDBAO.addCourseCR(courseCRC);
        List<CourseCR> rsCourseCR = courseCRDBAO.findCourseCRWithCourseId("B");
        System.out.println(rsCourseCR.size());
        System.out.println(rsCourseCR.toString());
        //System.out.println(courseCRDBAO.deleteCourseCRWithCourseIdAndUsername("B", "B"));
        rsCourseCR = courseCRDBAO.findCourseCRWithCourseId("B");
        System.out.println(rsCourseCR.size());
        System.out.println(rsCourseCR.toString());

        ProfessorCRDBAO professorCRDBAO = new ProfessorCRDBAO();
        ProfessorCR professorCRC = new ProfessorCR("B", "B", 3, "B");
        professorCRDBAO.addProfessorCR(professorCRC);
        List<ProfessorCR> rsprofessorCRC = professorCRDBAO.findProfessorCRWithProfessorName("B");
        System.out.println(rsprofessorCRC.toString());
        System.out.println(professorCRDBAO.deleteProfessorCRWithProfessorNameAndUsername("B", "B"));
        rsprofessorCRC = professorCRDBAO.findProfessorCRWithProfessorName("B");
        System.out.println(rsprofessorCRC.toString());

        



    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}