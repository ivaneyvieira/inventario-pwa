package br.com.pintos.rest

import br.com.astrosoft.framework.viewmodel.IView
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("coletor")
class ColetorColtroler: IView {
  val sessionRepository = HashMap<String, ViewModelColetor>()
  private fun createViewModelColetor(idSession : String): ViewModelColetor {
    println("Sessão id: $idSession")
    val value = sessionRepository[idSession]
    return if(value == null) {
      val model = ViewModelColetor(this)
      sessionRepository[idSession] = model
      model
    }
    else value
  }

  val messages = Messages()

  override fun updateView() {
    //Não faz nada
  }

  override fun updateModel() {
    //Não faz nada
  }

  override fun showWarning(msg: String) {
    this.messages.msgWarning = msg
  }

  override fun showError(msg: String) {
    this.messages.msgError = msg
  }

  override fun showInfo(msg: String) {
    this.messages.msgInfo = msg
  }

  @GetMapping("/leitura/{value}/{id}")
  @ResponseBody
  fun processaLeitura(@PathVariable value: String, @PathVariable id: String?, session: HttpSession): Result {
    val idSession = if(id.isNullOrBlank() || id == "NULO") session.id else id
    val viewModel = createViewModelColetor(idSession)
    try {
      messages.emptyMessages()
      viewModel.updateModel()
      viewModel.processaLeitura(value)
    } finally {
      return Result(idSession, viewModel.toVo(), messages)
    }
  }

  @GetMapping("/viewmodel/{id}")
  @ResponseBody
  fun viewModel(@PathVariable id: String?, session: HttpSession): Result {
    val idSession = if(id.isNullOrBlank() || id == "NULO") session.id else id
    val viewModel = createViewModelColetor(idSession)
    messages.emptyMessages()
    viewModel.updateModel()
    return Result(idSession, viewModel.toVo(), messages)
  }
}

data class Result(val id: String?, val viewModel: ColetorVO, val messages: Messages)

data class Messages(var msgWarning: String = "", var msgError: String = "", var msgInfo: String = "") {
  fun emptyMessages() {
    msgError = ""
    msgWarning = ""
    msgInfo = ""
  }
}

data class ColetorVO(val lblInventario: String?, val lblUsuario: String?, val lblLote: String?, val itens: List<String>,
                     val lblLeitura: String)

fun ViewModelColetor.toVo(): ColetorVO {
  val lblInventario = inventario?.run {
    "$numero/${loja.sigla}"
  }
  val lblUsuario = usuario?.run {
    apelido
  }
  val lblLote = coleta?.run {
    "${lote.numero.padStart(3, '0')}/$numleitura"
  }
  val lista = leituras
  val last = if(lista.size < 5) lista.size else 5
  val itens = lista.sortedBy {-it.id}
    .subList(0, last)
    .map {
      "${it.leitura} - ${it.observacao}"
    }
  val lblLeitura = this.labelField
  return ColetorVO(lblInventario, lblUsuario, lblLote, itens, lblLeitura)
}

inline fun <reified T> HttpSession.get(name : String) : T? = getAttribute(name)  as? T
inline fun <reified T> HttpSession.set(name : String, value : T)  = setAttribute(name, value)

