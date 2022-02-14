package com.sagar46.expensetracker.controller;

import com.sagar46.expensetracker.controller.dto.ExpenseDTO;
import com.sagar46.expensetracker.service.ExpenseService;
import com.sagar46.expensetracker.service.bo.Due;
import com.sagar46.expensetracker.service.bo.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController

public class ExpenseController{


    @Autowired
    private ExpenseService expenseService;



    @GetMapping(value = "dues/{userId}")
    @ResponseBody
    public Map<String , Due> getDues(@PathVariable("userId") Integer userId){
        return expenseService.getDues(userId);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/expense")
    public void addExpense(@RequestBody ExpenseDTO d){
        Expense expense = new Expense();
        expense.setAmount(d.getAmount());
        expense.setPurpose(d.getPurpose());
        expense.setPaymentMethod(d.getPaymentMethod());
        expense.setShop(d.getShop());
        expense.setPaymentTime(d.getPaymentTime());
        expense.setDueDate(d.getDueDate());
        expense.setPayed(d.isPayed());
        expenseService.addExpense(d.getUserId(),expense);
    }

}
