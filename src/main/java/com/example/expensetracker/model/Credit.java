package com.example.expensetracker.model;
import java.time.LocalDate;
public class Credit {
    private LocalDate credit_date;
    private String credit_title;
    private double credit_amount;
    private String credit_description;
    public LocalDate getCredit_date() {
        return credit_date;
    }

    public void setCredit_date(LocalDate credit_date) {
        this.credit_date = credit_date;
    }

    public String getCredit_title() {
        return credit_title;
    }

    public void setCredit_title(String credit_title) {
        this.credit_title = credit_title;
    }

    public double getCredit_amount() {
        return credit_amount;
    }

    public void setCredit_amount(double credit_amount) {
        this.credit_amount = credit_amount;
    }

    public String getCredit_description() {
        return credit_description;
    }

    public void setCredit_description(String credit_description) {
        this.credit_description = credit_description;
    }




}
