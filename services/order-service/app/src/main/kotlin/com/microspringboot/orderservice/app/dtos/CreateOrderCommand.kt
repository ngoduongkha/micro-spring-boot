package com.microspringboot.orderservice.app.dtos

import com.microspringboot.building_blocks.shared_kernel.Address
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CreateOrderCommand(
    @Valid
    @NotEmpty(message = "订单项不能为空")
    val items: List<OrderItemCommand>,

    @NotNull(message = "订单地址不能为空")
    val address: Address
)
