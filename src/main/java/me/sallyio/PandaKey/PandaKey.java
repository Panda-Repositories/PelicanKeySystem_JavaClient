package me.sallyio.PandaKey;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.sallyio.PandaKey.common.RequestProvider;
import me.sallyio.PandaKey.model.Validation;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * The main class for interacting with the PandaKey library.
 * Provides methods to generate keys and validate them using the Panda validation API.
 */
public class PandaKey {
    public final String Base_URI = "https://pandadevelopment.net";
    private String service;
    private String identifier;

    private PandaKey(Builder builder) {
        this.service = builder.service;
        this.identifier = builder.identifier;
    }

    /**
     * Creates a new builder for constructing a PandaKey instance.
     *
     * @param service    the service name
     * @param identifier the user identifier
     * @return a new {@link Builder} instance
     */
    public static Builder newBuilder(String service, String identifier) {
        return new Builder(service, identifier);
    }
    /**
     * Creates a new builder for constructing a PandaKey instance.
     *
     * @param service    the service name
     * @return a new {@link Builder} instance
     */
    public static Builder newBuilder(String service) {
        return new Builder(service);
    }

    /**
     * Builder class for creating a {@link PandaKey} instance.
     */
    public static class Builder {
        private String service;
        private String identifier;

        /**
         * Initializes the builder with the required service name and user identifier.
         *
         * @param service    the service name
         * @param identifier the user identifier
         */
        public Builder(String service, String identifier) {
            this.service = service;
            this.identifier = identifier;
        }
        /**
         * Initializes the builder with the required service name.
         *
         * @param service    the service name
         */
        public Builder(String service) {
            this.service = service;
        }

        /**
         * Builds and returns a {@link PandaKey} instance.
         *
         * @return a new {@link PandaKey} instance
         */
        public PandaKey build() {
            return new PandaKey(this);
        }

        public Builder setService(String service) {
            this.service = service;
            return this;
        }

        public Builder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
    }

    /**
     * Constructs a URL to retrieve the key associated with the current service and identifier.
     *
     * @return the URL string to get the key
     */
    public String getKey() {
        return Base_URI + "/getkey?service=" + service + "&hwid=" + URLEncoder.encode(identifier, StandardCharsets.UTF_8);
    }

    /**
     * Validates the provided key using the Panda validation API.
     *
     * @param key the key to validate
     * @return a {@link Validation} object containing the validation results,
     * or null if validation fails
     */
    public Validation validate(String key) {
        try {
            return new ObjectMapper().readValue(
                    RequestProvider.get(Base_URI + "/v2_validation?hwid=" + identifier + "&service=" + service + "&key=" + key).body(),
                    Validation.class
            );
        } catch (Exception ignore) {
            // Handle exception silently
        }
        return null;
    }

    /**
     * Validates using keyless mode with the Panda validation API.
     *
     * @return a {@link Validation} object containing the validation results,
     * or null if validation fails
     */
    public Validation validate() {
        try {
            return new ObjectMapper().readValue(
                    RequestProvider.get(Base_URI + "/v2_validation?hwid=" + identifier + "&service=" + service + "&key=keyless").body(),
                    Validation.class
            );
        } catch (Exception ignore) {
            // Handle exception silently
        }
        return null;
    }
}
