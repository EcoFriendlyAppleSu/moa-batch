package dev.indie.app.moa.batch

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan(basePackages = [
    "dev.indie.**.infrastructures.mappers"
])
@SpringBootApplication(scanBasePackages = [
    "dev.indie.app.moa"
])
class MoaBatchApplication

fun main(args: Array<String>) {
    runApplication<MoaBatchApplication>(*args)
}
