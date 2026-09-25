package spring.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(scanBasePackages = ["spring"])
@EnableAsync
@EnableScheduling
class SampleApplication

fun main(args: Array<String>) {
    runApplication<SampleApplication>(*args)
}
