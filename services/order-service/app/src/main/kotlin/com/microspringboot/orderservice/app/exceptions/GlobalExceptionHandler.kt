package com.microspringboot.orderservice.app.exceptions

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler()

