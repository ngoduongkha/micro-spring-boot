package com.microspringboot.productservice.domain.aggregates.products

import com.microspringboot.building_blocks.jpa.domain.aggregate.AggregateRoot
import com.microspringboot.productservice.domain.events.ProductNameUpdatedEvent
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcType
import org.hibernate.dialect.PostgreSQLEnumJdbcType
import java.util.*

@Entity
@Table(name = "products")
class Product(
    @Column(nullable = false, columnDefinition = "varchar(50)", unique = true)
    var skuCode: String,

    @Column(nullable = false, columnDefinition = "varchar(50)")
    var name: String,

    @Column(columnDefinition = "text")
    var description: String,

    @Column(nullable = false, columnDefinition = "double precision")
    var price: Double,

    @Column(nullable = false)
    @JdbcType(PostgreSQLEnumJdbcType::class)
    var type: ProductType,
) : AggregateRoot<Product>() {
    fun updateName(newName: String) {
        registerEvent(ProductNameUpdatedEvent(id, name, newName))
        name = newName
    }
}
