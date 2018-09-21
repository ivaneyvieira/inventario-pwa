package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Produto
import br.com.pintos.inventario.model.query.assoc.QAssocCL
import br.com.pintos.inventario.model.query.assoc.QAssocFornecedor
import io.ebean.EbeanServer
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Produto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QProduto : TQRootBean<Produto, QProduto> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QProduto(true)
  }

  lateinit var id: PLong<QProduto>
  lateinit var version: PInteger<QProduto>
  lateinit var barcode: PString<QProduto>
  lateinit var codigo: PString<QProduto>
  lateinit var descricao: PString<QProduto>
  lateinit var duplicado: PBoolean<QProduto>
  lateinit var foralinha: PBoolean<QProduto>
  lateinit var grade: PString<QProduto>
  lateinit var usoconsumo: PBoolean<QProduto>
  lateinit var cl: QAssocCL<QProduto>
  lateinit var fornecedor: QAssocFornecedor<QProduto>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Produto::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Produto::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
