package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.service.CourseService;
import org.ci6206.service.TokenService;
import org.ci6206.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/course/add")
public class CourseCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");

        String token = req.getHeader("Token");
        try {
            if (!TokenService.checkTokenValid(token)) {
                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("error", "Invalid token");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            } else {
                JSONObject msg = JSONUtil.getRequestJson(req);
                if (msg == null) {
                    throw new IOException("empty request");
                }

                String professorName = msg.getString("professor_name");
                String courseName = msg.getString("course_name");
                String courseID = msg.getString("course_id");

                CourseService.create(courseID, professorName, courseName);
                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("info", "Success");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}