package com.bks.service;

import com.bks.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

     List<Order> getOrders();
     Order getOrder(int id);
     Order createOrder(Order order);
     List<Order> createOrders(List<Order> orders);
     void deleteOrder(int id);
     void deleteOrder(List<Order> orders);
     Order updateOrder(Order order);
     List<Order> updateOrders(List<Order> orders);


}
