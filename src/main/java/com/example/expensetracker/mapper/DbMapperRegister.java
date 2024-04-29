package com.example.expensetracker.mapper;

import com.example.expensetracker.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DbMapperRegister {
    @Insert("insert into ExpenseTrackerUser values(#{username},#{fullName},#{email},#{password})")
    Boolean insertUser(User user);

    @Select("select * from ExpenseTrackerUser where username=#{username} ")
    List<User> checkUsername(String username);

    @Select("select * from ExpenseTrackerUser where email=#{email}")
    List<User> checkEmail( String email);
    @Select("select password from ExpenseTrackerUser where username=#{uname}")
    String checkpassword(String uname);

}
