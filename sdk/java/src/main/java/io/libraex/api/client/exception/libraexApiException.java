package io.libraex.api.client.exception;

import io.libraex.api.client.libraexApiError;

/**
 * An exception which can occur while invoking methods of the libraex API.
 */
public class libraexApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by libraex API.
     */
    private libraexApiError error;

    /**
     * Instantiates a new libraex api exception.
     *
     * @param error an error response object
     */
    public libraexApiException(libraexApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new libraex api exception.
     */
    public libraexApiException() {
        super();
    }

    /**
     * Instantiates a new libraex api exception.
     *
     * @param message the message
     */
    public libraexApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new libraex api exception.
     *
     * @param cause the cause
     */
    public libraexApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new libraex api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public libraexApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from libraex API, or null if no response object was returned (e.g. server returned 500).
     */
    public libraexApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
