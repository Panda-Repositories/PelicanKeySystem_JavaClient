package me.sallyio.PandaKey.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response from the Panda validation API.
 * This class contains information about the owner, service, authentication details,
 * and key information.
 */
public class ValidationModel {

    @JsonProperty("OwnerSecretID")
    private String ownerSecretID;

    @JsonProperty("Registered_ServiceID")
    private String registeredServiceID;

    @JsonProperty("Authentication")
    private String authentication;

    @JsonProperty("V2_Authentication")
    private String v2Authentication;

    @JsonProperty("Key_Information")
    private KeyInformation keyInformation;

    @Override
    public String toString() {
        return "Validation{" +
                "ownerSecretID='" + ownerSecretID + '\'' +
                ", registeredServiceID='" + registeredServiceID + '\'' +
                ", authentication='" + authentication + '\'' +
                ", v2Authentication='" + v2Authentication + '\'' +
                ", keyInformation=" + keyInformation +
                '}';
    }

    /**
     * Retrieves the authentication string.
     *
     * @return the authentication string
     */
    public String getAuthentication() {
        return authentication;
    }

    /**
     * Retrieves the owner's secret ID.
     *
     * @return the owner&#39;s secret ID
     */
    public String getOwnerSecretID() {
        return ownerSecretID;
    }

    /**
     * Retrieves the registered service ID.
     *
     * @return the registered service ID
     */
    public String getRegisteredServiceID() {
        return registeredServiceID;
    }

    /**
     * Retrieves the key information associated with this validation.
     *
     * @return the key information
     */
    public KeyInformation getKeyInformation() {
        return keyInformation;
    }

    /**
     * Retrieves the V2 authentication string.
     *
     * @return the V2 authentication string
     */
    public String getV2Authentication() {
        return v2Authentication;
    }

    /**
     * Determines if the validation was successful.
     *
     * @return true if the {@link #getV2Authentication()} equals "success", false otherwise
     */
    public Boolean isSuccess() {
        return this.getV2Authentication().equals("success");
    }

    /**
     * Determines if the validation is in premium mode.
     *
     * @return true if in premium mode, false otherwise
     */
    public Boolean isPremium() {
        return this.getKeyInformation().isPremiumMode();
    }

    /**
     * Encapsulates key-related information used in validation.
     */
    public static class KeyInformation {

        @JsonProperty("NoKey_Requirement")
        private boolean noKeyRequirement;

        @JsonProperty("Hardware_ID")
        private String hardwareID;

        @JsonProperty("Premium_Mode")
        private boolean premiumMode;

        @JsonProperty("Notes")
        private String notes;

        @JsonProperty("expiresAt")
        private String expiresAt;

        /**
         * Checks if there is no key requirement.
         *
         * @return true if no key is required, false otherwise
         */
        public boolean isNoKeyRequirement() {
            return noKeyRequirement;
        }

        /**
         * Retrieves the hardware ID.
         *
         * @return the hardware ID
         */
        public String getHardwareID() {
            return hardwareID;
        }

        /**
         * Checks if the validation is in premium mode.
         *
         * @return true if in premium mode, false otherwise
         */
        public boolean isPremiumMode() {
            return premiumMode;
        }

        /**
         * Retrieves any additional notes.
         *
         * @return additional notes
         */
        public String getNotes() {
            return notes;
        }

        /**
         * Retrieves the expiration date of the validation.
         *
         * @return the expiration date
         */
        public String getExpiresAt() {
            return expiresAt;
        }

        @Override
        public String toString() {
            return "KeyInformation{" +
                    "noKeyRequirement=" + noKeyRequirement +
                    ", hardwareID='" + hardwareID + '\'' +
                    ", premiumMode=" + premiumMode +
                    ", notes='" + notes + '\'' +
                    ", expiresAt='" + expiresAt + '\'' +
                    '}';
        }
    }
}