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

@WebServlet(urlPatterns = "/professor-CR/add")
public class ProfessorCRCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");

        JSONObject jsonObject = new JSONObject();
        String token = req.getHeader("Token");
        try {
            if(! TokenService.checkTokenValid(token)) {
                PrintWriter printWriter = resp.getWriter();
                jsonObject.put("error", "Invalid token");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }

            else {
                JSONObject msg = JSONUtil.getRequestJson(req);
                if (msg == null) {
                    throw new IOException("empty request");
                }

                String professorName = msg.getString("professor_name");
                String username = msg.getString("username");
                Integer rate = msg.getInteger("rate");
                String comment = msg.getString("comment");

                ProfessorCRService.create(professorName, username, rate, comment);

                PrintWriter printWriter = resp.getWriter();
                jsonObject.put("info", "Success");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

