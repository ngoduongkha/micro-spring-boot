package com.microspringboot.productservice.app.dtos


data class GetProductRequest(
    val skuCode: List<String>?
)
