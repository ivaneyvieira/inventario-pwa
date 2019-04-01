package br.com.pintos.rest

import br.com.astrosoft.framework.viewmodel.IView
import br.com.pintos.inventario.model.Loja
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("teste")
class ViewModelColetor : IView{
  val viewModel = ViewModelColetor(this)
  override fun updateView() {

  }

  override fun updateModel() {

  }

  override fun showWarning(msg: String) {

  }

  override fun showError(msg: String) {

  }

  override fun showInfo(msg: String) {

  }

  var i = 1

  @GetMapping("/hello")
  fun helloKotlin(): String {
    return "hello world ${i++}"
  }

  @GetMapping("/lojas")
  fun lojas(): List<Loja> {

    return viewModel.lojas()
  }
}