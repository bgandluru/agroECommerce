package com.bks.controller;

import com.bks.domain.Order;
import com.bks.domain.Status;
import com.bks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    private List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    private Order getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/order/{id}")
    private String deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "Order "+Status.DELETED;
    }

    @DeleteMapping("/orders")
    private String deleteOrder(@RequestBody List<Order> orders) {
        orderService.deleteOrder(orders);
        return "Orders "+Status.DELETED;
    }

    @PostMapping("/order")
    private Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/orders")
    private List<Order> createOrders(@RequestBody List<Order> orders) {
        return orderService.createOrders(orders);
    }

    @PutMapping("/order")
    private Order updateOrder(@RequestBody Order orders) {
        return orderService.updateOrder(orders);
    }

    @PutMapping("/orders")
    private List<Order> updateOrders(@RequestBody List<Order> orders) {
        return orderService.updateOrders(orders);
    }


}
