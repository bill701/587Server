package com.csci587.controller;

import com.csci587.entity.User;
import com.csci587.service.LocationService;
import com.csci587.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LocationController {
    @RequestMapping(value = "/currentLocationUpdate", method= RequestMethod.GET)
    public int[] currentLocationUpdate (HttpServletRequest request, HttpServletResponse response){
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longtitude = Double.parseDouble(request.getParameter("longtitude"));
        String username = request.getParameter("username");
        LocationService locationService = new LocationService();
        return locationService.currentLocationUpdate(latitude,longtitude,username);
    }
}
