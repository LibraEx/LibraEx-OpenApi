package io.libraex.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.libraex.api.client.constant.libraexConstants;

/**
 * Request object for canceling an order.
 */
public class CancelOrderRequest extends OrderRequest {

    private Long orderId;

    private String clientOrderId;

    public CancelOrderRequest(Long orderId) {
        super();
        this.orderId = orderId;
    }

    public CancelOrderRequest(String clientOrderId) {
        super();
        this.clientOrderId = clientOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public CancelOrderRequest orderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public CancelOrderRequest clientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .toString();
    }
}
