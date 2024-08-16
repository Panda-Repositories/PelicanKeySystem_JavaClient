package me.sallyio.PandaKey.common;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestProvider {
    /**
     *
     * @param uri Url to get
     * @return HttpResponse<String>
     * @throws URISyntaxException -
     * @throws IOException -
     * @throws InterruptedException -
     */
    public static HttpResponse<String> get(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .header("x-uptime-check", "sc1pnzhtj9ch54lmabdfglmwvlw7xmbisfmryknnz8")
                .header("x-content-type", "c2mxcg5asfrqounontrstufirgzhte1xvkx3n3hnyklzzm1swutotitaod0")
                .header("user-agent", "pandaauth")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
