package com.microspringboot.building_blocks.cqrs.command

import an.awesome.pipelinr.Command

interface ICommandRequest<R> : Command<R>
