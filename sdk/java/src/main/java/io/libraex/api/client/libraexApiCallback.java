package io.libraex.api.client;

/**
 * libraexApiCallback is a functional interface used together with the libraexApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
@FunctionalInterface
public interface libraexApiCallback<T> {

    /**
     * Called whenever a response comes back from the libraex API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }
}
