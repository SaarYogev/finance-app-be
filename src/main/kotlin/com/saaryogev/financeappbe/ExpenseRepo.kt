package com.saaryogev.financeappbe

import org.springframework.data.repository.CrudRepository

interface ExpenseRepo : CrudRepository<Expense, Int>