package br.com.pintos.inventario.model.finder

import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.query.QInventario
import io.ebean.Finder

open class InventarioFinder : Finder<Long, Inventario>(Inventario::class.java) {
    val alias = QInventario._alias

    /**
     * Start a new typed query.
     */
    fun where(): QInventario {
        return QInventario(db())
    }

    /**
     * Start a new document store query.
     */
    fun text(): QInventario {
        return QInventario(db()).text()
    }
}
