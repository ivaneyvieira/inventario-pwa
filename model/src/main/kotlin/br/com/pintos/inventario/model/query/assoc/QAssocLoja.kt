package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Loja
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocLoja.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocLoja<R>(name: String, root: R) : TQAssocBean<Loja,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var endereco: PString<R>
  lateinit var nome: PString<R>
  lateinit var sigla: PString<R>
  lateinit var storeno: PInteger<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
