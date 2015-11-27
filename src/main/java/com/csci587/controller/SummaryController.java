package com.csci587.controller;

import com.csci587.service.SummaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SummaryController {
    @RequestMapping(value = "/getSummaryForOneDay", method= RequestMethod.GET)
    public List<String> getSummaryForOneDay (HttpServletRequest request, HttpServletResponse response){
        String date = request.getParameter("date");
        String username = request.getParameter("username");
        SummaryService summaryService = new SummaryService();
        return summaryService.getSummaryForOneDay(date,username);
    }
}
