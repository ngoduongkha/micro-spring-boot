package com.microspringboot.building_blocks.cqrs.query

import an.awesome.pipelinr.Command
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingOptions
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingResponse

interface IPagingQueryRequestHandler<C : IPagingQueryRequest<R>, R : PagingOptions> :
    Command.Handler<C, PagingResponse<R>>