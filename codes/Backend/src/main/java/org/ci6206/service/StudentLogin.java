package org.ci6206.service;

import org.ci6206.model.Student;
import org.ci6206.util.MD5Util;

public class StudentLogin {
    public void login(String username, String password) {
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
