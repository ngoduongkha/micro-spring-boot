package com.microspringboot.orderservice.domain.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import java.util.UUID

class ProductNotInOrderException(productId: UUID, orderId: UUID) : AppException(
    OrderErrorCode.PRODUCT_NOT_IN_ORDER, mapOf(
        "productId" to productId,
        "orderId" to orderId
    )
)
