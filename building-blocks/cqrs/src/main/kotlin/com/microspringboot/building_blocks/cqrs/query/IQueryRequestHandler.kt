package com.microspringboot.building_blocks.cqrs.query

import an.awesome.pipelinr.Command

interface IQueryRequestHandler<C : IQueryRequest<R>, R> : Command.Handler<C, R>