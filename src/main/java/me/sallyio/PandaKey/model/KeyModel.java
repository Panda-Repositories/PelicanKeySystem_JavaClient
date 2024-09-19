package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyModel {

    @JsonProperty("key")
    private BaseKeyModel key;

    public BaseKeyModel getKey() {
        return key;
    }
}
