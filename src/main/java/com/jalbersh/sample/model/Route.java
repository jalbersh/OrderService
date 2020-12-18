package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(using = RouteDeserializer.class)
public class Route {

    @JsonProperty("distance")
    private float distance;

    @JsonProperty("formattedTime")
    private String formattedTime;

    @JsonProperty("info")
    private Info info;

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Float.compare(route.distance, distance) == 0 &&
                Objects.equals(formattedTime, route.formattedTime) &&
                Objects.equals(info, route.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, formattedTime, info);
    }
}
