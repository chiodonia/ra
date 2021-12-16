package ch.post.epof.backend.deliveryprocessor

import ch.post.epof.backend.deliveryprocessor.config.ServiceContactConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class Application

fun main(args: Array<String>) {
    SpringApplicationBuilder(Application::class.java)
        .profiles(ServiceContactConfig.systemIEnv() ?: "default")
        .run(*args)
}

