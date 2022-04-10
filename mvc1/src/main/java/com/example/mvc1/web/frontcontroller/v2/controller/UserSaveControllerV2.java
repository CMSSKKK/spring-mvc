package com.example.mvc1.web.frontcontroller.v2.controller;

import com.example.mvc1.domain.User;
import com.example.mvc1.domain.UserRepository;
import com.example.mvc1.web.frontcontroller.MyView;
import com.example.mvc1.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSaveControllerV2 implements ControllerV2 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = new User(userName, age);
        User save = userRepository.save(user);

        request.setAttribute("user", save);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
