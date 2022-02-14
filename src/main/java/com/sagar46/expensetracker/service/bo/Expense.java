package com.sagar46.expensetracker.service.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Expense {
    private int amount;
    private String purpose;
    private String shop;
    private LocalDateTime paymentTime;
    private LocalDate dueDate;
    private boolean isPayed;
    private String paymentMethod;


    public Expense(){

    }
    public Expense(int amount, String purpose, String shop, LocalDateTime paymentTime, LocalDate dueDate, boolean isPayed, String paymentMethod) {
        this.amount = amount;
        this.purpose = purpose;
        this.shop = shop;
        this.paymentTime = paymentTime;
        this.dueDate = dueDate;
        this.isPayed = isPayed;
        this.paymentMethod = paymentMethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
