package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.CL
import br.com.pintos.inventario.model.query.QCL
import io.ebean.Finder

open class CLFinder : Finder<Long, CL>(CL::class.java) {

  val alias = QCL._alias

  /**
   * Start a new typed query.
   */
  fun where(): QCL {
     return QCL(db()).setUseQueryCache(false)
  }

  /**
   * Start a new document store query.
   */
  fun text(): QCL {
     return QCL(db()).text()
  }
}
