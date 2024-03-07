package com.microspringboot.building_blocks.jpa.domain.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository

@NoRepositoryBean
interface ReadOnlyRepository<T, ID> : Repository<T, ID> {
    fun findAll(): List<T>
    fun findAll(sort: Sort): List<T>
    fun findAll(pageable: Pageable): Page<T>
    fun findAllById(ids: Iterable<ID>): List<T>
    fun findById(id: ID): T?
    fun count(): Long
}
