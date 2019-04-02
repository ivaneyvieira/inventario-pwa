import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  war
  id("org.springframework.boot") version "2.1.3.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

dependencies {
  compile(project(":framework"))
  compile(project(":viewmodel"))

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-tomcat")
  //implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.session:spring-session-jdbc")
  implementation("com.h2database:h2:1.4.197")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
