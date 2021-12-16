package ch.post.epof.backend.deliveryprocessor.service

import ch.post.epof.backend.deliveryprocessor.config.ServiceContactConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class DeliveryProcessorService {

    private val logger = LoggerFactory.getLogger(DeliveryProcessorService::class.java)

    @Value("\${epof.backend.delivery-processor.client-id}")
    lateinit var clientId: String

    @Scheduled(fixedDelay = 5000)
    fun process() {
        logger.info("SYSTEM_INSTANCE: {}", ServiceContactConfig.systemInstance())
        logger.info("SYSTEM_ENV: {}", ServiceContactConfig.systemIEnv())
        logger.info("SERVICE_SLOT: {}", ServiceContactConfig.serviceSlot())
        logger.info("client.id: {}", clientId)
        logger.info("transactional.id: {}", transactionalId())
    }

    private fun transactionalId(): String {
        return "${ServiceContactConfig.systemInstance()}.DeliveryProcessor-${ServiceContactConfig.serviceSlot() ?: "0"}"
    }

}