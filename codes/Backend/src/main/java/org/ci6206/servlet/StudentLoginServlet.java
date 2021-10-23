package org.ci6206.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.service.*;
import org.ci6206.model.*;
import org.ci6206.util.JSONUtil;
import org.ci6206.util.TokenUtil;


@WebServlet(urlPatterns = "/student/login")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter printWriter = resp.getWriter();

        JSONObject msg = JSONUtil.getRequestJson(req);
        if (msg == null) {
            throw new IOException();
        }
        String username = msg.getString("username");
        String loginPassword = msg.getString("password");
        try {
            if (StudentService.login(username, loginPassword)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("info", "Success");
                jsonObject.put("token", TokenUtil.getToken());
                jsonObject.put("username", username);
                printWriter.write(jsonObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        printWriter.flush();
    }
}
