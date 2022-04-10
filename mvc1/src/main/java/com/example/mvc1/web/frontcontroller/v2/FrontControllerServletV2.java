package com.example.mvc1.web.frontcontroller.v2;

import com.example.mvc1.web.frontcontroller.ControllerV1;
import com.example.mvc1.web.frontcontroller.MyView;
import com.example.mvc1.web.frontcontroller.v1.MemberFormControllerV1;
import com.example.mvc1.web.frontcontroller.v1.MemberShowAllControllerV1;
import com.example.mvc1.web.frontcontroller.v2.controller.UserFormControllerV2;
import com.example.mvc1.web.frontcontroller.v2.controller.UserSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerServletV2", urlPatterns = "/frontcontroller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new UserFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new UserSaveControllerV2());

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
