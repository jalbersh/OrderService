package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;

/*
{
    "user_id": "55ec517e-50d6-4f74-8b72-67246a24b309",
    "restuarant_id": "55ec517e-50d6-4f74-8b72-67246a24b30c",
    "menue_item": ["55ec517e-50d6-4f74-8b72-67246a24b304"]
    "tip": "$10.00"
}
 */
public class OrderRequest implements Serializable {
    public OrderRequest() {
        items = new HashSet<>();
    }

    @JsonProperty("user_id")
    private String user;

    @JsonProperty("restaurant_id")
    private String restaurant;

    @JsonProperty("menuItems")
    private Set<String> items;

    @JsonProperty("tip")
    private String tip;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Set<String> getItems() {
        return items;
    }

    public void setItems(Set<String> items) {
        this.items = items;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(restaurant, that.restaurant) &&
                Objects.equals(items, that.items) &&
                Objects.equals(tip, that.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, restaurant, items, tip);
    }
}
