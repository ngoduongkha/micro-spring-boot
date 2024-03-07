package com.microspringboot.orderservice.app.dtos

import jakarta.validation.constraints.NotNull

data class ChangeAddressDetailCommand(
    @NotNull(message = "详细地址不能为空")
    val detail: String
)
