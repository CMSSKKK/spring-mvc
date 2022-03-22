package com.example.mvc1.web.servletMvc;

import com.example.mvc1.domain.User;
import com.example.mvc1.domain.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MvcUsersServlet", urlPatterns = "/servlet-mvc/user/all")
public class MvcUsersServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> all = userRepository.findAll();
        request.setAttribute("users", all);

        String viewPath = "/WEB-INF/views/users.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);

    }
}
