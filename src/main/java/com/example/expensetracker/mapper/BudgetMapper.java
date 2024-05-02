package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Budget;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BudgetMapper {
    @Update("update budget set amount=#{budget.amount}," +
            "description=#{budget.description} where username=#{username}")
    void updateBudget(Budget budget,String username);
    @Select("select amount from budget where username=#{username}")
    float getamount(String username);

    @Insert("insert into budget values(#{username},#{budget.amount},#{budget.description})")
    void insertBudget(Budget budget,String username);
}
