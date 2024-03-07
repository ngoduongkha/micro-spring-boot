package com.microspringboot.orderservice.app.controllers

import com.microspringboot.building_blocks.shared_kernel.models.web.PagingOptions
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingResponse
import com.microspringboot.orderservice.app.dtos.ChangeAddressDetailCommand
import com.microspringboot.orderservice.app.dtos.ChangeProductCountCommand
import com.microspringboot.orderservice.app.dtos.CreateOrderCommand
import com.microspringboot.orderservice.app.dtos.PayOrderCommand
import com.microspringboot.orderservice.app.services.OrderApplicationService
import com.microspringboot.orderservice.domain.aggregates.orders.Order
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/orders"])
class OrderController(
    val applicationService: OrderApplicationService,
) {
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createOrder(@RequestBody command: @Valid CreateOrderCommand): Map<String, UUID> {
        return mapOf("id" to applicationService.createOrder(command))
    }

    @PostMapping("/{id}/products")
    fun changeProductCount(
        @PathVariable id: UUID,
        @RequestBody command: @Valid ChangeProductCountCommand
    ) {
        applicationService.changeProductCount(id, command)
    }

    @PostMapping("/{id}/payment")
    fun pay(@PathVariable id: UUID,
            @RequestBody command: @Valid PayOrderCommand
    ) {
        applicationService.pay(id, command)
    }

    @PostMapping("/{id}/address/detail")
    fun changeAddressDetail(
        @PathVariable id: UUID,
        @RequestBody command: @Valid ChangeAddressDetailCommand
    ) {
        applicationService.changeAddressDetail(id, command.detail)
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: UUID): Order {
        return applicationService.findById(id)
    }

    @GetMapping
    fun pagedProducts(pagingOptions: PagingOptions): PagingResponse<Order> {
        return applicationService.paged(pagingOptions)
    }
}