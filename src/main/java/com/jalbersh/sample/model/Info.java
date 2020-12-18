package com.jalbersh.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

public class Info {
    @JsonProperty("statuscode")
    private long code;

    @JsonProperty("copyright")
    private Copyright copyright;

    @JsonProperty("messages")
    private String[] messages;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return code == info.code &&
                Objects.equals(copyright, info.copyright) &&
                Arrays.equals(messages, info.messages);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(code, copyright);
        result = 31 * result + Arrays.hashCode(messages);
        return result;
    }
}
