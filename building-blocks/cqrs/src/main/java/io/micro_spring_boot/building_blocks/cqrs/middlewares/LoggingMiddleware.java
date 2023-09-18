package io.micro_spring_boot.building_blocks.cqrs.middlewares;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micro_spring_boot.building_blocks.cqrs.command.ICommandRequest;
import io.micro_spring_boot.building_blocks.cqrs.query.IQueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingMiddleware implements Command.Middleware {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {

        if (command instanceof IQueryRequest<?>) {
            log.info("----- Handling query {} ({})", command.getClass().getSimpleName(), writeObjectToString(command));
        } else if (command instanceof ICommandRequest<?>) {
            log.info("----- Handling command {} ({})", command.getClass().getSimpleName(), writeObjectToString(command));
        }

        var result = next.invoke();

        if (command instanceof IQueryRequest<?>) {
            log.info("----- Query {} handled", command.getClass().getSimpleName());

        } else if (command instanceof ICommandRequest<?>) {
            log.info("----- Command {} handled", command.getClass().getSimpleName());
        }
        return result;
    }

    public static String writeObjectToString(Object obj) {
        try {
            return OBJECT_MAPPER.writer(new MinimalPrettyPrinter()).writeValueAsString(obj);
        } catch (Exception e) {
            log.error("Error while writing object to string", e);
            return null;
        }
    }
}