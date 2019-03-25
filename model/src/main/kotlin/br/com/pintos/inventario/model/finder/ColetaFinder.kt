package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.query.QColeta
import io.ebean.Finder

open class ColetaFinder : Finder<Long, Coleta>(Coleta::class.java) {

  val alias = QColeta._alias

  /**
   * Start a new typed query.
   */
  fun where(): QColeta {
     return QColeta(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QColeta {
     return QColeta(db()).text()
  }
}
