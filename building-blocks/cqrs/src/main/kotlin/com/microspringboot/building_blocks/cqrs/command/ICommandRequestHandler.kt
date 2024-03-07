package com.microspringboot.building_blocks.cqrs.command

import an.awesome.pipelinr.Command

interface ICommandRequestHandler<C : ICommandRequest<R>?, R> : Command.Handler<C, R>