package br.com.pintos.framework.model

import io.ebean.typequery.generator.Generator
import io.ebean.typequery.generator.GeneratorConfig
import java.io.IOException

object MainQueryBeanGenerator {
  
  @Throws(IOException::class)
  @JvmStatic
  fun main(args: Array<String>) {
    
    val config = GeneratorConfig()
    config.lang = "kt"
    config.classesDirectory = "./out/production/classes/"
    //config.classesDirectory = "./build/classes/kotlin/main/"
    config.destDirectory = "./src/main/kotlin"
    config.destResourceDirectory = "./src/main/resources"
  
    config.entityBeanPackage = "br.com.pintos.inventario.model"
    config.destPackage = "br.com.pintos.inventario.model.query"
  
    config.isOverwriteExistingFinders = true
    
    val generator = Generator(config)
    generator.generateQueryBeans()
    
    // Additionally generate 'finder's
    generator.generateFinders()
    generator.modifyEntityBeansAddFinderField()
  }
}