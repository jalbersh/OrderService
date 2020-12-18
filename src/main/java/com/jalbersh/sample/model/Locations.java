package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Locations {
    @JsonProperty("street")
    private String street;

    @JsonProperty("adminArea6")
    private String adminArea6;

    @JsonProperty("adminArea6Type")
    private String adminArea6Type;

    @JsonProperty("adminArea5")
    private String adminArea5;

    @JsonProperty("adminArea5Type")
    private String adminArea5Type;

    @JsonProperty("adminArea4")
    private String adminArea4;

    @JsonProperty("adminArea4Type")
    private String adminArea4Type;

    @JsonProperty("adminArea3")
    private String adminArea3;

    @JsonProperty("adminArea3Type")
    private String adminArea3Type;

    @JsonProperty("adminArea1")
    private String adminArea1;

    @JsonProperty("adminArea1Type")
    private String adminArea1Type;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("geocodeQualityCode")
    private String geocodeQualityCode;

    @JsonProperty("geocodeQuality")
    private String geocodeQuality;

    @JsonProperty("dragPoint")
    private String dragPoint;

    @JsonProperty("sideOfStreet")
    private String sideOfStreet;

    @JsonProperty("linkId")
    private String linkId;

    @JsonProperty("unknownInput")
    private String unknownInput;

    @JsonProperty("type")
    private String type;

    @JsonProperty("latLng")
    private LatLng latLng;

    @JsonProperty("displayLatLng")
    private LatLng displayLatLng;

    @JsonProperty("mapUrl")
    private String mapUrl;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdminArea6() {
        return adminArea6;
    }

    public void setAdminArea6(String adminArea6) {
        this.adminArea6 = adminArea6;
    }

    public String getAdminArea6Type() {
        return adminArea6Type;
    }

    public void setAdminArea6Type(String adminArea6Type) {
        this.adminArea6Type = adminArea6Type;
    }

    public String getAdminArea5() {
        return adminArea5;
    }

    public void setAdminArea5(String adminArea5) {
        this.adminArea5 = adminArea5;
    }

    public String getAdminArea5Type() {
        return adminArea5Type;
    }

    public void setAdminArea5Type(String adminArea5Type) {
        this.adminArea5Type = adminArea5Type;
    }

    public String getAdminArea4() {
        return adminArea4;
    }

    public void setAdminArea4(String adminArea4) {
        this.adminArea4 = adminArea4;
    }

    public String getAdminArea4Type() {
        return adminArea4Type;
    }

    public void setAdminArea4Type(String adminArea4Type) {
        this.adminArea4Type = adminArea4Type;
    }

    public String getAdminArea3() {
        return adminArea3;
    }

    public void setAdminArea3(String adminArea3) {
        this.adminArea3 = adminArea3;
    }

    public String getAdminArea3Type() {
        return adminArea3Type;
    }

    public void setAdminArea3Type(String adminArea3Type) {
        this.adminArea3Type = adminArea3Type;
    }

    public String getAdminArea1() {
        return adminArea1;
    }

    public void setAdminArea1(String adminArea1) {
        this.adminArea1 = adminArea1;
    }

    public String getAdminArea1Type() {
        return adminArea1Type;
    }

    public void setAdminArea1Type(String adminArea1Type) {
        this.adminArea1Type = adminArea1Type;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGeocodeQualityCode() {
        return geocodeQualityCode;
    }

    public void setGeocodeQualityCode(String geocodeQualityCode) {
        this.geocodeQualityCode = geocodeQualityCode;
    }

    public String getGeocodeQuality() {
        return geocodeQuality;
    }

    public void setGeocodeQuality(String geocodeQuality) {
        this.geocodeQuality = geocodeQuality;
    }

    public String getDragPoint() {
        return dragPoint;
    }

    public void setDragPoint(String dragPoint) {
        this.dragPoint = dragPoint;
    }

    public String getSideOfStreet() {
        return sideOfStreet;
    }

    public void setSideOfStreet(String sideOfStreet) {
        this.sideOfStreet = sideOfStreet;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getUnknownInput() {
        return unknownInput;
    }

    public void setUnknownInput(String unknownInput) {
        this.unknownInput = unknownInput;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public LatLng getDisplayLatLng() {
        return displayLatLng;
    }

    public void setDisplayLatLng(LatLng displayLatLng) {
        this.displayLatLng = displayLatLng;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return Objects.equals(street, locations.street) &&
                Objects.equals(adminArea6, locations.adminArea6) &&
                Objects.equals(adminArea6Type, locations.adminArea6Type) &&
                Objects.equals(adminArea5, locations.adminArea5) &&
                Objects.equals(adminArea5Type, locations.adminArea5Type) &&
                Objects.equals(adminArea4, locations.adminArea4) &&
                Objects.equals(adminArea4Type, locations.adminArea4Type) &&
                Objects.equals(adminArea3, locations.adminArea3) &&
                Objects.equals(adminArea3Type, locations.adminArea3Type) &&
                Objects.equals(adminArea1, locations.adminArea1) &&
                Objects.equals(adminArea1Type, locations.adminArea1Type) &&
                Objects.equals(postalCode, locations.postalCode) &&
                Objects.equals(geocodeQualityCode, locations.geocodeQualityCode) &&
                Objects.equals(geocodeQuality, locations.geocodeQuality) &&
                Objects.equals(dragPoint, locations.dragPoint) &&
                Objects.equals(sideOfStreet, locations.sideOfStreet) &&
                Objects.equals(linkId, locations.linkId) &&
                Objects.equals(unknownInput, locations.unknownInput) &&
                Objects.equals(type, locations.type) &&
                Objects.equals(latLng, locations.latLng) &&
                Objects.equals(displayLatLng, locations.displayLatLng) &&
                Objects.equals(mapUrl, locations.mapUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, adminArea6, adminArea6Type, adminArea5, adminArea5Type, adminArea4, adminArea4Type, adminArea3, adminArea3Type, adminArea1, adminArea1Type, postalCode, geocodeQualityCode, geocodeQuality, dragPoint, sideOfStreet, linkId, unknownInput, type, latLng, displayLatLng, mapUrl);
    }
}
