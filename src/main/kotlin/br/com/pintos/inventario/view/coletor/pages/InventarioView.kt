package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.InventarioViewModel
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.comboBox
import com.github.vok.karibudsl.flow.setPrimary
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class InventarioView : ViewLayout<InventarioViewModel>(InventarioViewModel::class.java) {
  override fun createViewModel() = InventarioViewModel(this, MatriculaView::class.java)

  override fun HorizontalLayout.initButton() {
    button("Confirmar") {
      setPrimary()
      addClickListener {
        viewModel.doConfirmar()
      }
    }
    button("Voltar") {
      setPrimary()
      addClickListener {
        viewModel.doVoltar()
      }
    }
  }

  override val title: String
    get() = "Inventário"

  override fun FormLayout.initForm() {
    comboBox<Inventario>("Escolha o inventário") {
      this.setItems(viewModel.inventariosAberto)
      width = "100%"
      this.isAutofocus = true
      this.isOpened = true
      this.isPreventInvalidInput = true
      this.setItemLabelGenerator { inv ->
        "${inv.numero} - ${inv.observacao}"
      }
    }
    width="100%"
  }
}