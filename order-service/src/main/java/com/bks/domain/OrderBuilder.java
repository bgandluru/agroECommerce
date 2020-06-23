package com.bks.domain;

import java.util.Date;

public class OrderBuilder {
    private int id;
    private String type;
    private Date date;
    private double total;

    public OrderBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public OrderBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public OrderBuilder setTotal(double total) {
        this.total = total;
        return this;
    }

    public Order createOrder() {
        return new Order(id, type, date, total);
    }
}