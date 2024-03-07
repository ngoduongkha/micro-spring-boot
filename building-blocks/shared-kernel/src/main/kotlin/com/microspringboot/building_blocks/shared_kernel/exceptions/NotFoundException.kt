package com.microspringboot.building_blocks.shared_kernel.exceptions

class NotFoundException : AppException(
    CommonErrorCode.NOT_FOUND, mapOf()
)