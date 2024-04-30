package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Budget;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BudgetMapper {
    @Insert("update budget set amount=#{budget.amount}," +
            "description=#{budget.description} where username=#{username}")
    void insertBudget(Budget budget,String username);
    @Select("select amount from budget where username=#{username}")
    float getamount(String username);
}
