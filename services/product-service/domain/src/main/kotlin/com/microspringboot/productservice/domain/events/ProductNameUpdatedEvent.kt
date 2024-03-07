package com.microspringboot.productservice.domain.events

import java.util.*

class ProductNameUpdatedEvent(
    override val productId: UUID,
    val oldName: String,
    val newName: String,
) : ProductEvent
