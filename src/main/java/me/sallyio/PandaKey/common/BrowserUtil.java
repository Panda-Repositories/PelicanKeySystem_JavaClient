package me.sallyio.PandaKey.common;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserUtil {
    public static void Open(String url) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
        } else {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("linux")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else if (os.contains("windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        }
    }
}
