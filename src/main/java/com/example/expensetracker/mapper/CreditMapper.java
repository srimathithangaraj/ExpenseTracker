package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Budget;
import com.example.expensetracker.model.Credit;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface CreditMapper {


    @Select("SELECT SUM(credit_amount) AS total_amount FROM credit where username=#{username}")
    float getcreditamount(String username);

    @Insert("insert into credit values(#{username},#{credit.credit_date},#{credit.credit_amount},#{credit.credit_title},#{credit.credit_description})")
    void insertCredit(Credit credit, String username);
    @Select("select credit_date,credit_amount,credit_title,credit_description from credit where username=#{username}")
    List<Credit> fetchCredit(String username);
    @Delete("Delete from credit where username=#{username} and credit_date=#{credit_date} and credit_amount=#{credit_amount} ")
    void deleteCredit(LocalDate credit_date,float credit_amount, String username);

//    @Update("update credit set credit_amount=#{credit.credit_amount}," +
//            "credit_description=#{credit.credit_description} , " +
//            "credit_title=#{credit.credit_title}, " +
//            "credit_date=#{credit.credit_date} where username=#{username}")
//    void updateCredit(LocalDate credit_date,float credit_amount, String username);
}
