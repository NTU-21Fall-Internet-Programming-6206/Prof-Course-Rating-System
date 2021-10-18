package org.ci6206.service;

import org.ci6206.model.Student;
import org.ci6206.util.MD5Util;

public class StudentRegister {
    public Student register(String username, String password, String emailAddress) {
        Student student = new Student(username, emailAddress);

        String salt = MD5Util.getSalt();
        String encryptedPassword = MD5Util.getMD5(password + salt);
        student.setSalt(salt);
        student.setPassword(encryptedPassword);

        // todo: dao.insert()
        return student;
    }
}
