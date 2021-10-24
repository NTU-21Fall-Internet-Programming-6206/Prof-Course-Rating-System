package org.ci6206.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSONObject;
import org.ci6206.dbAPI.TokenDBAO;
import org.ci6206.service.*;
import org.ci6206.model.*;
import org.ci6206.util.JSONUtil;
import org.ci6206.util.TokenUtil;


@WebServlet(urlPatterns = "/student/login")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
