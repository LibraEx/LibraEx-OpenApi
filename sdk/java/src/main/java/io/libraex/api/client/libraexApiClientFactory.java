package io.libraex.api.client;

import static io.libraex.api.client.impl.libraexApiServiceGenerator.getSharedClient;

import io.libraex.api.client.constant.libraexConstants;
import io.libraex.api.client.impl.libraexApiRestClientImpl;
import io.libraex.api.client.impl.libraexApiWebSocketClientImpl;
import io.libraex.api.client.impl.libraexOptionApiRestClientImpl;

/**
 * A factory for creating libraexApi client objects.
 */
public final class libraexApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    private String baseUrl = libraexConstants.API_BASE_URL;

    /**
     * Instantiates a new libraex api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private libraexApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    private libraexApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the libraex api client factory
     */
    public static libraexApiClientFactory newInstance(String apiKey, String secret) {
        return new libraexApiClientFactory(apiKey, secret);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param baseUrl
     * @param apiKey
     * @param secret
     * @return
     */
    public static libraexApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new libraexApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the libraex api client factory
     */
    public static libraexApiClientFactory newInstance() {
        return new libraexApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public libraexApiRestClient newRestClient() {
        return new libraexApiRestClientImpl(baseUrl, apiKey, secret);
    }


    public libraexApiWebSocketClient newWebSocketClient() {
        return new libraexApiWebSocketClientImpl(getSharedClient(), libraexConstants.WS_API_BASE_URL, libraexConstants.WS_API_USER_URL);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param wsApiBaseUrl
     * @param wsApiUserUrl
     * @return
     */
    public libraexApiWebSocketClient newWebSocketClient(String wsApiBaseUrl, String wsApiUserUrl) {
        return new libraexApiWebSocketClientImpl(getSharedClient(), wsApiBaseUrl, wsApiUserUrl);
    }

    /**
     * Creates a new synchronous/blocking Option REST client.
     */
    public libraexOptionApiRestClient newOptionRestClient() {
        return new libraexOptionApiRestClientImpl(baseUrl, apiKey, secret);
    }

}
