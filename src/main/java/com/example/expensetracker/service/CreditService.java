package com.example.expensetracker.service;

import com.example.expensetracker.mapper.CreditMapper;
import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.Credit;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditService {
    CreditMapper creditMapper;

    public CreditService(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }

    public void insertCredit(Credit credit, String username) {
        creditMapper.insertCredit(credit, username);
    }
    public void updateCredit(Credit credit, String username) {
        creditMapper.updateCredit(credit, username);
    }
    public float fetchCreditAmount(String username){
        return  creditMapper.getcreditamount(username);
    }
    public List<Credit> fetchCredit(String username){
        return creditMapper.fetchCredit(username);
    }

    public void deleteCredit(LocalDate credit_date,float credit_amount, String username){
        creditMapper.deleteCredit(credit_date,credit_amount,username);
    }
}
