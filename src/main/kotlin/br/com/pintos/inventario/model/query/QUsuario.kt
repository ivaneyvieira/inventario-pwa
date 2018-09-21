package br.com.pintos.inventario.model.query

import br.com.pintos.inventario.model.Usuario
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Usuario.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QUsuario : TQRootBean<Usuario, QUsuario> {
    companion object {
        /**
         * shared 'Alias' instance used to provide
         * properties to select and fetch clauses
         */
        val _alias = QUsuario(true)
    }

    lateinit var id: PLong<QUsuario>
    lateinit var version: PInteger<QUsuario>
    lateinit var matricula: PInteger<QUsuario>
    lateinit var nome: PString<QUsuario>
    lateinit var senha: PString<QUsuario>
    lateinit var apelido: PString<QUsuario>

    /**
     * Construct with a given EbeanServer.
     */
    constructor(server: EbeanServer) : super(Usuario::class.java, server)

    /**
     * Construct using the default EbeanServer.
     */
    constructor() : super(Usuario::class.java)

    /**
     * Construct for Alias.
     */
    private constructor(dummy: Boolean) : super(dummy)
}
