package com.microspringboot.building_blocks.shared_kernel.models.web

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

abstract class PagingOptions(
    val query: String?,
    val page: @NotNull @PositiveOrZero Int,
    val pageSize: @Positive @NotNull Int,
    val sortBy: String?,
    val sortDirection: Sort.Direction?
) {
    fun toPageable(): Pageable {
        val sort =
            if (sortBy == null || sortDirection == null)
                Sort.unsorted()
            else
                Sort.by(sortDirection, sortBy)

        return PageRequest.of(page, pageSize, sort)
    }
}
