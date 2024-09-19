package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeylessModel {

    @JsonProperty("keyless")
    private BaseKeylessModel keyless;

    public BaseKeylessModel getKeyless() {
        return keyless;
    }
}
