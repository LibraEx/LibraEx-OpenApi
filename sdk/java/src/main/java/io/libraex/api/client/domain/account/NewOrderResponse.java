package io.libraex.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.libraex.api.client.constant.libraexConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderResponse {

    private Long orderId;

    private String clientOrderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .toString();
    }
}
