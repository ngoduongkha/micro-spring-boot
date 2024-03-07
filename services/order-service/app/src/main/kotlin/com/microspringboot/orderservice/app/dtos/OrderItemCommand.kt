package com.microspringboot.orderservice.app.dtos

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

data class OrderItemCommand(
    @NotBlank(message = "产品ID不能为空")
    val productId: UUID,

    @Min(value = 1, message = "产品数量必须大于0")
    val count: Int,

    @NotNull(message = "产品单价不能为空")
    val itemPrice: BigDecimal
)
