package com.microspringboot.orderservice.app.dtos

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PayOrderCommand(
    @NotNull(message = "支付金额不能为空")
    val  paidPrice: BigDecimal
)
