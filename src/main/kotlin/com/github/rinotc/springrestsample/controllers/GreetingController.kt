package com.github.rinotc.springrestsample.controllers

import com.github.rinotc.springrestsample.libs.ddd.ValueObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/greeting")
    fun greeting(): Greeting {
        return Greeting(1, "Hello, World!")
    }

}

data class Greeting(val id: Long, val content: String): ValueObject