package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public class GenerateKeyModel extends BaseRestMessageModel {

    @JsonProperty("message")
    private String message;

    @JsonProperty("generatedKeys")
    private List<GeneratedKeys> generatedKeys;

    public String getMessage() {
        return message;
    }

    public List<GeneratedKeys> getGeneratedKeys() {
        return generatedKeys;
    }

    @Override
    public String toString() {
        return "GenerateKeyModel{" +
                "message='" + message + '\'' +
                ", generatedKeys=" + generatedKeys +
                '}';
    }


    public static class GeneratedKeys {

        @JsonProperty("expiresAt")
        private ZonedDateTime expireAt;

        @JsonProperty("note")
        private String note;

        @JsonProperty("value")
        private String value;

        @JsonProperty("isPremium")
        private Boolean isPremium;

        public ZonedDateTime getExpireAt() {
            return expireAt;
        }

        public String getNote() {
            return note;
        }

        public String getValue() {
            return value;
        }

        public Boolean getPremium() {
            return isPremium;
        }

        @Override
        public String toString() {
            return "GeneratedKeys{" +
                    "expireAt='" + expireAt + '\'' +
                    ", note='" + note + '\'' +
                    ", value='" + value + '\'' +
                    ", isPremium=" + isPremium +
                    '}';
        }
    }
}
