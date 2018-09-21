package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.EStatusColeta
import br.com.pintos.inventario.model.query.assoc.QAssocInventario
import br.com.pintos.inventario.model.query.assoc.QAssocLote
import br.com.pintos.inventario.model.query.assoc.QAssocUsuario
import io.ebean.EbeanServer
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Coleta.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QColeta : TQRootBean<Coleta, QColeta> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QColeta(true)
    }

    lateinit var id: PLong<QColeta>
    lateinit var version: PInteger<QColeta>
    lateinit var numleitura: PInteger<QColeta>
    lateinit var inventario: QAssocInventario<QColeta>
    lateinit var lote: QAssocLote<QColeta>
    lateinit var usuario: QAssocUsuario<QColeta>
    lateinit var coletor: PInteger<QColeta>
    lateinit var status: PEnum<QColeta, EStatusColeta>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Coleta::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Coleta::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
