package com.microspringboot.building_blocks.shared_kernel.models.web

import org.springframework.data.domain.Page

data class PagingResponse<T>(
    private val data: List<T>,
    private val pageMetadata: PageMetadata
) {
    constructor(page: Page<T>) :
        this(page.content, PageMetadata(page))
}