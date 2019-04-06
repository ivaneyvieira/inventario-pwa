package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Fornecedor
import br.com.pintos.inventario.model.query.QFornecedor
import io.ebean.Finder

open class FornecedorFinder : Finder<Long, Fornecedor>(Fornecedor::class.java) {

  val alias = QFornecedor._alias

  /**
   * Start a new typed query.
   */
  fun where(): QFornecedor {
     return QFornecedor(db()).setUseQueryCache(false)
  }

  /**
   * Start a new document store query.
   */
  fun text(): QFornecedor {
     return QFornecedor(db()).text()
  }
}
