package com.example.mvc1.web.frontcontroller.v1;

import com.example.mvc1.domain.User;
import com.example.mvc1.domain.UserRepository;
import com.example.mvc1.web.frontcontroller.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberCreateControllerV1 implements ControllerV1 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = new User(userName, age);
        User save = userRepository.save(user);

        request.setAttribute("user", save);
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
