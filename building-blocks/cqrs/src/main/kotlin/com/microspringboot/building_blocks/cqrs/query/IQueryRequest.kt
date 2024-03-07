package com.microspringboot.building_blocks.cqrs.query

import an.awesome.pipelinr.Command

interface IQueryRequest<R> : Command<R>
