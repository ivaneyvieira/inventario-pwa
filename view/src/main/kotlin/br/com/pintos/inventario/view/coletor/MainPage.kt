package br.com.pintos.inventario.view.coletor

import br.com.astrosoft.framework.ui.view.LayoutView
import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import com.github.appreciated.card.RippleClickableCard
import com.github.appreciated.card.label.PrimaryLabel
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA
import org.vaadin.marcus.shortcut.Shortcut

//@Push
//@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
//@Theme(Lumo::class)
@PWA(name = "Inventários Pintos", shortName = "Inventário", iconPath = "icons/logo.png", enableInstallPrompt = true,
     themeColor = "0000ff", display = "fullscreen")
@Route("")
class MainPage: LayoutView<ViewModelColetor>() {
  override val viewModel: ViewModelColetor = ViewModelColetor(this)

  override fun updateView() {
    cardInventario.value = viewModel.inventario
    cardUsuario.value = viewModel.usuario
    cardLote.value = viewModel.lote
    cardColeta.value = viewModel.coleta

    textField.label = viewModel.labelField
  }

  override fun updateModel() {
    viewModel.inventario = cardInventario.value
    viewModel.usuario = cardUsuario.value
    viewModel.lote = cardLote.value
    viewModel.coleta = cardColeta.value
  }

  val cardUsuario = cardMenu<Usuario>("Usuário", "icons/user.png") {
    descricao {
      it.nome
    }
    this.addClickListener {
      println("Print...")
    }
  }
  val cardInventario = cardMenu<Inventario>("Inventário", "icons/inventario.png") {
    descricao {
      it.numero.toString()
    }
    this.addClickListener {
      println("Print...")
    }
  }
  val cardLote = cardMenu<Lote>("Lote", "icons/lote.png") {
    descricao {
      it.numero
    }
    this.addClickListener {
      println("Print...")
    }
  }
  val cardColeta = cardMenu<Coleta>("Coleta", "icons/leitura.png") {
    descricao {
      it.numleitura.toString()
    }
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
    label.style.set("font-weight", "bold")
    add(label)
  }
  val textField = TextField("Código de barras").apply {
    width = "100%"
    isAutofocus = true
    isClearButtonVisible = true
    val onEnter = Shortcut.Listener {
      println("Enter")
      this.value = ""
    }
    Shortcut.add(this, Key.ENTER, onEnter)
  }


  init {
    isPadding = false

    val layout = VerticalLayout().apply {
      add(cardInventario)
      add(cardUsuario)
      add(cardLote)
      add(cardColeta)
    }
    expand(layout)
    val layoutTextField = HorizontalLayout().apply {
      width = "100%"
      expand(textField)
      style.set("pading", "0px 5px")
      add(textField)
    }
    add(toolbar, layout, layoutTextField)
    height = "100%"
  }

  fun <T> cardMenu(title: String, src: String, block: CardMenu<T>.() -> Unit): CardMenu<T> {
    val cardMenu = CardMenu<T>(title, src)
    cardMenu.block()
    cardMenu.width = "100%"
    return cardMenu
  }
}

class CardMenu<T>(title: String, src: String): RippleClickableCard() {
  var value: T? = null
    set(value) {
      field = value
      secondaryLabel.text = if(value == null) "Não informado" else descricao(value)
    }
  private var descricao: (T) -> String = {""}

  fun descricao(desc: (T) -> String) {
    descricao = desc
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
    layout.expand(primaryLabel, secondaryLabel)
    layout.add(IconImage(src), primaryLabel, secondaryLabel)
    layout.style.set("padding", "0px 5px")
    add(layout)
  }
}

class IconImage(src: String): Image(src, "Icon") {
  val SIZE = "48px"

  init {
    width = SIZE
    height = SIZE
  }
}