import io.ebean.gradle.EnhancePluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
  compile(project(":framework"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
