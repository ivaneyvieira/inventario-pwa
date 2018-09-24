package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.CL
import br.com.pintos.inventario.model.query.QCL
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocCL.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocCL<R>(name: String, root: R) : TQAssocBean<CL,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var clno: PInteger<R>
  lateinit var departamento: PString<R>
  lateinit var grupo: PString<R>
  lateinit var secao: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
