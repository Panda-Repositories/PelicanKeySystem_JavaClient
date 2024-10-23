package me.sallyio.PandaKey.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import me.sallyio.PandaKey.model.*;
import me.sallyio.PandaKey.rest.exceptions.InvalidCountException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.HashMap;

import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;


public class RestClient {
    private final String apikey;
    private final HttpClient httpClient;
    private final Gson gson;
    private final ObjectMapper objectMapper;
    public RestClient(String apiKey) {
        this.apikey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }
    public String getApikey() {
        return this.apikey;
    }

    private <T> T requestCommonPost(URI uri, String key, Class<T> type) throws IOException, InterruptedException {
        HashMap<String, String> map = new HashMap<>();
        map.put("apiKey", this.apikey);
        map.put("keyValue", key);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(map)))
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();
        return this.objectMapper
                .readValue(
                        this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body(),
                        type
                );
    }

    /**
     * Generate one or multiple keys for your service.
     * @param expire Expiration date
     * @param count Number of keys to generate
     * @param isPremium mark keys as premium
     * @param note A note for the keys
     * @return {@link GenerateKeyModel}
     * @throws IOException
     * @throws InterruptedException
     * @throws InvalidCountException Whenever the count is less than 0
     */
    public GenerateKeyModel generateKey(LocalDate expire, Integer count, Boolean isPremium, String note) throws IOException, InterruptedException {
        if (count <= 0) {
            throw new InvalidCountException("");
        }
        String body = "{" +
                "\"apiKey\":\"" + this.apikey + "\"," +
                "\"expire\":\"" + expire.toString() + "\"," +
                "\"note\":\"" + note + "\"," +
                "\"count\":" + count.toString() + "," +
                "\"isPremium\":\"" + isPremium.toString() +
                "\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pandadevelopment.net/api/generate-key/post"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();

        return this.objectMapper
                .readValue(
                        this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body(),
                        GenerateKeyModel.class
                );
    }

    /**
     * Generate one or multiple keys for your service.
     * @param expire Expiration date
     * @param count Number of keys to generate
     * @param isPremium mark keys as premium
     * @return {@link GenerateKeyModel}
     * @throws IOException
     * @throws InterruptedException
     */
    public GenerateKeyModel generateKey(LocalDate expire, Integer count, Boolean isPremium) throws IOException, InterruptedException {
        if (count <= 0) {
            throw new InvalidCountException("");
        }
        String body = "{" +
                "\"apiKey\":\"" + this.apikey + "\"," +
                "\"expire\":\"" + expire.toString() + "\"," +
                "\"count\":" + count.toString() + "," +
                "\"isPremium\":\"" + isPremium.toString() +
                "\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pandadevelopment.net/api/generate-key/post"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();

        return this.objectMapper
                .readValue(
                        this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body(),
                        GenerateKeyModel.class
                );
    }

    /**
     * Delete a key from the system.
     * @param key The key value to delete
     * @return  {@link BaseRestMessageModel}
     * @throws IOException
     * @throws InterruptedException
     */
    public BaseRestMessageModel deleteKey(String key) throws IOException, InterruptedException {
        return this.requestCommonPost(URI.create("https://pandadevelopment.net/api/key/delete"), key, BaseRestMessageModel.class);
    }

    /**
     * Fetch key details using note, value, or hwid.
     * @param query The value to search for (note, value, or hwid)
     * @return {@link BaseKeyModel}
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public KeyModel fetchKey(String query) throws URISyntaxException, IOException, InterruptedException {
        URIBuilder builder = new URIBuilder("https://pandadevelopment.net/api/key/fetch");
        builder.addParameter("apiKey", this.apikey);
        builder.addParameter("fetch", query);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(builder.build())
                .GET()
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();

        return this.objectMapper
                .readValue(
                        this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body(),
                        KeyModel.class
                );
    }

    /**
     * Reset the HWID for a specific key.
     * @param key The key value whose HWID you want to reset
     * @return {@link BaseRestMessageModel}
     * @throws IOException
     * @throws InterruptedException
     */
    public BaseRestMessageModel resetHwid(String key) throws IOException, InterruptedException {
        return this.requestCommonPost(URI.create("https://pandadevelopment.net/api/reset-hwid"), key, BaseRestMessageModel.class);
    }

    /**
     * Delete a keyless entry from the system.
     * @param hwid The HWID to delete
     * @return {@link BaseRestMessageModel}
     * @throws IOException
     * @throws InterruptedException
     */
    public BaseRestMessageModel deleteKeyless(String hwid) throws IOException, InterruptedException {
        HashMap<String, String> map = new HashMap<>();
        map.put("apiKey", this.apikey);
        map.put("hwid", hwid);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pandadevelopment.net/api/keyless/delete"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(map)))
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();
        return this.objectMapper
                .readValue(
                        this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body(),
                        BaseRestMessageModel.class
                );
    }
    /**
     * Delete a key from the system.
     * @param key The key value to delete
     * @return  {@link BaseRestMessageModel}
     * @throws IOException
     * @throws InterruptedException
     */
    public BaseRestMessageModel deleteGenerateKey(String key) throws IOException, InterruptedException {
        return this.requestCommonPost(URI.create("https://pandadevelopment.net/api/generated-key/delete"), key, BaseRestMessageModel.class);
    }

    /**
     * Fetch a keyless entry using the HWID.
     * @param query The HWID to fetch
     * @return {@link KeylessModel}
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public KeylessModel fetchKeyless(String query) throws URISyntaxException, IOException, InterruptedException {
        URIBuilder builder = new URIBuilder("https://pandadevelopment.net/api/keyless/fetch");
        builder.addParameter("apiKey", this.apikey);
        builder.addParameter("fetch", query);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(builder.build())
                .GET()
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();

        return this.objectMapper
                .readValue(
                        this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body(),
                        KeylessModel.class
                );
    }

    /**
     * Fetch a generated key from the system using the note or key value.
     * @param query The value to search for (note or value)
     * @return {@link BaseGenerateKeyModel}
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public BaseGenerateKeyModel fetchGenereatedKey(String query) throws URISyntaxException, IOException, InterruptedException {
        URIBuilder builder = new URIBuilder("https://pandadevelopment.net/api/generated-key/fetch");
        builder.addParameter("apiKey", this.apikey);
        builder.addParameter("fetch", query);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(builder.build())
                .GET()
                .header("User-Agent", "Panda-Java-Client/1.1")
                .header("Content-Type", "application/json")
                .build();

        return this.objectMapper
                .readValue(
                        this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body(),
                        BaseGenerateKeyModel.class
                );
    }
}
