package ch.post.epof.backend.deliveryprocessor.api

import ch.post.epof.backend.deliveryprocessor.config.ServiceContactConfig
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DeliveryApi {

    @RequestMapping("/")
    fun index(): String? {
        return ServiceContactConfig.systemInstance()
    }

}