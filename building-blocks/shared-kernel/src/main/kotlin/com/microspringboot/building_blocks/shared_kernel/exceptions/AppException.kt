package com.microspringboot.building_blocks.shared_kernel.exceptions

import org.springframework.web.server.ResponseStatusException

abstract class AppException : ResponseStatusException {
    private val error: ErrorCode
    private val data: MutableMap<String, Any> = HashMap()

    protected constructor(error: ErrorCode, data: Map<String, Any>) : super(
        error.status, format(error, data)
    ) {
        this.error = error
        this.data.putAll(data)
    }

    protected constructor(error: ErrorCode, data: Map<String, Any>, cause: Throwable) : super(
        error.status, format(error, data), cause
    ) {
        this.error = error
        this.data.putAll(data)
    }
}

private fun format(error: ErrorCode, data: Map<String, Any>): String {
    return String.format("[%s]%s:%s.", error.code, error.message, data.toString())
}