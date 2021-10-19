package org.ci6206.dbAPI;

import org.ci6206.dbAPI.*;
import org.ci6206.model.*;

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
        

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}