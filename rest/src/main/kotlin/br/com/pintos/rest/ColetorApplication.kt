package br.com.pintos.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ColetorApplication

fun main(args: Array<String>) {
	val home = System.getenv("HOME")
	val fileName = System.getenv("EBEAN_PROPS") ?: "$home/ebean.col.properties"
	System.setProperty("ebean.props.file", fileName)
	runApplication<ColetorApplication>(*args)
}
