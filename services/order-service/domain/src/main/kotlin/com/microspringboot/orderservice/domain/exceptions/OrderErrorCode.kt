package com.microspringboot.orderservice.domain.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.ErrorCode
import org.springframework.http.HttpStatus

enum class OrderErrorCode(override val status: HttpStatus, override val message: String) : ErrorCode {
    ORDER_CANNOT_BE_MODIFIED(HttpStatus.CONFLICT, "订单无法变更"),
    ORDER_NOT_FOUND(HttpStatus.NOT_FOUND, "没有找到订单"),
    PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE(HttpStatus.CONFLICT, "支付价格与订单实际价格不符"),
    PRODUCT_NOT_IN_ORDER(HttpStatus.CONFLICT, "订单不包含产品");

    override val code: String = name
}




