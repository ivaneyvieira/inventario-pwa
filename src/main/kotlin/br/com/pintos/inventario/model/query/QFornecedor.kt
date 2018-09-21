package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Fornecedor
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Fornecedor.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QFornecedor : TQRootBean<Fornecedor, QFornecedor> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QFornecedor(true)
    }

    lateinit var id: PLong<QFornecedor>
    lateinit var version: PInteger<QFornecedor>
    lateinit var codigo: PString<QFornecedor>
    lateinit var fantazia: PString<QFornecedor>
    lateinit var razao: PString<QFornecedor>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Fornecedor::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Fornecedor::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
