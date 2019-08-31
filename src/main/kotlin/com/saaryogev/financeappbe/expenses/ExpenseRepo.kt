package com.saaryogev.financeappbe.expenses

import org.springframework.data.repository.CrudRepository

interface ExpenseRepo : CrudRepository<Expense, Int> {
    fun findAllByUserId(userId: String): MutableIterable<Expense>
}