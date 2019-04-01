package br.com.pintos.inventario.view.coletor

import br.com.astrosoft.framework.ui.Session
import br.com.astrosoft.framework.ui.view.LayoutView
import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.viewmodel.ViewModelColetor
import com.github.appreciated.card.RippleClickableCard
import com.github.appreciated.card.label.PrimaryLabel
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.GridVariant.LUMO_COMPACT
import com.vaadin.flow.component.grid.GridVariant.LUMO_WRAP_CELL_CONTENT
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

@Push
//@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
//@Theme(Lumo::class)
@PWA(name = "Inventários Pintos", shortName = "Inventário", iconPath = "icons/logo.png", enableInstallPrompt = true,
     themeColor = "0000ff", display = "fullscreen")
@Route("")
class MainPage: LayoutView<ViewModelColetor>() {
  override val viewModel: ViewModelColetor
    get() {
      if(Session[ViewModelColetor::class] == null) Session[ViewModelColetor::class] = ViewModelColetor(this)
      return Session[ViewModelColetor::class]!!
    }

  override fun updateView() {
    cardInventario.value = viewModel.inventario
    cardUsuario.value = viewModel.usuario
    cardColeta.value = viewModel.coleta
    val itens = viewModel.leituras.sortedBy {-it.id}
      .map {ItemProduto(it.id, it.observacao)}
    listLeitura.setItems(itens)
    itens.firstOrNull()
      ?.let {listLeitura.select(it)}


    textField.label = viewModel.labelField
    textField.focus()
  }

  override fun updateModel() {
    viewModel.inventario = cardInventario.value
    viewModel.usuario = cardUsuario.value
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
  val cardColeta = cardMenu<Coleta>("Lote", "icons/lote.png") {
    descricao {
      "${it.lote.numero}/${it.numleitura}"
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
    addValueChangeListener {
      if(it.isFromClient) {
        viewModel.processaLeitura(it.value)
        this.clear()
        this.focus()
      }
    }
  }
  val listLeitura = Grid<ItemProduto>().apply {
    this.addThemeVariants(LUMO_COMPACT, LUMO_WRAP_CELL_CONTENT)
    addColumn(ItemProduto::descricao).apply {
      setHeader("Leituras")
    }
    this.isEnabled = false
  }

  init {
    isPadding = false
    isSpacing = false

    val layout = VerticalLayout().apply {
      add(cardInventario)
      add(cardUsuario)
      add(cardColeta)
      expand(listLeitura)
      add(cardInventario, cardUsuario, cardColeta, listLeitura, textField)
    }

    expand(layout)
    add(toolbar, layout)
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
  val secondaryLabel = Label("").apply {
    width = "100%"
    style.set("text-align", "right")
  }

  init {
    val layout = HorizontalLayout()
    layout.width = "100%"
    layout.alignItems = CENTER
    layout.isSpacing = false
    layout.isMargin = false
    layout.isPadding = false
    layout.expand(primaryLabel, secondaryLabel)
    //secondaryLabel.horizontalAlignSelf = END
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

data class ItemProduto(val id : Long, val descricao: String)