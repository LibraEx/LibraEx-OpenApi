package io.libraex.api.client;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.libraex.api.client.constant.libraexConstants;

/**
 * libraex API error object.
 */
public class libraexApiError {

    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}
