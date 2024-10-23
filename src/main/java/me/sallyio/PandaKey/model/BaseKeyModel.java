package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BaseKeyModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    @JsonProperty("note")
    private String note;

    @JsonProperty("hwid")
    private String hwid;

    @JsonProperty("expiresAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime expiresAt;

    @JsonProperty("isPremium")
    private boolean isPremium;

    @JsonProperty("lastResetAt")
    private String lastResetAt;

    @JsonProperty("serviceId")
    private String serviceId;

    @Override
    public String toString() {
        return "BaseKeyModel{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", note='" + note + '\'' +
                ", hwid='" + hwid + '\'' +
                ", expiresAt=" + expiresAt +
                ", isPremium=" + isPremium +
                ", lastResetAt='" + lastResetAt + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }

    public String getLastResetAt() {
        return lastResetAt;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getNote() {
        return note;
    }

    public String getHwid() {
        return hwid;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public boolean isPremium() {
        return isPremium;
    }
}
