package com.carbon.approvalassistant.controller;

import com.carbon.approvalassistant.bean.UserContext;
import com.carbon.approvalassistant.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class VerifyCodeController {

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image, resp.getOutputStream());
    }

    @GetMapping("/loginTest")
    public String loginTest() {
        // 解析成功就执行业务逻辑返回数据
        return "welcome " + UserContext.getCurrentUserName();

    }


}
