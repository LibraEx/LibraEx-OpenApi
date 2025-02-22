package io.libraex.api.client.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.libraex.api.client.constant.libraexConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An order book entry consisting of price and quantity.
 */
@JsonDeserialize(using = OrderBookDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry {

    private String price;
    private String qty;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, libraexConstants.TO_STRING_BUILDER_STYLE)
                .append("price", price)
                .append("qty", qty)
                .toString();
    }

}
