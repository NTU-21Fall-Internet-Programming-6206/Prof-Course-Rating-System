package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.model.ProfessorCR;
import org.ci6206.service.ProfessorCRService;
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

@WebServlet(urlPatterns = "/professor-CR")
public class ProfessorCRQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseSetting.ResponseConfig(req, resp);

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

