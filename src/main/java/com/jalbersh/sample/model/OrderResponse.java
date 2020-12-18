package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/*
    "order_id": "55ec517e-50d6-4f74-8b72-67246a24b309",
    "total_price": "$50.00",
    "order_time": "16:17:55 EDT",
    "expected_delivery_time": "16:47:55 EDT"
 */
public class OrderResponse {
    @JsonProperty("order_id")
    private String order;

    @JsonProperty("total_price")
    private String price;

    @JsonProperty("order_time")
    private String order_time;

    @JsonProperty("expected_delivery_time")
    private String delivery_time;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResponse that = (OrderResponse) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(price, that.price) &&
                Objects.equals(order_time, that.order_time) &&
                Objects.equals(delivery_time, that.delivery_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, price, order_time, delivery_time);
    }
}
