package com.microspringboot.building_blocks.shared_kernel.models.web

import org.springframework.data.domain.Page

data class PageMetadata(
    private val pageNumber: Int,
    private val pageSize: Int,
    private val totalPages: Int,
    private val totalElements: Long
) {
    constructor(page: Page<*>) : this(
        page.number,
        page.size,
        page.totalPages,
        page.totalElements
    )
}