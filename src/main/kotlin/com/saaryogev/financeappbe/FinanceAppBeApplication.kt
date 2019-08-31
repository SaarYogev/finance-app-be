package com.saaryogev.financeappbe

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

fun main(args: Array<String>) {
    runApplication<FinanceAppBeApplication>(*args)
    readLine()
}

@SpringBootApplication
class FinanceAppBeApplication

@Configuration
class Config {
    @Bean
    fun createTokenVerifier(): GoogleIdTokenVerifier {
        return GoogleIdTokenVerifier.Builder(ApacheHttpTransport(), JacksonFactory()).build()
    }
}
