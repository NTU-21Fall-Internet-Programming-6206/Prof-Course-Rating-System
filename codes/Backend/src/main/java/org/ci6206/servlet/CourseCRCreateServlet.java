package org.ci6206.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

import org.ci6206.service.*;
import org.ci6206.model.*;
import org.ci6206.util.JSONUtil;

@WebServlet(urlPatterns = "/course-CR/add")
public class CourseCRCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        /* 允许跨域的主机地址 */
        resp.setHeader("Access-Control-Allow-Origin", "*");  
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        resp.setHeader("Access-Control-Allow-Methods", "*");  
        /* 重新预检验跨域的缓存时间 (s) */
        resp.setHeader("Access-Control-Max-Age", "3600");  
        /* 允许跨域的请求头 */
        resp.setHeader("Access-Control-Allow-Headers", "*");  
        /* 是否携带cookie */
        resp.setHeader("Access-Control-Allow-Credentials", "true");  
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
