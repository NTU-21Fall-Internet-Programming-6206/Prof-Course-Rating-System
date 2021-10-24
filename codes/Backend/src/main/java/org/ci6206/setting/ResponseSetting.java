package org.ci6206.setting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseSetting {
    public static void responseConfig(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Origin", "http://34.126.85.190:80");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        if ("OPTIONS".equals(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
