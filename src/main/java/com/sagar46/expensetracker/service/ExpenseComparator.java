package com.sagar46.expensetracker.service;

import com.sagar46.expensetracker.service.bo.Expense;

import java.util.Comparator;

public class ExpenseComparator implements Comparator<Expense> {

    @Override
    public int compare(Expense t1, Expense t2) {
        if(t1.getDueDate().isBefore(t2.getDueDate())) {
            return -1;
        }else if(t1.getDueDate().isAfter(t2.getDueDate())){
            return 1;
        }else
            return 0;
    }
}
