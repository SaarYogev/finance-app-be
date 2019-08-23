package com.saaryogev.financeappbe

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

fun main(args: Array<String>) {
    runApplication<FinanceAppBeApplication>(*args)
    readLine()
}

@SpringBootApplication
class FinanceAppBeApplication {
    @Bean
    fun demo(repository: ExpenseRepo): CommandLineRunner {
        return CommandLineRunner {
            repository.save(Expense(2, "3", "4", Date()))
        }
    }
}
