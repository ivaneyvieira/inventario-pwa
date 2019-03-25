package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.Produto
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocProduto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocProduto<R>(name: String, root: R) : TQAssocBean<Produto,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PInteger<R>
  lateinit var barcode: PString<R>
  lateinit var codigo: PString<R>
  lateinit var descricao: PString<R>
  lateinit var duplicado: PBoolean<R>
  lateinit var foralinha: PBoolean<R>
  lateinit var grade: PString<R>
  lateinit var usoconsumo: PBoolean<R>
  lateinit var cl: QAssocCL<R>
  lateinit var fornecedor: QAssocFornecedor<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
