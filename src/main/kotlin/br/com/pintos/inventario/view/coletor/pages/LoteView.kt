package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.LoteViewModel
import com.github.vok.karibudsl.flow.bind
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.setPrimary
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class LoteView : ViewLayout<LoteViewModel>(LoteViewModel::class.java) {
  override fun createViewModel() = LoteViewModel(this, InventarioView::class.java, ColetaView::class.java)

  override val title: String
    get() = "Lote"

  override fun FormLayout.initForm() {
    textField("Loja") {
      isEnabled = false
      bind(binder).bind(LoteViewModel::inventarioLoja)
    }
    textField("Usuário") {
      isEnabled = false
      bind(binder).bind(LoteViewModel::usuarioApelido)
    }
    textField("Lote") {
      focus()
      bind(binder).bind(LoteViewModel::numLote)
    }
  }

  override fun HorizontalLayout.initButton() {
    button("Voltar") {
      addClickListener {
        viewModel.doVoltar()
      }
    }
    button("Confirmar") {
      setPrimary()
      addClickListener {
        viewModel.doConfirmar()
      }
    }
  }
}