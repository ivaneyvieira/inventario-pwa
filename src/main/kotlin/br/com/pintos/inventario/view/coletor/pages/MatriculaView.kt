package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.framework.view.ViewLayout
import br.com.pintos.framework.viewmodel.ViewModel
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.MatriculaViewModel
import com.github.vok.karibudsl.flow.bind
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.h3
import com.github.vok.karibudsl.flow.horizontalLayout
import com.github.vok.karibudsl.flow.setPrimary
import com.github.vok.karibudsl.flow.textField
import com.github.vok.karibudsl.flow.verticalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.converter.StringToIntegerConverter
import com.vaadin.flow.router.Route

@Route("", layout = MainLayout::class)
class MatriculaView : ViewLayout<MatriculaViewModel>(MatriculaViewModel::class.java) {
  override val viewModel: MatriculaViewModel = MatriculaViewModel(this)

  init {
    h3("Login")
    verticalLayout {
      horizontalLayout {
        textField("Matrícula") {
          width = "6em"
          bind(binder)
                  .withConverter(StringToIntegerConverter(0, "Matricula inválida"))
                  .bind(MatriculaViewModel::matricula)
          addValueChangeListener {
            if(it.isFromClient){
              viewModel.changeMatricula()
            }
          }
        }
        textField("Senha") {
          width = "6em"
          bind(binder)
                  .bind(MatriculaViewModel::senha)
        }
      }
      textField("Nome") {
        isEnabled = false
        width = "100%"
        bind(binder)
                .bind(MatriculaViewModel::nome)
      }
      setSizeFull()
    }
    button("Login") {
      setPrimary()
    }
  }
}