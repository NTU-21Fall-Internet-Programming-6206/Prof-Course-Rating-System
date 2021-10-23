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

@WebServlet(urlPatterns = "/professor-CR")
public class ProfessorCRQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();
        resp.setContentType("text/json");
        String token = req.getHeader("Token");
        try {
            if(! TokenService.checkTokenValid(token)) {
                PrintWriter printWriter = resp.getWriter();
                jsonObject.put("error", "Invalid token");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }

            else {
                String professorName = req.getParameter("professor_name");
                List<ProfessorCR> professorCRList = ProfessorCRService.getInfo(professorName);
                jsonObject.put("professor_cr_list", professorCRList);
                PrintWriter printWriter = resp.getWriter();
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

