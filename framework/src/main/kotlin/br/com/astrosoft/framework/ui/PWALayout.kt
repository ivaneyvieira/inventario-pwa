package br.com.astrosoft.framework.ui

import com.github.appreciated.app.layout.behaviour.Behaviour
import com.github.appreciated.app.layout.builder.AppLayoutBuilder
import com.github.appreciated.app.layout.builder.interfaces.NavigationElementContainer
import com.github.appreciated.app.layout.component.appmenu.MenuHeaderComponent
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder
import com.github.appreciated.app.layout.entity.Section.DEFAULT
import com.github.appreciated.app.layout.entity.Section.FOOTER
import com.github.appreciated.app.layout.entity.Section.HEADER
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.theme.AbstractTheme

class PWALayout : AppLayoutRouterLayout() {
  fun init(title: String = "", behaviour: Behaviour = Behaviour.LEFT_HYBRID, initLayout: AppLayoutBuilder.() -> Unit) {
    val appLayoutBuilder = AppLayoutBuilder.get(behaviour).apply {
      initLayout()
    }
    init(appLayoutBuilder.build())
  }

  protected fun AppLayoutBuilder.title(title: String) {
    withTitle(title)
  }

  protected fun AppLayoutBuilder.title(component: Component) {
    withTitle(component)
  }

  protected fun AppLayoutBuilder.theme(theme: Class<out AbstractTheme>) {
    withTheme(theme)
  }

  protected fun AppLayoutBuilder.icon(url: String) {
    withIcon(url)
  }

  protected fun AppLayoutBuilder.iconComponent(image: Component) {
    withIconComponent(image)
  }

  protected fun AppLayoutBuilder.appMenu(component: NavigationElementContainer) {
    withAppMenu(component)
  }

  protected fun AppLayoutBuilder.appBar(component: Component) {
    withAppBar(component)
  }

  protected fun AppLayoutBuilder.appMenu(subMenu: LeftAppMenuBuilder.() -> Unit) {
    val leftAppMenu = LeftAppMenuBuilder.get()
    leftAppMenu.subMenu()
    appMenu(leftAppMenu.build())
  }

  protected fun LeftAppMenuBuilder.item(element: Component) {
    add(element)
  }

  protected fun LeftAppMenuBuilder.item(caption: String, icon: VaadinIcon, className: Class<out Component>) {
    add(caption, icon, className)
  }

  protected fun LeftAppMenuBuilder.item(caption: String, icon: Icon, className: Class<out Component>) {
    add(caption, icon, className)
  }

  protected fun LeftAppMenuBuilder.sectionHeader(element: Component) {
    addToSection(element, HEADER)
  }

  protected fun LeftAppMenuBuilder.sectionFooter(element: Component) {
    addToSection(element, FOOTER)
  }

  protected fun LeftAppMenuBuilder.section(element: Component) {
    addToSection(element, DEFAULT)
  }

  protected fun LeftAppMenuBuilder.menuHeader(title: String, subtitle: String, src: String) {
    sectionHeader(MenuHeaderComponent(title, subtitle, src))
  }
}

