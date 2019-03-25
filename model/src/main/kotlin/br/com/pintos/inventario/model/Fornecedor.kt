package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.BaseModel
import br.com.pintos.inventario.model.finder.FornecedorFinder
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "fornecedor")
class Fornecedor(
        var codigo: String, var fantazia: String, var razao: String
) : BaseModel() {
    companion object Find : FornecedorFinder()
}
