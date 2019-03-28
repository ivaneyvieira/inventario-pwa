package br.com.pintos.inventario.view.coletor

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

@WebListener
class Bootstrap: ServletContextListener {
  //TODO Subir para o framework com classe abstrata
  override fun contextDestroyed(sce: ServletContextEvent?) {
  }

  override fun contextInitialized(sce: ServletContextEvent?) {
    val home = System.getenv("HOME")
    val fileName = System.getenv("EBEAN_PROPS") ?: "$home/ebean.col.properties"
    System.setProperty("ebean.props.file", fileName)
  }
}