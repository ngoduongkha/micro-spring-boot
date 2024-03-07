package com.microspringboot.productservice.infra.repositories

import com.microspringboot.building_blocks.jpa.domain.repository.AggregateRepository
import com.microspringboot.productservice.domain.aggregates.categories.Category

interface CategoryRepository : AggregateRepository<Category>
