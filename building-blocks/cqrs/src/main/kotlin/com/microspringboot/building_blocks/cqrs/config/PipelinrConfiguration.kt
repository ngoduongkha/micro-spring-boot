package com.microspringboot.building_blocks.cqrs.config

import an.awesome.pipelinr.*
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PipelinrConfiguration {
    @Bean
    open fun pipeline(
        commandHandlers: ObjectProvider<Command.Handler<*, *>?>,
        notificationHandlers: ObjectProvider<Notification.Handler<*>?>,
        middlewares: ObjectProvider<Command.Middleware?>,
        notificationMiddlewares: ObjectProvider<Notification.Middleware?>
    ): Pipeline {
        return Pipelinr()
            .with(CommandHandlers { commandHandlers.stream() })
            .with(NotificationHandlers { notificationHandlers.stream() })
            .with(Command.Middlewares { middlewares.orderedStream() })
            .with(Notification.Middlewares { notificationMiddlewares.orderedStream() })
    }
}