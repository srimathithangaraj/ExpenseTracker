package com.example.expensetracker.service;

import com.example.expensetracker.mapper.DbMapperRegister;
import com.example.expensetracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckUser {
    @Autowired
    DbMapperRegister mapper;

    public Boolean checkUserEntry(String uname, String email) {
        List<User> unamedata = mapper.checkUsername(uname);
        List<User> uemaildata = mapper.checkEmail(email);
        int lsize1, lsize2;
        lsize1 = unamedata.size();
        lsize2 = uemaildata.size();
        if (lsize1 > 0 || lsize2 > 0)
            return true;
        return false;
    }

    public Boolean checkUsernameAndPassword(String uname, String password) {
        List<User> unamedata = mapper.checkUsername(uname);
        int lsize1;
        lsize1 = unamedata.size();
        if (lsize1 == 0)
            return false;
        Boolean b = password.equals(mapper.checkpassword(uname));
        if(b)
            return true;
        return false;
    }

}
