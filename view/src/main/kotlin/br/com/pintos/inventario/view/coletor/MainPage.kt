package br.com.pintos.inventario.view.coletor

import br.com.astrosoft.framework.ui.view.LayoutView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import com.github.appreciated.app.layout.webcomponents.applayout.AppToolbar
import com.github.appreciated.card.RippleClickableCard
import com.github.appreciated.card.label.PrimaryLabel
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.BeforeLeaveEvent
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

//@Push
//@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
//@Theme(Lumo::class)
@PWA(name = "Inventários Pintos", shortName = "Inventário", iconPath = "icons/logo.png", enableInstallPrompt = true,
     themeColor = "0000ff", display = "fullscreen")
@Route("")
class MainPage: LayoutView<ViewModelColetor>() {
  override val viewModel: ViewModelColetor
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

  override fun beforeLeave(event: BeforeLeaveEvent) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateView(viewModel: ViewModel) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateModel() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  val cardUsuario = CardMenu("Usuário", "icons/user.png").apply {
    width = "100%"
    descricao = "."
    this.addClickListener {
      println("Print...")
    }
  }
  val cardInventario = CardMenu("Inventário", "icons/inventario.png").apply {
    width = "100%"
    descricao = "."
    this.addClickListener {
      println("Print...")
    }
  }
  val cardLote = CardMenu("Lote", "icons/lote.png").apply {
    width = "100%"
    descricao = "."
    this.addClickListener {
      println("Print...")
    }
  }
  val cardLeitura = CardMenu("Leitura", "icons/leitura.png").apply {
    width = "100%"
    descricao = "."
    this.addClickListener {
      println("Print...")
    }
  }
  val toolbar = HorizontalLayout().apply {
    width = "100%"
    style.set("background-color", "#0000ff")
    style.set("padding", "0px 5px")
    val label = Label("Inventário")
    label.style.set("color", "#ffffff")
    label.style.set("font-weightcd git  /inve ", "bold")
    add(label)
  }
  val textField = TextField().apply {
    width = "100%"
  }

  init {
    isPadding = false

    val layout = VerticalLayout().apply {
      add(cardInventario)
      add(cardUsuario)
      add(cardLote)
      add(cardLeitura)
    }
    expand(layout)
    val layoutTextField = HorizontalLayout().apply {
      width = "100%"
      //this.isMargin = true
      add(textField)
      expand(textField)
    }
    add(toolbar, layout, layoutTextField)
    height = "100%"
  }
}

class CardMenu(val title: String, val src: String): RippleClickableCard() {
  var descricao
    get() = secondaryLabel.text
    set(value) {
      secondaryLabel.text = value
    }
  val primaryLabel = PrimaryLabel(title)
  val secondaryLabel = Label("")

  init {
    val layout = HorizontalLayout()
    layout.width = "100%"
    layout.alignItems = CENTER
    layout.isSpacing = false
    layout.isMargin = false
    layout.isPadding = false
    layout.expand(primaryLabel)
    layout.add(IconImage(src), primaryLabel, secondaryLabel)
    add(layout)
  }
}

class IconImage(src: String): Image(src, "Icon") {
  val SIZE = "32px"

  init {
    width = SIZE
    height = SIZE
  }
}