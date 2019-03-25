package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Fornecedor
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocFornecedor.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocFornecedor<R>(name: String, root: R) : TQAssocBean<Fornecedor,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var codigo: PString<R>
  lateinit var fantazia: PString<R>
  lateinit var razao: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
