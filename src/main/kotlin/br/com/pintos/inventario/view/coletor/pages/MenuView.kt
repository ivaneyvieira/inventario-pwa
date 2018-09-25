package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.ColetaViewModel
import br.com.pintos.inventario.viewmodel.MenuViewModel
import com.github.vok.karibudsl.flow.bind
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.horizontalLayout
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class MenuView : ViewLayout<MenuViewModel>(MenuViewModel::class.java) {
  override fun createViewModel()= MenuViewModel(this, MatriculaView::class.java)

  override val title: String
    get() = "Menu"

  override fun FormLayout.initForm() {
    textField("Loja") {
      isEnabled = false
      bind(binder).bind(MenuViewModel::inventarioLoja)
    }
    horizontalLayout {
      textField("Lote") {
        isEnabled = false
        bind(binder).bind(MenuViewModel::loteColeta)
      }
      textField("Quantidade") {
        isEnabled = false
        bind(binder).bind(MenuViewModel::quantidade.name)
      }
    }
    textField("Usuário") {
      isEnabled = false
      bind(binder).bind(MenuViewModel::usuarioApelido)
    }
  }

  override fun HorizontalLayout.initButton() {
    button("Lote") {
      addClickListener {
        viewModel.doLote()
      }
    }
    button("Coleta") {
      addClickListener {
        viewModel.doColeta()
      }
    }
    button("Apaga") {
      addClickListener {
        viewModel.doApaga()
      }
    }
    button("Sair") {
      addClickListener {
        viewModel.doVoltar()
      }
    }
  }
}