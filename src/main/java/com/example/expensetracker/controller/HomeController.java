package com.example.expensetracker.controller;

import com.example.expensetracker.mapper.DbMapperRegister;
import com.example.expensetracker.model.User;
import com.example.expensetracker.service.CheckUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    @Autowired
    DbMapperRegister mapper;
    @Autowired
    CheckUser checkuser;

    @RequestMapping("userregistration")
    public String register() {
        return "userregister";
    }

    @RequestMapping("register")
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user", user);
        if (checkuser.checkUserEntry(user.getUsername(), user.getEmail()) == true) {
            mv.setViewName("userregister");
        } else {
            mapper.insertUser(user);
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    @RequestMapping("login")
    public String userlogin() {
        return "userlogin";
    }

    @RequestMapping("home")
    public String home(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (checkuser.checkUsernameAndPassword(username, password))
            return "homepage";
        return "redirect:/login";
    }
}
