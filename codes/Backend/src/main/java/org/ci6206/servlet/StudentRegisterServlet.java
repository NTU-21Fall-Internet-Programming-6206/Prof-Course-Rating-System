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


@WebServlet(urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");

        JSONObject msg = JSONUtil.getRequestJson(req);
        if (msg == null) {
            throw new IOException("empty request");
        }

        String username = msg.getString("username");
        String password = msg.getString("password");
        String emailAddress = msg.getString("email_address");
        try {
            StudentService.register(username, password, emailAddress);
            TokenService.generateTokenForUsername(username);
            JSONObject jsonObject = new JSONObject();
            PrintWriter printWriter = resp.getWriter();
            jsonObject.put("info", "Success");
            printWriter.write(jsonObject.toString());
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
