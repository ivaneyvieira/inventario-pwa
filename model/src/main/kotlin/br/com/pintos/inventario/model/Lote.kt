package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.LoteFinder
import io.ebean.annotation.Cache
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Cache(enableQueryCache=false)
@Table(name = "lote")
class Lote(
  var descricao: String,
  var loteavulso: Boolean,
  var numero: String,
  @ManyToOne
  var loja: Loja
) : SimpleBaseModel() {
  companion object Find : LoteFinder() {
    fun findNumLote(numLote: String?, loja: Loja?): Lote? {
      numLote ?: return null
      loja ?: return null
      return if (numLote.matches("LOT[0-9]+".toRegex())) {
        val numTxt = numLote.substring(3).toIntOrNull()
        where().numero.eq("$numTxt")
                .loja.id.eq(loja.id)
                .findList()
                .firstOrNull()
      } else null
    }
  }
}
