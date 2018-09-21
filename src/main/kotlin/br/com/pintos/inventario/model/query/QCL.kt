package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.CL
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for CL.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QCL : TQRootBean<CL, QCL> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QCL(true)
    }

    lateinit var id: PLong<QCL>
    lateinit var version: PInteger<QCL>
    lateinit var clno: PInteger<QCL>
    lateinit var departamento: PString<QCL>
    lateinit var grupo: PString<QCL>
    lateinit var secao: PString<QCL>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(CL::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(CL::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
