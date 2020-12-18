package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Copyright {
    @JsonProperty("text")
    private String text;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("imageAltText")
    private String imageAltText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copyright copyright = (Copyright) o;
        return Objects.equals(text, copyright.text) &&
                Objects.equals(imageUrl, copyright.imageUrl) &&
                Objects.equals(imageAltText, copyright.imageAltText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, imageUrl, imageAltText);
    }
}
