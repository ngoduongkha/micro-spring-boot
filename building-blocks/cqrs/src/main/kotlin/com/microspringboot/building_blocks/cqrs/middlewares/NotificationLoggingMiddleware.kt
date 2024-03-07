package com.microspringboot.building_blocks.cqrs.middlewares

import an.awesome.pipelinr.Notification
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

//@Slf4j
//@Component
//class NotificationLoggingMiddleware : Notification.Middleware {
//    override fun <N : Notification?> invoke(notification: N, next: Notification.Middleware.Next) {
//        val stopWatch = StopWatch()
//        if (notification is CronJobIntegrationEvent) {
//            log.info(
//                "----- Handling CronJobIntegrationEvent {} ({})",
//                notification.javaClass.getSimpleName(),
//                writeObjectToString(notification)
//            )
//        } else if (notification is IntegrationEvent) {
//            log.info(
//                "----- Handling IntegrationEvent {} ({})",
//                notification.javaClass.getSimpleName(),
//                writeObjectToString(notification)
//            )
//        }
//        stopWatch.start()
//        next.invoke()
//        stopWatch.stop()
//        if (notification is CronJobIntegrationEvent) {
//            log.info(
//                "----- CronJobIntegrationEvent {} handled. Elapsed Time is {}.",
//                notification.javaClass.getSimpleName(),
//                getElapsedTime(stopWatch)
//            )
//        } else if (notification is IntegrationEvent) {
//            log.info("----- IntegrationEvent {} handled", notification.javaClass.getSimpleName())
//        }
//    }
//
//    private fun getElapsedTime(stopWatch: StopWatch): String {
//        val elapsedTime = stopWatch.totalTimeMillis
//        val hours = elapsedTime / 3600000L
//        val minutes = elapsedTime / 60000L % 60
//        val seconds = elapsedTime / 1000L % 60
//        val milliseconds = elapsedTime % 1000
//        return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)
//    }
//
//    companion object {
//        val OBJECT_MAPPER = ObjectMapper()
//        fun writeObjectToString(obj: Any?): String? {
//            return try {
//                OBJECT_MAPPER.registerModule(JavaTimeModule())
//                OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
//                OBJECT_MAPPER.writer(MinimalPrettyPrinter()).writeValueAsString(obj)
//            } catch (e: Exception) {
//                log.error("Error while writing object to string", e)
//                null
//            }
//        }
//    }
//}