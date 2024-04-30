package com.example.expensetracker.model;

public class Budget {
    float amount;
    String description;

    public Budget(float amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescrioption() {
        return description;
    }

    public void setDescrioption(String descrioption) {
        this.description = descrioption;
    }


}
