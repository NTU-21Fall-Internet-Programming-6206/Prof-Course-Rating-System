package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.model.Course;
import org.ci6206.service.CourseService;
import org.ci6206.service.TokenService;
import org.ci6206.setting.ResponseSetting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/course")
public class CourseQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
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
                String courseName = req.getParameter("course_name");
                String professorName = req.getParameter("professor_name");
                PrintWriter printWriter = resp.getWriter();
                JSONObject jsonObject = new JSONObject();
                List<Course> courseList;
                if (courseName == null && professorName == null) {
                    courseList = CourseService.getCourseList();
                } else if (professorName == null) {
                    courseList = CourseService.getCourseListWithCourseName(courseName);
                } else {
                    courseList = CourseService.getCourseListWithProfessorName(professorName);
                }
                jsonObject.put("course_list", courseList);
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
