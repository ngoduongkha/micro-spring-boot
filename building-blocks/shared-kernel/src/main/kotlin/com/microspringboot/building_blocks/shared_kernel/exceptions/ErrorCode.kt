package com.microspringboot.building_blocks.shared_kernel.exceptions

import org.springframework.http.HttpStatus

interface ErrorCode {
    val status: HttpStatus
    val message: String
    val code: String
}
