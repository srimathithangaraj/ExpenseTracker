package com.example.expensetracker.model;

import java.time.LocalDate;

public class Debit {
    private LocalDate debit_date;
    private String debit_title;
    private double debit_amount;
    private String debit_description;

    public LocalDate getDebit_date() {
        return debit_date;
    }

    public void setDebit_date(LocalDate debit_date) {
        this.debit_date = debit_date;
    }

    public String getDebit_title() {
        return debit_title;
    }

    public void setDebit_title(String debit_title) {
        this.debit_title = debit_title;
    }

    public double getDebit_amount() {
        return debit_amount;
    }

    public void setDebit_amount(double debit_amount) {
        this.debit_amount = debit_amount;
    }

    public String getDebit_description() {
        return debit_description;
    }

    public void setDebit_description(String debit_description) {
        this.debit_description = debit_description;
    }


}
