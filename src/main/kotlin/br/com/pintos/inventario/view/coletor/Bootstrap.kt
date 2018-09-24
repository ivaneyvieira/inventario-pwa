package br.com.pintos.inventario.view.coletor

import com.vaadin.flow.server.BootstrapListener
import com.vaadin.flow.server.BootstrapPageResponse
import com.vaadin.flow.server.ServiceInitEvent
import com.vaadin.flow.server.VaadinServiceInitListener
import org.jsoup.nodes.Element
import org.slf4j.LoggerFactory
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

class CustomBootstrapListener : BootstrapListener {
  override fun modifyBootstrapPage(response: BootstrapPageResponse) {
    response.document.body().appendElement("script").attr("src", "sw-register.js")
            .attr("async", "true").attr("defer", "true")
    val head = response.document.head()
    // manifest needs to be prepended before scripts or it won't be loaded
    head.prepend("""<meta name="theme-color" content="#227aef">""")
    head.prepend("""<link rel="manifest" href="manifest.json">""")
    // Add service worker
    response.document.body().appendElement("script")
            .attr("src", "sw-register.js")

    addFavIconTags(head)
  }

  private fun addFavIconTags(head: Element) {
    head.append("""<link rel="shortcut icon" href="icons/favicon.ico">""")
    head.append("""<link rel="icon" sizes="512x512" href="icons/icon-512.png">""")
    head.append("""<link rel="icon" sizes="192x192" href="icons/icon-192.png">""")
    head.append("""<link rel="icon" sizes="96x96" href="icons/icon-96.png">""")
    head.append("""<link rel="apple-touch-icon" sizes="512x512" href="icons/icon-512.png">""")
    head.append("""<link rel="apple-touch-icon" sizes="192x192" href="icons/icon-192.png">""")
    head.append("""<link rel="apple-touch-icon" sizes="96x96" href="icons/icon-96.png">""")
  }
}

/**
 * Called by the Vaadin Servlet; we will use it to hook into the initialization process, in order to be able to modify the html page a bit.
 */
class CustomVaadinServiceInitListener : VaadinServiceInitListener {
  override fun serviceInit(event: ServiceInitEvent) {
    event.addBootstrapListener(CustomBootstrapListener())
  }
}

/**
 * Called by the Servlet Container to bootstrap your app. We need to bootstrap the Vaadin-on-Kotlin framework,
 * in order to have support for the database; then we'll run Flyway migration scripts, to make sure that the database is up-to-date.
 * After that's done, your app is ready to be serving client browsers.
 */
@WebListener
class Bootstrap : ServletContextListener {
  override fun contextInitialized(sce: ServletContextEvent?) = try {
    log.info("Starting up")
    // Initializes the VoK framework
    log.info("Initializing VaadinOnKotlin")
    // Makes sure the database is up-to-date
    log.info("Running DB migrations")

    log.info("Initialization complete")
    // pre-populates the database with a demo data

  } catch (t: Throwable) {
    log.error("Bootstrap failed!", t)
    throw t
  }

  override fun contextDestroyed(sce: ServletContextEvent?) {
    log.info("Shutting down");
    log.info("Destroying VaadinOnKotlin")
    log.info("Shutdown complete")
  }

  companion object {
    @JvmStatic
    private val log = LoggerFactory.getLogger(Bootstrap::class.java)
  }
}
