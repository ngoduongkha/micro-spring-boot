package com.microspringboot.productservice.app.services.impl

import com.microspringboot.productservice.app.dtos.CreateProductRequest
import com.microspringboot.productservice.app.dtos.GetProductRequest
import com.microspringboot.productservice.app.dtos.GetProductResponse
import com.microspringboot.productservice.app.services.ProductService
import com.microspringboot.productservice.domain.aggregates.products.Product
import com.microspringboot.productservice.infra.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun createProduct(productRequest: CreateProductRequest) {
        val product = Product(
//            UUID.randomUUID(),
            productRequest.skuCode,
            productRequest.name,
            productRequest.description,
            productRequest.price,
            productRequest.type
        )
        productRepository.save(product)
    }

    override fun getAllProducts(request: GetProductRequest): List<GetProductResponse> {
        val products =
            if (request.skuCode == null)
                productRepository.findAll()
            else productRepository.findBySkuCodeIn(request.skuCode)

        return products.stream().map { mapToProductResponse(it) }
            .toList()
    }

    override fun getProductById(id: UUID): GetProductResponse {
        val product = productRepository.findById(id).orElseThrow()
        return mapToProductResponse(product)
    }

    private fun mapToProductResponse(product: Product): GetProductResponse {
        return GetProductResponse(
            product.id,
            product.skuCode,
            product.name,
            product.description,
            product.price,
            product.type
        )
    }
}
