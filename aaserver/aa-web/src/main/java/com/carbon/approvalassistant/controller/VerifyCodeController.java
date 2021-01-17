package com.carbon.approvalassistant.controller;

import com.carbon.approvalassistant.bean.UserRegisterRequest;
import com.carbon.approvalassistant.config.VerificationCode;
import com.carbon.approvalassistant.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class VerifyCodeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image, resp.getOutputStream());
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRegisterRequest userRegisterRequest) {
        Authentication token = new UsernamePasswordAuthenticationToken(userRegisterRequest.getUserName(), userRegisterRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "login success";
    }
}
