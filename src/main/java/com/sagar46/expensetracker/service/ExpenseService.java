package com.sagar46.expensetracker.controller;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ExpenseService {
    private Map<Integer, Expense> expenses = new HashMap<>(){{
       put(1,new Expense(100,"Food","Naeen",LocalDateTime.now(),"Cash"));
    }};

    public Map<Integer, Expense> getAllExpenses(){
        return expenses;
    }
//    public void addExpenses(Expenses expense){
//
//        expenses.add(expense);
//    }
//    public Expenses getExpense(String id){
//        Expenses e = new Expenses();
//        for(int i =0 ; i < expenses.size(); i++){
//            e = expenses.get(i);
//            if(e.getShop().equals(id)){
//                break;
//            }
//        }
//        return e;
//    }
//    public void updateExpense(String id, Expenses expense){
//        for(int i =0 ; i < expenses.size(); i++){
//            Expenses e = expenses.get(i);
//            if(e.getShop().equals(id)){
//                expenses.set(i,expense);
//                return;
//            }
//
//        }
//    }
//    public Expenses deleteExpense(String id){
//        Expenses e = new Expenses();
//        for(int i =0 ; i < expenses.size(); i++){
//            e = expenses.get(i);
//            if(e.getShop().equals(id)){
//                expenses.remove(i);
//            }
//        }
//        return e;
//    }

}
