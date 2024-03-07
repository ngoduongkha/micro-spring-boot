package com.microspringboot.building_blocks.shared_kernel.exceptions

import org.springframework.http.HttpStatus

enum class CommonErrorCode(
    override val status: HttpStatus,
    override val message: String,
) : ErrorCode {
    LOCK_OCCUPIED(HttpStatus.CONFLICT, "Conflict"),
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not found");

    override val code: String = name
}