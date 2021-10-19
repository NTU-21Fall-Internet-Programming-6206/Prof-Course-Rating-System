package org.ci6206.service;

import org.ci6206.model.Student;
import org.ci6206.util.MD5Util;

public class StudentService {
    public static Student register(String username, String password, String emailAddress) {
        Student student = new Student(username, emailAddress);

        String salt = MD5Util.getSalt();
        String encryptedPassword = MD5Util.getMD5(password + salt);
        student.setSalt(salt);
        student.setPassword(encryptedPassword);

        // todo: dao.insert()
        return student;
    }

    public static void login(String username, String password) {
        // todo: Student student = dao.search(username)
        Student student = new Student("", "");

        String salt = student.getSalt();
        String encryptedPassword = student.getPassword();
        String loginPassword = MD5Util.getMD5(password + salt);
        if (loginPassword.equals(encryptedPassword)) {
            // todo: login successfully
        } else {
            // todo: login failed
        }
    }
}
