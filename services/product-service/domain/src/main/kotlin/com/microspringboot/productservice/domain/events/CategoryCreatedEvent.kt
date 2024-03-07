package com.microspringboot.productservice.domain.events

import java.util.*

class CategoryCreatedEvent(
    override val categoryId: UUID,
    val name: String,
    val description: String
) : CategoryEvent
