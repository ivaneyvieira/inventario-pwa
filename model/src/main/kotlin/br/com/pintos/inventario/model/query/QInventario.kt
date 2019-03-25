package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.EStatusInventario
import br.com.pintos.inventario.model.ETipoInventario
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.query.assoc.QAssocCL
import br.com.pintos.inventario.model.query.assoc.QAssocFornecedor
import br.com.pintos.inventario.model.query.assoc.QAssocLoja
import io.ebean.EbeanServer
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Inventario.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QInventario : TQRootBean<Inventario, QInventario> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QInventario(true)
  }

  lateinit var id: PLong<QInventario>
  lateinit var version: PInteger<QInventario>
  lateinit var numero: PInteger<QInventario>
  lateinit var data: PLocalDate<QInventario>
  lateinit var observacao: PString<QInventario>
  lateinit var tipoInventario: PEnum<QInventario,ETipoInventario>
  lateinit var statusInventario: PEnum<QInventario,EStatusInventario>
  lateinit var loja: QAssocLoja<QInventario>
  lateinit var fornecedor: QAssocFornecedor<QInventario>
  lateinit var cl: QAssocCL<QInventario>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Inventario::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Inventario::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
