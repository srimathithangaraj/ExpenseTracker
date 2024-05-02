package com.example.expensetracker.config;

import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.Credit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ExpenseConfig {
    @Bean
    public Budget budget(){
        Budget budget=new Budget(0,"");
        return budget;
    }
@Bean
    public Credit credit(){
        LocalDate date=LocalDate.of(2024,01,01);
        Credit credit=new Credit( date,0,"","");
        return credit;
    }
}
