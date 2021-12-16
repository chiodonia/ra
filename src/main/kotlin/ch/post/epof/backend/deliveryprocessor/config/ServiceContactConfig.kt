package ch.post.epof.backend.deliveryprocessor.config

import org.springframework.context.annotation.Configuration

@Configuration
class ServiceContactConfig {

    companion object {
        fun systemIEnv(): String? = System.getenv("SYSTEM_ENV")
        fun systemInstance(): String? = System.getenv("SYSTEM_INSTANCE")
        fun serviceSlot(): String? {
            return if (System.getenv("SERVICE_SLOT").isNullOrEmpty()) {
                if (!System.getenv("HOSTNAME").isNullOrEmpty() && System.getenv("HOSTNAME").contains('-')) {
                    System.getenv("HOSTNAME").substring(System.getenv("HOSTNAME").lastIndexOf("-") + 1)
                } else {
                    null
                }
            } else {
                System.getenv("SERVICE_SLOT")
            }
        }
    }

}