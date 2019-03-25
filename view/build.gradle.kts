import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  war
  id("org.gretty")
}

gretty {
  contextPath = "/"
  servletContainer = "jetty9.4"
}

dependencies {
  compile(project(":framework"))
  compile(project(":viewmodel"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
