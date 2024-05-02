package com.example.expensetracker.controller;

import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.Credit;
import com.example.expensetracker.service.BudgetService;
import com.example.expensetracker.service.CreditService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    BudgetService budgetService;
    CreditService creditService;
    List<Credit> creditList;

    public MainController(BudgetService budgetService, CreditService creditService) {
        this.budgetService = budgetService;
        this.creditService = creditService;
    }

    @RequestMapping("home")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            float budget = budgetService.fetchBudget((String) session.getAttribute("username"));
            float credit= creditService.fetchCreditAmount((String) session.getAttribute("username"));
            credit=credit+budget;
            creditList=creditService.fetchCredit((String) session.getAttribute("username"));
            model.addAttribute("creditList",creditList);
            model.addAttribute("budget", budget);
            model.addAttribute("credit",credit);
            return "homepage";
        }
        return "redirect:/login";
    }

    @RequestMapping("budget")
    public String budget() {
        return "budgetpage";
    }

    @RequestMapping("submitBudget")
    public String submitBudget(Budget budget, HttpSession session) {
        String username = (String) session.getAttribute("username");
        budgetService.updateBudget(budget, username);
        return "redirect:/home";
    }

    @RequestMapping("credit")
    public String credit() {
        return "creditpage";
    }

    @RequestMapping("submitcredit")
    public String credit(Credit credit, HttpSession session) {
        String username = (String) session.getAttribute("username");
        creditService.insertCredit(credit, username);
        return "redirect:/home";
    }
    @RequestMapping("deleteCredit")
    public String deleteCredit(LocalDate credit_date,float credit_amount,HttpSession session){
        creditService.deleteCredit(credit_date,credit_amount, (String) session.getAttribute("username"));
        return "redirect:/home";
    }

//    @RequestMapping("editCredit")
//    public String editCredit(LocalDate credit_date,float credit_amount,HttpSession session){
//        creditService.updateCredit(credit_date,credit_amount, (String) session.getAttribute("username"));
//        return "redirect:/home";
//    }
}
