package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Loja
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Loja.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QLoja : TQRootBean<Loja, QLoja> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QLoja(true)
    }

    lateinit var id: PLong<QLoja>
    lateinit var version: PInteger<QLoja>
    lateinit var endereco: PString<QLoja>
    lateinit var nome: PString<QLoja>
    lateinit var sigla: PString<QLoja>
    lateinit var storeno: PInteger<QLoja>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Loja::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Loja::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
