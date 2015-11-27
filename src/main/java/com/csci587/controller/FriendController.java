package com.csci587.controller;

import com.csci587.entity.User;
import com.csci587.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Lerex on 15/11/26.
 */
@Controller
public class FriendController {
    @RequestMapping(value = "/getFriendByUserId", method= RequestMethod.GET)
    public List<User> getFriendByUserId(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        FriendService friendService = new FriendService();
        return friendService.getFriendByUserId(username);
    }
    @RequestMapping(value = "/addFriend", method= RequestMethod.GET)
    public Boolean addFriend(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        FriendService friendService = new FriendService();
        return friendService.addFriend(username);
    }
}
