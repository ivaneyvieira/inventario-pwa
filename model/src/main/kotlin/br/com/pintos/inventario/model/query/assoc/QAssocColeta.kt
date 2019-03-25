package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.EStatusColeta
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocColeta.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocColeta<R>(name: String, root: R) : TQAssocBean<Coleta,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var numleitura: PInteger<R>
  lateinit var inventario: QAssocInventario<R>
  lateinit var lote: QAssocLote<R>
  lateinit var usuario: QAssocUsuario<R>
  lateinit var coletor: PInteger<R>
  lateinit var status: PEnum<R,EStatusColeta>

  // type safe fetch(properties) using varargs not supported yet ...
}
