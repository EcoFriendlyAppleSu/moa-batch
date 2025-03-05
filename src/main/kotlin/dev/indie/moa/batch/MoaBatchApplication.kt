package dev.indie.moa.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "dev.indie.moa.batch"
])
class MoaBatchApplication

fun main(args: Array<String>) {
    runApplication<MoaBatchApplication>(*args)
}
