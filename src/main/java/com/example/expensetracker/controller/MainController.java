package com.example.expensetracker.controller;

import com.example.expensetracker.model.Budget;
import com.example.expensetracker.service.BudgetService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    BudgetService budgetService;

    public MainController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    @RequestMapping("home")
    public String home(HttpSession session,Model model) {
        if (session.getAttribute("username") != null) {
           float budget= budgetService.fetchBudget((String) session.getAttribute("username"));
           model.addAttribute("budget",budget);
            return "homepage";
        }
        return "redirect:/login";
    }
    @RequestMapping("budget")
    public String budget(){
        return "budgetpage";
    }
    @RequestMapping("submitBudget")
    public String submitBudget(Budget budget, HttpSession session){
        String username= (String) session.getAttribute("username");
        budgetService.insertBudget(budget,username);
        return "redirect:/home";
    }
}
