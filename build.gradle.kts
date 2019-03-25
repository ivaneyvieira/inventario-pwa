import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.21"
  id("org.gretty") version "2.2.0"
}

defaultTasks("clean", "build")

allprojects {
  group = "inventario-pwa"
  version = "1.0"
  repositories {
    mavenCentral()
    maven { setUrl("http://maven.vaadin.com/vaadin-addons") }
  }
}

subprojects {
  apply { plugin("kotlin") }
  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
  }

  tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
      // to see the exceptions of failed tests in Travis-CI console.
      exceptionFormat = TestExceptionFormat.FULL
    }
  }
}
dependencies {
  implementation(kotlin("stdlib-jdk8"))
}
repositories {
  mavenCentral()
}
