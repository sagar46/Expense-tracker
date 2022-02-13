package com.sagar46.expensetracker.service;

import java.time.LocalDateTime;

public class Expense {
    private int amount;
    private String cause;
    private String shop;
    private LocalDateTime localDateTime;
    private String method;


    public Expense(){

    }
    public Expense(int amount , String cause, String shop, LocalDateTime localDateTime, String method) {
        this.amount = amount;
        this.cause = cause;
        this.shop = shop;
        this.localDateTime = localDateTime;
        this.method = method;

    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



}
