package com.example.expensetracker.controller;

import com.example.expensetracker.mapper.UserMapper;
import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.User;
import com.example.expensetracker.service.BudgetService;
import com.example.expensetracker.service.CheckUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    UserMapper mapper;
    CheckUser checkuser;
    BudgetService budgetService;

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
            Budget initialBudget=new Budget(0,"");
            budgetService.insertBudget(initialBudget, user.getUsername());

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
