package com.saaryogev.financeappbe.expenses

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.saaryogev.financeappbe.login.LoginVerifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExpenseController(private val expenseRepo: ExpenseRepo, tokenVerifier: GoogleIdTokenVerifier) {

    private val loginVerifier = LoginVerifier(tokenVerifier)

    @PostMapping("/expenses")
    fun addExpense(@RequestBody expense: String) {
        val expenseWithToken = ObjectMapper().readValue<Expense>(expense)
        val expenseWithUserId = Expense(expenseWithToken.amount, expenseWithToken.type, expenseWithToken.paymentMethod, expenseWithToken.paymentDate, loginVerifier.verifyLogin(expenseWithToken.userId))
        expenseRepo.save(expenseWithUserId)
    }

    @GetMapping("/expenses")
    fun getExpensesByUser(tokenId: String): MutableIterable<Expense> {
        return expenseRepo.findAllByUserId(loginVerifier.verifyLogin(tokenId))
    }
}