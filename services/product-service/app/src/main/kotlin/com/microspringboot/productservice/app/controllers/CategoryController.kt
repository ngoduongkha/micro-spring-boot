package com.microspringboot.productservice.app.controllers

import an.awesome.pipelinr.Pipeline
import com.microspringboot.productservice.app.commands.CreateCategoryCommand
import com.microspringboot.productservice.app.queries.GetCategoryDetailQuery
import com.microspringboot.productservice.domain.aggregates.categories.Category
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping(value = ["/categories"])
class CategoryController(
    private val pipeline: Pipeline
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCategory(@RequestBody command: @Valid CreateCategoryCommand) {
        return pipeline.send(command)
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: UUID): Category {
        return pipeline.send(GetCategoryDetailQuery(id))
    }
}

