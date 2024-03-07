package com.microspringboot.productservice.domain.aggregates.categories

import com.microspringboot.building_blocks.jpa.domain.aggregate.AggregateRoot
import com.microspringboot.productservice.domain.events.CategoryCreatedEvent
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "categories")
class Category(
    var name: String,
    var description: String
) : AggregateRoot<Category>() {
    companion object {
        fun create(name: String, description: String): Category {
            val id = UUID.randomUUID()
            val category = Category(name, description)
            category.registerEvent(CategoryCreatedEvent(id, name, description))
            return category
        }
    }
}
