package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.model.query.QUsuario
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocUsuario.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocUsuario<R>(name: String, root: R) : TQAssocBean<Usuario,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var matricula: PInteger<R>
  lateinit var nome: PString<R>
  lateinit var senha: PString<R>
  lateinit var apelido: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
