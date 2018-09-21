package br.com.pintos.inventario.model

import br.com.pintos.framework.model.BaseModel
import br.com.pintos.inventario.model.finder.InventarioFinder
import io.ebean.annotation.DbEnumValue
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "inventario")
class Inventario(
        var numero: Int, var data: LocalDate, var observacao: String,
        @Enumerated(EnumType.STRING)
        @Column(name = "tipoInventario")
        var tipoInventario: ETipoInventario,
        @Enumerated(EnumType.STRING)
        @Column(name = "statusInventario")
        var statusInventario: EStatusInventario,
        @ManyToOne
        var loja: Loja,
        @ManyToOne
        var fornecedor: Fornecedor?,
        @ManyToOne
        var cl: CL?
) : BaseModel() {
    companion object Find : InventarioFinder()
}

enum class ETipoInventario(
        @get:DbEnumValue
        val valor: String
) {
    DIVERGENCIA("Com divergencias"), SIMPLES("Simples")
}

enum class EStatusInventario(
        @get:DbEnumValue
        val valor: String
) {
    ABERTO("Aberto"), FECHADO("Fechado")
}
