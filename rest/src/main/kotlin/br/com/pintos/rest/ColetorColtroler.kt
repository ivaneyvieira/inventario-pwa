package br.com.pintos.rest

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("coletor")
class ColetorColtroler: IView {
  val viewModel = ViewModelColetor(this)
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

  @GetMapping("/leitura/{value}")
  @ResponseBody
  fun processaLeitura(@PathVariable value: String, session: HttpSession): Result {
    messages.emptyMessages()
    try {
      viewModel.processaLeitura(value)
    } finally {
      val id = session.id
      return Result(id, viewModel, messages)
    }
  }

  @GetMapping("/viewmodel")
  @ResponseBody
  fun viewModel(session: HttpSession): Result {
    messages.emptyMessages()
    viewModel.updateModel()
    val id = session.id
    return Result(id, viewModel, messages)
  }
}

data class Result(val id: String?, val viewModel: ViewModel, val messages: Messages)

data class Messages(var msgWarning: String = "", var msgError: String = "", var msgInfo: String = "") {
  fun emptyMessages() {
    msgError = ""
    msgWarning = ""
    msgInfo = ""
  }
}