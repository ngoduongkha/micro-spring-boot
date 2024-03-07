package com.microspringboot.building_blocks.cqrs.query

import com.microspringboot.building_blocks.shared_kernel.models.web.PagingOptions
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingResponse

interface IPagingQueryRequest<R : PagingOptions> : IQueryRequest<PagingResponse<R>>