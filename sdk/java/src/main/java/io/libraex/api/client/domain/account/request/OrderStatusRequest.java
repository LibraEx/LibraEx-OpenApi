package io.libraex.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.libraex.api.client.constant.libraexConstants;

/**
 * A specialized order request with additional filters.
 */
public class OrderStatusRequest extends OrderRequest {

    private Long orderId;

    private String origClientOrderId;

    public OrderStatusRequest(Long orderId) {
        super();
        this.orderId = orderId;
    }

    public OrderStatusRequest(String origClientOrderId) {
        super();
        this.origClientOrderId = origClientOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderStatusRequest orderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public OrderStatusRequest origClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("origClientOrderId", origClientOrderId)
                .toString();
    }
}
