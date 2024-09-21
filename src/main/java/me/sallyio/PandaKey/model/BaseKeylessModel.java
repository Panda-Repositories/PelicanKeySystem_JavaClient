package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BaseKeylessModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("hwid")
    private String hwid;

    @JsonProperty("expiresAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime expiresAt;

    @JsonProperty("isPremium")
    private boolean isPremium;

    public String getHwid() {
        return hwid;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public String getId() {
        return id;
    }
}