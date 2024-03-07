package com.microspringboot.orderservice.app.services

import com.microspringboot.building_blocks.shared_kernel.logger
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingOptions
import com.microspringboot.building_blocks.shared_kernel.models.web.PagingResponse
import com.microspringboot.orderservice.domain.aggregates.orders.Order
import com.microspringboot.orderservice.domain.aggregates.orders.OrderItem
import com.microspringboot.orderservice.app.dtos.ChangeProductCountCommand
import com.microspringboot.orderservice.app.dtos.CreateOrderCommand
import com.microspringboot.orderservice.app.dtos.PayOrderCommand
import com.microspringboot.orderservice.app.exceptions.OrderNotFoundException
import com.microspringboot.orderservice.infra.repositories.OrderRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class OrderApplicationService(
    private val orderRepository: OrderRepository,
    private val orderPaymentService: OrderPaymentService,
) {
    private val log = logger()

    @Transactional
    fun createOrder(command: CreateOrderCommand): UUID {
        val items = command.items
            .map { item ->
                OrderItem.create(
                    item.productId,
                    item.count,
                    item.itemPrice
                )
            }

        val order = Order.create(items, command.address)
        orderRepository.save(order)
        log.info("Created order[{}].", order.id)
        return order.id
    }

    @Transactional
    fun changeProductCount(id: UUID, command: ChangeProductCountCommand) {
        val order = orderRepository.findById(id)
            .orElseThrow { OrderNotFoundException(id) }
        order.changeProductCount(command.productId, command.count)
        orderRepository.save(order)
    }

    @Transactional
    fun pay(id: UUID, command: PayOrderCommand) {
        val order = orderRepository.findById(id)
            .orElseThrow { OrderNotFoundException(id) }
        orderPaymentService.pay(order, command.paidPrice)
        orderRepository.save(order)
    }

    @Transactional
    fun changeAddressDetail(id: UUID, detail: String) {
        val order = orderRepository.findById(id)
            .orElseThrow { OrderNotFoundException(id) }
        order.changeAddressDetail(detail)
        orderRepository.save(order)
    }

    fun findById(id: UUID): Order {
        return orderRepository.findById(id)
            .orElseThrow { OrderNotFoundException(id) }
    }

    fun paged(options: PagingOptions): PagingResponse<Order> {
        val res =  orderRepository.findAll(options.toPageable())
        return PagingResponse(res)
    }
}

