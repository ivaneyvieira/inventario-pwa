package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.InventarioViewModel
import com.github.vok.karibudsl.flow.bind
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.comboBox
import com.github.vok.karibudsl.flow.setPrimary
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class InventarioView : ViewLayout<InventarioViewModel>(InventarioViewModel::class.java) {
  override fun createViewModel() = InventarioViewModel(this, MatriculaView::class, LoteView::class)

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

  override val title: String
    get() = "Inventário"

  override fun FormLayout.initForm() {
    textField("Usuário") {
      isEnabled = false
      bind(binder).bind(InventarioViewModel::usuarioApelido)
    }
    comboBox<Inventario>("Escolha o inventário") {
      this.setItems(viewModel.inventariosAberto)
      width = "100%"
      this.isAutofocus = true
      this.isOpened = true
      this.isPreventInvalidInput = true
      this.setItemLabelGenerator { inv ->
        "${inv.numero} - ${inv.observacao}"
      }
      bind(binder).bind(InventarioViewModel::inventario)
    }
    width="100%"
  }
}