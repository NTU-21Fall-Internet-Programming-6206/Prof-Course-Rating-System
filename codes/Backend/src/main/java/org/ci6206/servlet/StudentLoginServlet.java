package org.ci6206.servlet;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.model.Token;
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


@WebServlet(urlPatterns = "/student/login")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseSetting.ResponseConfig(req, resp);

        JSONObject msg = JSONUtil.getRequestJson(req);
        if (msg == null) {
            throw new IOException("empty request");
        }

        String username = msg.getString("username");
        String loginPassword = msg.getString("password");
        try {
            Token token = TokenService.checkTokenWithUsername(username);
            JSONObject jsonObject = new JSONObject();
            PrintWriter printWriter = resp.getWriter();
            if (StudentService.login(username, loginPassword)) {
                jsonObject.put("info", "Success");
                jsonObject.put("token", token.getToken());
                jsonObject.put("username", username);
            } else {
                jsonObject.put("info", "Failed");
            }
            printWriter.write(jsonObject.toString());
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
