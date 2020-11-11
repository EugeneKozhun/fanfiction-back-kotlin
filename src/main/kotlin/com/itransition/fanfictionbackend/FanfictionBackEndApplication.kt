package com.itransition.fanfictionbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FanfictionBackEndApplication

fun main(args: Array<String>) {
    runApplication<FanfictionBackEndApplication>(*args)
}
