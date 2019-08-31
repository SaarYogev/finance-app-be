package com.saaryogev.financeappbe.expenses

import org.springframework.data.repository.CrudRepository

interface ExpenseRepo : CrudRepository<Expense, Int>