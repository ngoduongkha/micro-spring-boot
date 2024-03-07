package com.microspringboot.building_blocks.jpa.domain.repository

import com.microspringboot.building_blocks.jpa.domain.aggregate.AggregateRoot
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AggregateRepository<T : AggregateRoot<T>> : JpaRepository<T, UUID>