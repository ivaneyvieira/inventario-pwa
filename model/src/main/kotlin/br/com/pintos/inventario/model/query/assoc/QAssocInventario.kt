package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.EStatusInventario
import br.com.pintos.inventario.model.ETipoInventario
import br.com.pintos.inventario.model.Inventario
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocInventario.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocInventario<R>(name: String, root: R) : TQAssocBean<Inventario,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var numero: PInteger<R>
  lateinit var data: PLocalDate<R>
  lateinit var observacao: PString<R>
  lateinit var tipoInventario: PEnum<R,ETipoInventario>
  lateinit var statusInventario: PEnum<R,EStatusInventario>
  lateinit var loja: QAssocLoja<R>
  lateinit var fornecedor: QAssocFornecedor<R>
  lateinit var cl: QAssocCL<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
