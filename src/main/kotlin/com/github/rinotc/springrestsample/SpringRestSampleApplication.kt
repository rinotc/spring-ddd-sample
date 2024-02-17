package com.github.rinotc.springrestsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringRestSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringRestSampleApplication>(*args)
}
