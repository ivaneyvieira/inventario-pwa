import io.ebean.gradle.EnhancePluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val vaadin10_version = properties["vaadin10_version"] as String
val vok_version = properties["vok_version"] as String

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath("io.ebean:ebean-gradle-plugin:11.26.1")
  }
}

apply(plugin = "io.ebean")

configure<EnhancePluginExtension> {
  debugLevel = 9
}

dependencies {
  compile("io.ebean:ebean:11.28.1")
  compile("io.ebean:querybean-generator:11.19.1")
  compile("io.ebean:ebean-querybean:11.20.1")
  compile("io.ebean:ebean-annotation:4.2")
  compile("io.ebean.tools:finder-generator:4.2.2")

  compile ("ch.qos.logback:logback-classic:1.2.3")
  compile ("org.slf4j:slf4j-api:1.7.25")
  compile ("org.slf4j:jul-to-slf4j:1.7.25")

  compile("mysql:mysql-connector-java:5.1.47")
  compile("org.sql2o:sql2o:1.5.4")
  //Printer Cups
  compile("org.cups4j:cups4j:0.7.6")
  //ZPL Preview
  compile("org.glassfish.jersey.core:jersey-client:2.27")
  compile("org.glassfish.jersey.media:jersey-media-multipart:2.27")
  compile("org.glassfish.jersey.inject:jersey-hk2:2.27")

  implementation(kotlin("stdlib-jdk8"))
  //View
  compile(enforcedPlatform("com.vaadin:vaadin-bom:$vaadin10_version"))
  compile ("javax.servlet:javax.servlet-api:3.1.0")

  // logging
  // currently we are logging through the SLF4J API to LogBack. See logback.xml file for the logger configuration
  compile("ch.qos.logback:logback-classic:1.2.3")
  compile("org.slf4j:slf4j-api:1.7.25")
  // Kotlin
  compile(kotlin("stdlib-jdk8"))
  compile(kotlin("reflect"))
  //Karibu
  compile("com.github.mvysny.karibudsl:karibu-dsl-v10:$vok_version")
  //Utils
  compile("org.imgscalr:imgscalr-lib:4.2")
  //Addon Vaadin
  compile("com.github.appreciated:app-layout-addon:2.0.8")
  compile("org.vaadin.olli:browser-opener:0.3")
  compile("org.claspina:confirm-dialog:1.0.0")
  compile("org.vaadin.crudui:crudui:3.8.1")
  compile("com.github.appreciated:card:0.9.4")
}

repositories {
  mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
