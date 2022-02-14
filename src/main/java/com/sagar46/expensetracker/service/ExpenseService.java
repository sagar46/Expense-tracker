package com.sagar46.expensetracker.service;


import com.sagar46.expensetracker.repository.ExpenseRepository;
import com.sagar46.expensetracker.service.bo.Due;
import com.sagar46.expensetracker.service.bo.Expense;
import com.sagar46.expensetracker.service.bo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository repository;
    public void addExpense(Integer userId,Expense expense){
        repository.addExpense(userId,expense);
    }

    public Map<String , Due> getDues(Integer userId){
        Map<String , Due> duePerShop = new HashMap<>();
        List<Expense> expenses = repository.getExpense(userId);
        for(Expense exp: expenses){
            if(!exp.isPayed()){
                if(duePerShop.getOrDefault(exp.getShop()+"__" + exp.getDueDate().toString(),null) != null){
                    Due d = duePerShop.get(exp.getShop()+"__" + exp.getDueDate().toString());
                    d.setAmount(d.getAmount()+exp.getAmount());
                }else{
                    Due d = new Due();
                    d.setDueDate(exp.getDueDate());
                    d.setShop(exp.getShop());
                    d.setUserId(userId);
                    d.setAmount(exp.getAmount());
                    duePerShop.put(exp.getShop()+"__" + exp.getDueDate().toString(),d);
                }
            }
        }
        return duePerShop;
    }

    public int getDuesForShop(Integer userId,String shop){
        int allDues = 0;
        List<Expense> expenses = repository.getExpense(userId);
        for(Expense exp: expenses){
            if(!exp.isPayed() && exp.getShop().equals(shop)){
                allDues+= exp.getAmount();
            }
        }
        return allDues;
    }
    public void payment(Payment payment){
        Map<String, Due>  map = new HashMap<>();
        List<Expense> expenses = repository.getExpense(payment.getUserId());
        Collections.sort(expenses,new ExpenseComparator());
        for(Expense exp : expenses){
            if(!exp.isPayed() && exp.getShop().equals(payment.getShop())){
                if(exp.getAmount() > payment.getPaymentAmount()){
                    exp.setAmount(exp.getAmount() - payment.getPaymentAmount());
                    repository.updateExpense(exp.getId(),exp, payment.getUserId());
                    return;
                }else{
                    payment.setPaymentAmount(payment.getPaymentAmount() - exp.getAmount());
                    exp.setPayed(true);
                    repository.updateExpense(exp.getId(),exp, payment.getUserId());
                }

            }
        }
    }

}
