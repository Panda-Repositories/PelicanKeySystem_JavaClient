package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BaseGenerateKeyModel {

    @JsonProperty("generatedKey")
    private GeneratedKey generatedKey;

    public static class GeneratedKey {

        @JsonProperty("id")
        private String id;

        @JsonProperty("value")
        private String value;

        @JsonProperty("note")
        private String note;

        @JsonProperty("expiresAt")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
        private ZonedDateTime expiresAt;

        @JsonProperty("isPremium")
        private boolean isPremium;

        public String getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public String getNote() {
            return note;
        }

        public ZonedDateTime getExpiresAt() {
            return expiresAt;
        }

        public boolean isPremium() {
            return isPremium;
        }
    }

    public GeneratedKey getGeneratedKey() {
        return generatedKey;
    }
}
