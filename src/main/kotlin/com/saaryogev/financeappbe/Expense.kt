package com.saaryogev.financeappbe

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Expense(
        val amount: Int,
        val type: String,
        val paymentMethod: String,
        val paymentDate: Date
) {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) val id: Int = 0
}