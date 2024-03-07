package com.microspringboot.building_blocks.jpa.domain.aggregate

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.AbstractAggregateRoot
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AggregateRoot<T : AbstractAggregateRoot<T>> : AbstractAggregateRoot<T>() {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    open var id: UUID = UUID.randomUUID()

    @CreatedBy
    open var createdBy: UUID? = null

    @LastModifiedBy
    var modifiedBy: UUID? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @Column(nullable = false, columnDefinition = "boolean default false")
    var isDeleted: Boolean = false
}