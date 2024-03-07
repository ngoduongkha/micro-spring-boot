package com.microspringboot.productservice.app.dtos

import com.microspringboot.productservice.domain.aggregates.products.ProductType
import java.util.*

data class GetProductResponse(
    val id: UUID,
    val skuCode: String,
    val name: String,
    val description: String,
    val price: Double,
    val type: ProductType
)
