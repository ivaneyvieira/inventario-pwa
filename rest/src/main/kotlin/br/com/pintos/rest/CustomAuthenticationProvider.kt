package br.com.pintos.rest

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider: AuthenticationProvider {
  @Throws(AuthenticationException::class)
  override fun authenticate(authentication: Authentication): Authentication? {
    val name = authentication.name
    val password = authentication.credentials.toString()

    return if(autentica(name, password)) {
      UsernamePasswordAuthenticationToken(name, password, ArrayList())
    }
    else {
      null
    }
  }

  private fun autentica(name: String?, password: String): Boolean {
    return true
  }

  override fun supports(authentication: Class<*>): Boolean {
    return authentication == UsernamePasswordAuthenticationToken::class
  }
}
