package io.micro_spring_boot.building_blocks.cqrs.command;

import an.awesome.pipelinr.Command;

public interface ICommandRequestHandler<C extends ICommandRequest<R>, R> extends Command.Handler<C, R> {
}