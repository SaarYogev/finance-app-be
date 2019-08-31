package com.saaryogev.financeappbe.login

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier

class LoginVerifier(private val verifier: GoogleIdTokenVerifier) {
    fun verifyLogin(tokenId: String): String {
        return verifier.verify(tokenId)?.payload?.subject ?: ""
    }
}