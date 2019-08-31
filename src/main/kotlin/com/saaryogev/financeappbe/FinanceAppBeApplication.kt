package com.saaryogev.financeappbe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<FinanceAppBeApplication>(*args)
    readLine()
}

@SpringBootApplication
class FinanceAppBeApplication
