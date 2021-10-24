package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.model.Professor;
import org.ci6206.service.ProfessorService;
import org.ci6206.service.TokenService;
import org.ci6206.setting.ResponseSetting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



@WebServlet(urlPatterns = "/professor")
public class ProfessorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseSetting.responseConfig(req, resp);

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
