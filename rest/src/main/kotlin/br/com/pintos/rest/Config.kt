package br.com.pintos.rest

import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession
import javax.sql.DataSource

@Configuration
@EnableJdbcHttpSession
open class Config: AbstractHttpSessionApplicationInitializer() {
  @Bean
  open fun dataSource(): EmbeddedDatabase {
    return EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
      .addScript("org/springframework/session/jdbc/schema-h2.sql")
      .build()
  }

  @Bean
  open fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
    return DataSourceTransactionManager(dataSource)
  }
}