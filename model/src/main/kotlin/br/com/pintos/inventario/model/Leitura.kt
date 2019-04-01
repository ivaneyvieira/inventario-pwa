package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.EStatusLeitura.ERRO
import br.com.pintos.inventario.model.EStatusLeitura.SUCESSO
import br.com.pintos.inventario.model.finder.LeituraFinder
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "leitura")
class Leitura(var hora: LocalTime = LocalTime.now(), var leitura: String, var observacao: String, var quant: Int = 1,
              @Enumerated(EnumType.STRING) var status: EStatusLeitura, @ManyToOne var coleta: Coleta, @ManyToOne
              var produto: Produto?, var saldo: Int?): SimpleBaseModel() {
  companion object Find: LeituraFinder() {
    fun addLeitura(coleta: Coleta, leituraStr: String): Leitura {
      val produto = Produto.findLeitura(leituraStr)
      val leitura =
        if(produto == null) addLeiuraErro(coleta, leituraStr) else addLeituraSucesso(coleta, leituraStr, produto)
      leitura.save()
      return leitura
    }

    private fun addLeituraSucesso(coleta: Coleta, leituraStr: String, produto: Produto): Leitura {
      return Leitura(leitura = leituraStr, observacao = "leitura ${produto.barcode} OK", quant = 1, status = SUCESSO,
                     coleta = coleta, produto = produto, saldo = null)
    }

    private fun addLeiuraErro(coleta: Coleta, leituraStr: String): Leitura {
      return Leitura(leitura = leituraStr, observacao = "Erro de leitura", quant = 0, status = ERRO, coleta = coleta,
                     produto = null, saldo = null)
    }

    fun findLeituras(coleta: Coleta?): List<Leitura> {
      coleta ?: return emptyList()
      return where().coleta.equalTo(coleta)
        .findList()
    }
  }
}

enum class EStatusLeitura {
  SUCESSO, ERRO
}
