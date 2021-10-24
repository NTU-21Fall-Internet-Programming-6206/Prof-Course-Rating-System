package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.service.CourseCRService;
import org.ci6206.service.TokenService;
import org.ci6206.setting.ResponseSetting;
import org.ci6206.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/course-CR/add")
public class CourseCRCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseSetting.ResponseConfig(req, resp);

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
                String username = msg.getString("username");
                String courseID = msg.getString("course_id");
                int rating = msg.getInteger("rate");
                String comment = msg.getString("comment");

                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                if (CourseCRService.create(professorName, username, courseID, rating, comment)) {
                    jsonObject.put("info", "Success");
                } else {
                    jsonObject.put("error", "Invalid input");
                }
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
