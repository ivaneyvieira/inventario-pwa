package br.com.pintos.inventario.model

import br.com.pintos.framework.model.BaseModel
import br.com.pintos.inventario.model.finder.ColetaFinder
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "coleta")
class Coleta(
        var numleitura: Int,
        @ManyToOne
        @JoinColumn(name = "Inventario_id")
        var inventario: Inventario,
        @ManyToOne
        var lote: Lote,
        @ManyToOne
        var usuario: Usuario, var coletor: Int,
        @Enumerated(EnumType.STRING)
        var status: EStatusColeta
) : BaseModel() {
  fun quantidadeLeitura(): Int {
    return Leitura.where()
            .coleta.id.eq(id)
            .quant.notEqualTo(0)
            .findCount()
  }

  companion object Find : ColetaFinder()
}

enum class EStatusColeta {
    FECHADO, ABERTO
}
