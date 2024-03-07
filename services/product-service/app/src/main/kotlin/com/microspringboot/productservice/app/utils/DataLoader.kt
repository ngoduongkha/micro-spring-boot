package com.microspringboot.productservice.app.utils

import com.microspringboot.productservice.domain.aggregates.products.Product
import com.microspringboot.productservice.domain.aggregates.products.ProductType
import com.microspringboot.productservice.infra.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
@Suppress("MagicNumber")
class DataLoader (
    private val productRepository: ProductRepository
) : CommandLineRunner {
    override fun run(vararg args: String) {
        if (productRepository.count() < 1) {
            val products = listOf(
                Product(
                    "iphone_13",
                    "iPhone 13",
                    "iPhone 13",
                    1000.0,
                    ProductType.SINGLE
                ),
                Product(
                    "iphone_13_pro",
                    "iPhone 13 Pro",
                    "iPhone 13 Pro",
                    1200.0,
                    ProductType.SINGLE
                ),
                Product(
                    "iphone_13_pro_max",
                    "iPhone 13 Pro Max",
                    "iPhone 13 Pro Max",
                    1300.0,
                    ProductType.SINGLE
                ),
                Product(
                    "iphone_13_mini",
                    "iPhone 13 Mini",
                    "iPhone 13 Mini",
                    900.0,
                    ProductType.SINGLE
                )
            )
            productRepository.saveAll(products)
        }
    }
}
