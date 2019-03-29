package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.ProdutoFinder
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "produto")
class Produto(
        var barcode: String,
        var codigo: String,
        var descricao: String,
        var duplicado: Boolean,
        var foralinha: Boolean,
        var grade: String,
        var usoconsumo: Boolean,
        @ManyToOne
        var cl: CL,
        @ManyToOne
        var fornecedor: Fornecedor
) : SimpleBaseModel() {
    companion object Find : ProdutoFinder() {
      fun findLeitura(leitura: String): Produto? {
        return where().barcode.eq(leitura).findList().firstOrNull()
      }
    }
}
