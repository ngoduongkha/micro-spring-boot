package io.micro_spring_boot.building_blocks.cqrs.query;

import an.awesome.pipelinr.Command;

public interface IQueryRequestHandler<C extends IQueryRequest<R>, R> extends Command.Handler<C, R> {
}