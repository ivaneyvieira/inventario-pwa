package br.com.pintos.inventario.model

import br.com.pintos.framework.model.BaseModel
import br.com.pintos.inventario.model.finder.LoteFinder
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "lote")
class Lote(
        var descricao: String, var loteavulso: Boolean, var numero: String,
        @ManyToOne
        var loja: Loja
) : BaseModel() {
    companion object Find : LoteFinder()
}
