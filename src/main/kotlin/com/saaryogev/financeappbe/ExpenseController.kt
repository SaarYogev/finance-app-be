package com.saaryogev.financeappbe

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExpenseController(private val expenseRepo: ExpenseRepo) {

    @PostMapping("/expense")
    fun addExpense(@RequestBody expense: Expense) {
        expenseRepo.save(expense)
    }

    @PostMapping("/expenseString")
    fun addExpense(@RequestBody expense: String) {
        expenseRepo.save(ObjectMapper().readValue(expense))
    }

    @GetMapping("/expense")
    fun getExpenses(): MutableIterable<Expense> {
        return expenseRepo.findAll()
    }
}