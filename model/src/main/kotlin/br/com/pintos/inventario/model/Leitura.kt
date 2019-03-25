package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.BaseModel
import br.com.pintos.inventario.model.finder.LeituraFinder
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "leitura")
class Leitura(
        var hora: LocalTime = LocalTime.now(),
        var leitura: String,
        var observacao: String,
        var quant: Int = 1,
        @Enumerated(EnumType.STRING)
        var status: EStatusLeitura,
        @ManyToOne
        var coleta: Coleta,
        @ManyToOne
        var produto: Produto?,
        var saldo: Int?
) : BaseModel() {
  companion object Find : LeituraFinder()
}

enum class EStatusLeitura {
  SUCESSO, ERRO
}
