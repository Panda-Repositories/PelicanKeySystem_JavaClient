package me.sallyio.PandaKey.common;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Base64;
import java.util.Enumeration;

/**
 * Provides an identifier based on the MAC address of the hardware.
 * This can be used to generate a unique hardware identifier (HWID).
 */
public class IdentifierProvider {

    /**
     * Retrieves the hardware identifier (HWID) based on the MAC address of the device.
     * The MAC address is encoded in Base64 format.
     *
     * @return a Base64-encoded string representing the hardware identifier, or null if unable to determine the MAC address
     * @throws Exception if there is an issue retrieving the MAC address or constructing the HWID
     */
    public static String getHardwareIdentifier() throws Exception {
        try {
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            while (networks.hasMoreElements()) {
                NetworkInterface network = networks.nextElement();
                byte[] mac = network.getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    return Base64.getEncoder().encodeToString(sb.toString().getBytes());
                }
            }
        } catch (SocketException e) {
            throw new Exception("Unable to get hardware identifier: " + e.getMessage());
        }

        return null;
    }
}
