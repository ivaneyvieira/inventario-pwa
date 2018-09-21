package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.EStatusLeitura
import br.com.pintos.inventario.model.Leitura
import br.com.pintos.inventario.model.query.assoc.QAssocColeta
import br.com.pintos.inventario.model.query.assoc.QAssocProduto
import io.ebean.EbeanServer
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Leitura.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QLeitura : TQRootBean<Leitura, QLeitura> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QLeitura(true)
    }

    lateinit var id: PLong<QLeitura>
    lateinit var version: PInteger<QLeitura>
    lateinit var hora: PLocalTime<QLeitura>
    lateinit var leitura: PString<QLeitura>
    lateinit var observacao: PString<QLeitura>
    lateinit var quant: PInteger<QLeitura>
    lateinit var status: PEnum<QLeitura, EStatusLeitura>
    lateinit var coleta: QAssocColeta<QLeitura>
    lateinit var produto: QAssocProduto<QLeitura>
    lateinit var saldo: PInteger<QLeitura>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Leitura::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Leitura::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
