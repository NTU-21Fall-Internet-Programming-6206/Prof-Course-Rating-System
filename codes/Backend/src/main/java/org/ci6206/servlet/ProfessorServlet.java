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



@WebServlet(urlPatterns = "/professor")
public class ProfessorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Origin", "*");  
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        resp.setHeader("Access-Control-Allow-Methods", "*");  
        /* 重新预检验跨域的缓存时间 (s) */
        resp.setHeader("Access-Control-Max-Age", "3600");  
        /* 允许跨域的请求头 */
        resp.setHeader("Access-Control-Allow-Headers", "*");  
        /* 是否携带cookie */
        resp.setHeader("Access-Control-Allow-Credentials", "true");  

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
                String professorName = req.getParameter("professor_name");
                System.out.println(professorName);
                if(professorName == null) {
                    List<Professor> professorList = ProfessorService.getAllProfessor();
                    jsonObject.put("professor_list", professorList);
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write(jsonObject.toString());
                    printWriter.flush();
                }
                else {
                    Professor professor = ProfessorService.getProfessorWithProfessorName(professorName);
                    jsonObject.put("professor_list", professor);
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write(jsonObject.toString());
                    printWriter.flush();
                }
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
