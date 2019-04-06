package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.LojaFinder
import io.ebean.annotation.Cache
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Cache(enableQueryCache=false)
@Table(name = "loja")
class Loja(
        var endereco: String, var nome: String, var sigla: String, var storeno: Int
) : SimpleBaseModel() {
    companion object Find : LojaFinder()
}
