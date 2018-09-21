package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.query.assoc.QAssocLoja
import io.ebean.EbeanServer
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Lote.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QLote : TQRootBean<Lote, QLote> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QLote(true)
    }

    lateinit var id: PLong<QLote>
    lateinit var version: PInteger<QLote>
    lateinit var descricao: PString<QLote>
    lateinit var loteavulso: PBoolean<QLote>
    lateinit var numero: PString<QLote>
    lateinit var loja: QAssocLoja<QLote>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Lote::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Lote::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
