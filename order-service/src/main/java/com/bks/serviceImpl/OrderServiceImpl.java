package com.bks.serviceImpl;

import com.bks.domain.Order;
import com.bks.domain.OrderBuilder;
import com.bks.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    static Map<Integer, Order> orderMap = new HashMap<>();

    static {
        int orderId = new Random().nextInt();
        orderMap.put(orderId, new OrderBuilder().setId(new Random().nextInt()).setType(String.valueOf(new Random().nextInt())).setDate(new Date()).setTotal(new Random().nextDouble()).createOrder());
    }


    @Override
    public List<Order> getOrders() {
        return orderMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Order getOrder(int id) {
        return orderMap.get(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderMap.put(order.getId(), order);
    }

    @Override
    public List<Order> createOrders(List<Order> orders) {
        orders.forEach(o -> orderMap.put(o.getId(), o));
        return orders;
    }

    @Override
    public void deleteOrder(int id) {
        orderMap.remove(id);
    }

    @Override
    public void deleteOrder(List<Order> orders) {
        orders.forEach(o -> orderMap.remove(o.getId()));
    }

    @Override
    public Order updateOrder(Order order) {

        Order orderUpdate = orderMap.get(order.getId());
        orderUpdate.setDate(order.getDate());
        orderUpdate.setTotal(order.getTotal());
        orderUpdate.setType(order.getType());

        return orderUpdate;

    }

    @Override
    public List<Order> updateOrders(List<Order> orders) {
        List<Order> oList = new ArrayList<>();
        orders.forEach(o -> {

            Order order = orderMap.get(o.getId());
            order.setType(o.getType());
            order.setTotal(o.getTotal());
            order.setDate(o.getDate());

            oList.add(order);
        });

        return oList;
    }
}
