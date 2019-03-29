package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.query.QLote
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocLote.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocLote<R>(name: String, root: R) : TQAssocBean<Lote,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var descricao: PString<R>
  lateinit var loteavulso: PBoolean<R>
  lateinit var numero: PString<R>
  lateinit var loja: QAssocLoja<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
