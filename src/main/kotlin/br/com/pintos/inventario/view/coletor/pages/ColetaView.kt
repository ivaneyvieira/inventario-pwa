package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.ColetaViewModel
import br.com.pintos.inventario.viewmodel.LoteViewModel
import com.github.vok.karibudsl.flow.bind
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.flexGrow
import com.github.vok.karibudsl.flow.horizontalLayout
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.data.converter.StringToIntegerConverter
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class ColetaView : ViewLayout<ColetaViewModel>(ColetaViewModel::class.java) {
  override fun createViewModel() = ColetaViewModel(this, MenuView::class, LoteView::class)

  override val title: String
    get() = "Coleta"

  override fun FormLayout.initForm() {
    textField("Loja") {
      isReadOnly = true
      bind(binder).bind(ColetaViewModel::inventarioLoja)
    }
    horizontalLayout {
      textField("Lote") {
        isReadOnly = true
        bind(binder).bind(ColetaViewModel::loteColeta)
      }
      textField("Quantidade") {
        isReadOnly = true
        bind(binder).withConverter(StringToIntegerConverter("Quantidade Inválida"))
                .bind(ColetaViewModel::quantidade.name)
      }
    }
    textField("Usuário") {
      isReadOnly = true
      bind(binder).bind(ColetaViewModel::usuarioApelido)
    }
    horizontalLayout {
      flexGrow = 1.0
      textField("Código") {
        flexGrow = 1.0
        isReadOnly = true
        bind(binder).bind(ColetaViewModel::codigo)
      }
      textField("Grade") {
        flexGrow = 1.0
        isReadOnly = true
        bind(binder).bind(ColetaViewModel::grade)
      }
    }
    textField("Descrição") {
      isReadOnly = true
      bind(binder).bind(ColetaViewModel::descricao)
    }
    textField("Leitura") {
      bind(binder).bind(ColetaViewModel::leitura)
      focus()
      addValueChangeListener {
        if (it.isFromClient) {
          viewModel.doLeitura()
        }
      }
    }
  }

  override fun HorizontalLayout.initButton() {
    button("Sair") {
      addClickListener {
        viewModel.doVoltar()
      }
    }
  }
}