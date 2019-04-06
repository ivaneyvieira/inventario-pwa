package br.com.pintos.inventario.model


import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.EStatusColeta.ABERTO
import br.com.pintos.inventario.model.EStatusColeta.FECHADO
import br.com.pintos.inventario.model.finder.ColetaFinder
import io.ebean.annotation.Cache
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Cache(enableQueryCache=false)
@Table(name = "coleta")
class Coleta(
  var numleitura: Int,
  @ManyToOne
  @JoinColumn(name = "Inventario_id")
  var inventario: Inventario,
  @ManyToOne
  var lote: Lote,
  @ManyToOne
  var usuario: Usuario,
  var coletor: Int,
  @Enumerated(EnumType.STRING)
  var status: EStatusColeta
) : SimpleBaseModel() {
  fun quantidadeLeitura(): Int {
    return Leitura.where()
            .coleta.id.eq(id)
            .quant.notEqualTo(0)
            .findCount()
  }

  fun fechaColeta() {
    status = FECHADO
    save()
  }

  companion object Find : ColetaFinder() {
    fun findColetaAberta(inventario: Inventario?, lote: Lote?, usuario: Usuario?): Coleta? {
      inventario ?: return null
      lote ?: return null
      usuario ?: return null
      return where().inventario.id.eq(inventario.id)
        .lote.id.eq(lote.id)
        .usuario.id.eq(usuario.id)
        .status.eq(ABERTO)
        .orderBy()
        .numleitura.asc()
        .findList()
        .firstOrNull()
    }

    fun findColetaAberta(inventario: Inventario?, usuario: Usuario?): Coleta? {
      inventario ?: return null
      usuario ?: return null
      return where().inventario.id.eq(inventario.id)
        .usuario.id.eq(usuario.id)
        .status.eq(ABERTO)
        .orderBy()
        .numleitura.asc()
        .findList()
        .firstOrNull()
    }

    fun novoNumero(inventario: Inventario, lote: Lote): Int {
      return (where().inventario.id.eq(inventario.id)
              .lote.id.eq(lote.id)
              .findList()
              .asSequence()
              .map { it.numleitura }
              .max() ?: 0) + 1
    }

    fun novaColetaAberta(inventario: Inventario?, lote: Lote?, usuario: Usuario?): Coleta? {
      inventario ?: return null
      lote ?: return null
      usuario ?: return null
      val novoNumero = novoNumero(inventario, lote)
      return Coleta(novoNumero, inventario, lote, usuario, 0, ABERTO).apply {
        save()
      }
    }
  }
}

enum class EStatusColeta {
  FECHADO, ABERTO
}
