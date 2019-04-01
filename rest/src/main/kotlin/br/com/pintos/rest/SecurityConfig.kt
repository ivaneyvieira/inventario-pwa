package br.com.pintos.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.savedrequest.NullRequestCache
import org.springframework.session.web.http.HeaderHttpSessionStrategy
import org.springframework.session.web.http.HttpSessionStrategy

@Configuration
@EnableWebSecurity
@ComponentScan("br.com.pintos.rest")
open class SecurityConfig: WebSecurityConfigurerAdapter() {
  val authProvider = CustomAuthenticationProvider()
  @Bean
  open fun httpSessionStrategy(): HttpSessionStrategy {
    return HeaderHttpSessionStrategy()
  }

  @Autowired
  @Throws(Exception::class)
  fun configureGlobal(auth: AuthenticationManagerBuilder) {
    auth.authenticationProvider(authProvider)
  }

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http.authorizeRequests().anyRequest().authenticated()
      .and()
      .httpBasic()
  }
}