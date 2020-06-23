package com.bks.domain;

import java.util.Date;
import java.util.Objects;

public class Order {

    private int id;
    private String type;
    private Date date;
    private double total;

    public Order(int id, String type, Date date, double total) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.total, total) == 0 &&
                type.equals(order.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, total);
    }

}
