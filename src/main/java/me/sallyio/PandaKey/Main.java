package me.sallyio.PandaKey;

import me.sallyio.PandaKey.PandaKey;
import me.sallyio.PandaKey.common.IdentifierProvider;

public class Main {
    public static void main(String[] args) throws Exception {
        // Retrieve a unique hardware identifier using the IdentifierProvider class.
        String identifier = IdentifierProvider.getHardwareIdentifier();

        // Instantiate a PandaKey object with the specified service name and hardware identifier.
        PandaKey pandakey = PandaKey.newBuilder("Service name")
                .setIdentifier(identifier)
                .build();

        // Generate the key link using the PandaKey instance.
        String keyLink = pandakey.getKey();
        System.out.println("Key Link: " + keyLink);

    }
}