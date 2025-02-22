package io.libraex.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.libraex.api.client.constant.libraexConstants;

public class HistoryOrderRequest extends OrderRequest {

    private Long orderId;

    private Long startTime;

    private Long endTime;

    private Integer limit;

    public HistoryOrderRequest() {
    }

    public HistoryOrderRequest(Integer limit) {
        super();
        this.limit = limit;
    }

    public HistoryOrderRequest(Long orderId, Integer limit) {
        super();
        this.orderId = orderId;
        this.limit = limit;
    }

    public HistoryOrderRequest(Long orderId, Long startTime, Long endTime, Integer limit) {
        super();
        this.orderId = orderId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.limit = limit;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("limit", limit)
                .toString();
    }
}
