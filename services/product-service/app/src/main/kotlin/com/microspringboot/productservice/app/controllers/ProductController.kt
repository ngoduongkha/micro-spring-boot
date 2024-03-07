package com.microspringboot.productservice.app.controllers

import com.microspringboot.productservice.app.dtos.CreateProductRequest
import com.microspringboot.productservice.app.dtos.GetProductRequest
import com.microspringboot.productservice.app.dtos.GetProductResponse
import com.microspringboot.productservice.app.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody productRequest: CreateProductRequest) {
        productService.createProduct(productRequest)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllProducts(request: GetProductRequest): List<GetProductResponse> {
        return productService.getAllProducts(request)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getProductById(@PathVariable("id") id: UUID): GetProductResponse {
        return productService.getProductById(id)
    }
}
