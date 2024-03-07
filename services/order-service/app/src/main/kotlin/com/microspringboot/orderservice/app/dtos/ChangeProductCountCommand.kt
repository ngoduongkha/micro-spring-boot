package com.microspringboot.orderservice.app.dtos

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.util.UUID

data class ChangeProductCountCommand(
    @NotBlank(message = "产品ID不能为空")
    val productId: UUID,

    @Min(value = 1, message = "产品数量必须大于0")
    val count: Int
)
