package com.microspringboot.productservice.app.queries

import com.microspringboot.building_blocks.cqrs.query.IQueryRequest
import com.microspringboot.building_blocks.cqrs.query.IQueryRequestHandler
import com.microspringboot.building_blocks.shared_kernel.exceptions.NotFoundException
import com.microspringboot.productservice.domain.aggregates.categories.Category
import com.microspringboot.productservice.infra.repositories.CategoryRepository
import org.springframework.stereotype.Service
import java.util.UUID

data class GetCategoryDetailQuery(
    val id: UUID
) : IQueryRequest<Category>

@Service
private class GetCategoryDetailQueryHandler(
    private val categoryRepository: CategoryRepository
) : IQueryRequestHandler<GetCategoryDetailQuery, Category> {
    override fun handle(command: GetCategoryDetailQuery): Category {
        return categoryRepository.findById(command.id)
            .orElseThrow { NotFoundException() }
    }
}
