package io.micro_spring_boot.building_blocks.cqrs.command;

import an.awesome.pipelinr.Command;

public interface ICommandRequest<R> extends Command<R> {
}
