package com.carbon.approvalassistant.controller;

import com.carbon.approvalassistant.bean.User;
import com.carbon.approvalassistant.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author carbon
 * @Date 2020-12-13 12:24
 */
@RestController
public class JwtController {

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return JwtUtil.generate(user.getUsername());
        }
        return "user name or password error";
    }
}
