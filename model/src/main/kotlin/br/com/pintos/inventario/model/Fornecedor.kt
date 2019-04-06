package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.FornecedorFinder
import io.ebean.annotation.Cache
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Cache(enableQueryCache=false)
@Table(name = "fornecedor")
class Fornecedor(
        var codigo: String, var fantazia: String, var razao: String
) : SimpleBaseModel() {
    companion object Find : FornecedorFinder()
}
