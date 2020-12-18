package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Options {
    @JsonProperty("maxResults")
    private long maxResults;

    @JsonProperty("thumbMaps")
    private boolean thumbMaps;

    @JsonProperty("ignoreLatLngInput")
    private boolean ignoreLatLngInput;

    public long getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(long maxResults) {
        this.maxResults = maxResults;
    }

    public boolean isThumbMaps() {
        return thumbMaps;
    }

    public void setThumbMaps(boolean thumbMaps) {
        this.thumbMaps = thumbMaps;
    }

    public boolean isIgnoreLatLngInput() {
        return ignoreLatLngInput;
    }

    public void setIgnoreLatLngInput(boolean ignoreLatLngInput) {
        this.ignoreLatLngInput = ignoreLatLngInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Options options = (Options) o;
        return maxResults == options.maxResults &&
                thumbMaps == options.thumbMaps &&
                ignoreLatLngInput == options.ignoreLatLngInput;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxResults, thumbMaps, ignoreLatLngInput);
    }
}
