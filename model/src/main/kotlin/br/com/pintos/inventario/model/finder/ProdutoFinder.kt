package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Produto
import br.com.pintos.inventario.model.query.QProduto
import io.ebean.Finder

open class ProdutoFinder : Finder<Long, Produto>(Produto::class.java) {

  val alias = QProduto._alias

  /**
   * Start a new typed query.
   */
  fun where(): QProduto {
     return QProduto(db()).setUseQueryCache(false)
  }

  /**
   * Start a new document store query.
   */
  fun text(): QProduto {
     return QProduto(db()).text()
  }
}
