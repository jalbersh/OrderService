package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/*
    "order_id": null,
    "total_price": "$37",
    "order_time": "Tue Dec 15 15:40:11 MST 2020",
    "expected_delivery_time": "00:33:08"
 */
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonProperty("total_price")
    private String total_price;

    @JsonProperty("order_time")
    private String order_time;

    @JsonProperty("expected_delivery_time")
    private String expected_delivery_time;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getExpected_delivery_time() {
        return expected_delivery_time;
    }

    public void setExpected_delivery_time(String expected_delivery_time) {
        this.expected_delivery_time = expected_delivery_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(total_price, order.total_price) &&
                Objects.equals(order_time, order.order_time) &&
                Objects.equals(expected_delivery_time, order.expected_delivery_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total_price, order_time, expected_delivery_time);
    }
}
