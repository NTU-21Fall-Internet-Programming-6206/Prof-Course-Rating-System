package org.ci6206.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JSONUtil {
    public static JSONObject getRequestJson(HttpServletRequest req) throws IOException {
        int contentLength = req.getContentLength();
        if (contentLength < 0) {
            return null;
        }

        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readLength = req.getInputStream().read(buffer, i, contentLength - i);
            if (readLength == -1) {
                break;
            }
            i += readLength;
        }

        String characterEncoding = req.getCharacterEncoding();
        if (characterEncoding == null) {
            characterEncoding = "UTF-8";
        }
        String msg = new String(buffer, characterEncoding);
        return JSONObject.parseObject(msg);
    }
}
