package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.service.StudentService;
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


@WebServlet(urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseSetting.ResponseConfig(req, resp);

        JSONObject msg = JSONUtil.getRequestJson(req);
        if (msg == null) {
            throw new IOException("empty request");
        }

        String username = msg.getString("username");
        String password = msg.getString("password");
        String emailAddress = msg.getString("email_address");
        try {
            StudentService.register(username, password, emailAddress);
            TokenService.generateTokenForUsername(username);
            JSONObject jsonObject = new JSONObject();
            PrintWriter printWriter = resp.getWriter();
            jsonObject.put("info", "Success");
            printWriter.write(jsonObject.toString());
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
