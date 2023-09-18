package io.micro_spring_boot.building_blocks.cqrs.query;

import an.awesome.pipelinr.Command;

public interface IQueryRequest<R> extends Command<R> {
}
