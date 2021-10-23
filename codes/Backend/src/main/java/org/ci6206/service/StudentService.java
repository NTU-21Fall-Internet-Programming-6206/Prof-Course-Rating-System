package org.ci6206.service;

import org.ci6206.dbAPI.StudentDBAO;
import org.ci6206.model.Student;
import org.ci6206.util.MD5Util;

public class StudentService {
    public static void register(String username, String password, String emailAddress) throws Exception {
        Student student = new Student(username, emailAddress);

        String salt = MD5Util.getSalt();
        String encryptedPassword = MD5Util.getMD5(password + salt);
        student.setSalt(salt);
        student.setPassword(encryptedPassword);

        StudentDBAO con = new StudentDBAO();
        con.addStudent(student);
    }

    public static boolean login(String username, String password) throws Exception {
        StudentDBAO con = new StudentDBAO();
        Student student = con.findStudentWithUsername(username);
        if (student == null) {
            // failed
            return false;
        }

        String salt = student.getSalt();
        String encryptedPassword = student.getPassword();
        String loginPassword = MD5Util.getMD5(password + salt);
        return loginPassword.equals(encryptedPassword);
    }
}
