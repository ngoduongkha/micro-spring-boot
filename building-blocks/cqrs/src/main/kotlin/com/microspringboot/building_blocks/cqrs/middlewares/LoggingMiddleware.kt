package com.microspringboot.building_blocks.cqrs.middlewares

import an.awesome.pipelinr.Command
import com.microspringboot.building_blocks.cqrs.query.IQueryRequest
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.microspringboot.building_blocks.cqrs.command.ICommandRequest
import com.microspringboot.building_blocks.shared_kernel.logger
import org.springframework.stereotype.Component

//@Component
//class LoggingMiddleware : Command.Middleware {
//    private val log = logger()
//
//    override fun <R, C : Command<R>> invoke(command: C, next: Command.Middleware.Next<R>): R {
//        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
//        if (command is IQueryRequest<*>) {
//            log.info("----- Handling query {} ({})", command.javaClass.simpleName, writeObjectToString(command))
//        } else if (command is ICommandRequest<*>) {
//            log.info("----- Handling command {} ({})", command.javaClass.simpleName, writeObjectToString(command))
//        }
//        val result = next.invoke()
//        if (command is IQueryRequest<*>) {
//            log.info("----- Query {} handled", command.javaClass.simpleName)
//        } else if (command is ICommandRequest<*>) {
//            log.info("----- Command {} handled", command.javaClass.simpleName)
//        }
//        return result
//    }
//
//    companion object {
//        val OBJECT_MAPPER = ObjectMapper()
//        fun writeObjectToString(obj: Any): String {
//            return try {
//                OBJECT_MAPPER.registerModule(JavaTimeModule())
//                OBJECT_MAPPER.writer(MinimalPrettyPrinter()).writeValueAsString(obj)
//            } catch (e: Exception) {
//                log.error("Error while writing object to string", e)
//            }
//        }
//    }
//}