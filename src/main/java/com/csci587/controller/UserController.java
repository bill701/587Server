package com.csci587.controller;

import com.csci587.entity.Location;
import com.csci587.entity.User;
import com.csci587.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public User userLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        return userService.login(username,password);
    }
    @RequestMapping(value = "/register", method=RequestMethod.GET)
    public Boolean userRegister(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UserService userService = new UserService();
        return userService.register(username,password,email);
    }
    @RequestMapping(value = "/getLocation", method=RequestMethod.GET)
    public Location getLocation(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        UserService userService = new UserService();
        return userService.getLocation(username);
    }
}
