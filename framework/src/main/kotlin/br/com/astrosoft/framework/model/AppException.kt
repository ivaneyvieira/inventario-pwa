package br.com.astrosoft.framework.model

import java.sql.SQLException

fun causaSqlException(causa: Throwable?): SQLException? {
  if (causa == null) return null
  var exception = causa
  var cont = 0
  while (exception !is SQLException || cont > 5) {
    exception = exception?.cause
    cont += 1
  }
  return exception
}

open class AppException(causa: Throwable?, menssagem: String) : Exception(menssagem) {
  //TODO Verificar o uso disso
  val causaSqlException = causaSqlException(causa)
}

open class DevException(causa: Throwable?, menssagem: String) : AppException(causa, menssagem)

open class UserException(causa: Throwable?, menssagem: String) : AppException(causa, menssagem)



