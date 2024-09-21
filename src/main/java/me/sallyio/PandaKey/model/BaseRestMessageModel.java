package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRestMessageModel
{
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }
}
