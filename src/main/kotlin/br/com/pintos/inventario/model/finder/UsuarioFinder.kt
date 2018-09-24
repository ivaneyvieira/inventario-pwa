package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.model.query.QUsuario
import io.ebean.Finder

open class UsuarioFinder : Finder<Long, Usuario>(Usuario::class.java) {

  val alias = QUsuario._alias

  /**
   * Start a new typed query.
   */
  fun where(): QUsuario {
     return QUsuario(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QUsuario {
     return QUsuario(db()).text()
  }
}
