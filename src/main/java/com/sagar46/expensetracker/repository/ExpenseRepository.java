package com.sagar46.expensetracker.repository;


import com.sagar46.expensetracker.repository.dao.ExpenseDAO;
import com.sagar46.expensetracker.service.bo.Expense;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class ExpenseRepository {
    HashMap<Integer, List<ExpenseDAO>> expenseStore = new HashMap<>();
    public List<Expense> getExpense(Integer id){
        ArrayList<Expense> expenses = new ArrayList<>();
        for(ExpenseDAO d :expenseStore.getOrDefault(id, Collections.emptyList())){
            Expense expense = new Expense();
            expense.setAmount(d.getAmount());
            expense.setPurpose(d.getPurpose());
            expense.setPaymentMethod(d.getPaymentMethod());
            expense.setShop(d.getShop());
            expense.setPaymentTime(d.getPaymentTime());
            expense.setDueDate(d.getDueDate());
            expense.setPayed(d.isPayed());
            expenses.add(expense);
        }

        return expenses;
    }
    public void addExpense(Integer id, Expense expense){
        ExpenseDAO expenseDAO = new ExpenseDAO();
        expenseDAO.setAmount(expense.getAmount());
        expenseDAO.setPurpose(expense.getPurpose());
        expenseDAO.setPaymentMethod(expense.getPaymentMethod());
        expenseDAO.setShop(expense.getShop());
        expenseDAO.setPaymentTime(expense.getPaymentTime());
        expenseDAO.setDueDate(expense.getDueDate());
        expenseDAO.setPayed(expense.isPayed());
        if(expenseStore.containsKey(id)){
            expenseStore.get(id).add(expenseDAO);
        }else{
            expenseStore.put(id,new ArrayList<>(Arrays.asList(expenseDAO)));
        }
    }

}
