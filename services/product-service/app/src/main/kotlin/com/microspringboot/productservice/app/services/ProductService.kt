package com.microspringboot.productservice.app.services

import com.microspringboot.productservice.app.dtos.CreateProductRequest
import com.microspringboot.productservice.app.dtos.GetProductRequest
import com.microspringboot.productservice.app.dtos.GetProductResponse
import java.util.*

interface ProductService {
    fun createProduct(productRequest: CreateProductRequest)
    fun getAllProducts(request: GetProductRequest): List<GetProductResponse>
    fun getProductById(id: UUID): GetProductResponse
}
