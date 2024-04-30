package com.example.expensetracker.service;

import com.example.expensetracker.mapper.BudgetMapper;
import com.example.expensetracker.model.Budget;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    BudgetMapper budgetMapper;

    public BudgetService(BudgetMapper budgetMapper) {
        this.budgetMapper = budgetMapper;
    }

    public void insertBudget(Budget budget, String username) {
        budgetMapper.insertBudget(budget, username);
    }
    public float fetchBudget(String username){
       return budgetMapper.getamount(username);
    }
}
