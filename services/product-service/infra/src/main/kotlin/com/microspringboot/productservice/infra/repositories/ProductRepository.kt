package com.microspringboot.productservice.infra.repositories

import com.microspringboot.building_blocks.jpa.domain.repository.AggregateRepository
import com.microspringboot.productservice.domain.aggregates.products.Product

interface ProductRepository : AggregateRepository<Product> {
    fun findBySkuCodeIn(skuCodes: List<String>): List<Product>
}
