package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Leitura
import br.com.pintos.inventario.model.query.QLeitura
import io.ebean.Finder

open class LeituraFinder : Finder<Long, Leitura>(Leitura::class.java) {
    val alias = QLeitura._alias

    /**
     * Start a new typed query.
     */
    fun where(): QLeitura {
        return QLeitura(db())
    }

    /**
     * Start a new document store query.
     */
    fun text(): QLeitura {
        return QLeitura(db()).text()
    }
}
