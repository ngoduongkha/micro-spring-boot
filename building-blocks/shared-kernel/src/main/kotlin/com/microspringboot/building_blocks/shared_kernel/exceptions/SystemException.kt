package com.microspringboot.building_blocks.shared_kernel.exceptions


class SystemException(cause: Throwable) :
    AppException(CommonErrorCode.SYSTEM_ERROR, mapOf("detail" to cause.message as Any), cause)

