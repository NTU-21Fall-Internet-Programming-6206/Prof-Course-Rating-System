package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.model.CourseCR;
import org.ci6206.service.CourseCRService;
import org.ci6206.service.TokenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/course-CR")
public class CourseCRQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
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

        String token = req.getHeader("Token");
        try {
            if (!TokenService.checkTokenValid(token)) {
                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("error", "Invalid token");
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            } else {
                String courseID = req.getParameter("course_id");
                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                List<CourseCR> courseCRList = CourseCRService.getCourseCRListWithCourseID(courseID);
                jsonObject.put("course_cr_list", courseCRList);
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
