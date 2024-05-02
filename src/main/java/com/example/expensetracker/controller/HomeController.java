package com.example.expensetracker.controller;

import com.example.expensetracker.config.ExpenseConfig;
import com.example.expensetracker.mapper.UserMapper;
import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.Credit;
import com.example.expensetracker.model.User;
import com.example.expensetracker.service.BudgetService;
import com.example.expensetracker.service.CheckUser;
import com.example.expensetracker.service.CreditService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    UserMapper mapper;
    CheckUser checkuser;
    BudgetService budgetService;
    @Autowired
    CreditService creditService;
    @Autowired
    ExpenseConfig config;
    @Autowired
    Budget initialBudget;
    @Autowired
    Credit initialCredit;

    public HomeController(UserMapper mapper, CheckUser checkuser, BudgetService budgetService) {
        this.mapper = mapper;
        this.checkuser = checkuser;
        this.budgetService = budgetService;
    }

    @RequestMapping("/")
    public String register() {
        return "userregister";
    }

    @RequestMapping("register")
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView("userregister");
        mv.addObject("user", user);
        if (checkuser.checkUserEntry(user.getUsername(), user.getEmail()) == true) {
            mv.setViewName("userregister");
        } else {
           mapper.insertUser(user);
            budgetService.insertBudget(initialBudget, user.getUsername());
            creditService.insertCredit(initialCredit, user.getUsername());
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    @RequestMapping("login")
    public String home(HttpSession session, HttpServletRequest request) {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        if (username != null && password != null && checkuser.checkUsernameAndPassword(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/home";
        }
        return "userlogin";
    }


}
