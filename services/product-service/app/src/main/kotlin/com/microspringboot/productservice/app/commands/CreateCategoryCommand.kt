package com.microspringboot.productservice.app.commands

import com.microspringboot.building_blocks.cqrs.command.ICommandRequest
import com.microspringboot.building_blocks.cqrs.command.ICommandRequestHandler
import com.microspringboot.productservice.domain.aggregates.categories.Category
import com.microspringboot.productservice.infra.repositories.CategoryRepository
import jakarta.validation.constraints.NotBlank
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


data class CreateCategoryCommand(
    @NotBlank
    val name: String,

    @NotBlank
    val description: String,
) : ICommandRequest<Unit>

@Service
private class CreateCategoryCommandHandler(
    private val repository: CategoryRepository
) : ICommandRequestHandler<CreateCategoryCommand, Unit> {
    @Transactional
    override fun handle(command: CreateCategoryCommand) {
        val category = Category.create(command.name, command.description)
        repository.save(category)
    }
}
