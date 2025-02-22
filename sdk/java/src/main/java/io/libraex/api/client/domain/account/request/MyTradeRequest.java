package io.libraex.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.libraex.api.client.constant.libraexConstants;

public class MyTradeRequest extends OrderRequest {

    private Long fromId;

    private Long toId;

    private Long startTime;

    private Long endTime;

    private Integer limit;

    public MyTradeRequest() {
    }

    public MyTradeRequest(Integer limit) {
        super();
        this.limit = limit;
    }

    public MyTradeRequest(Long fromId, Integer limit) {
        super();
        this.fromId = fromId;
        this.limit = limit;
    }

    public MyTradeRequest(Long fromId, Long startTime, Long endTime, Integer limit) {
        super();
        this.fromId = fromId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.limit = limit;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
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
                .append("fromId", fromId)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("limit", limit)
                .toString();
    }
}
