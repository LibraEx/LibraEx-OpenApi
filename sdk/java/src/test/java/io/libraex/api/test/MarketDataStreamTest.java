package io.libraex.api.test;

import io.libraex.api.client.libraexApiClientFactory;
import io.libraex.api.client.libraexApiWebSocketClient;
import io.libraex.api.client.domain.market.CandlestickInterval;

public class MarketDataStreamTest {

    public static void main(String[] args) {

        libraexApiWebSocketClient client = libraexApiClientFactory.newInstance().newWebSocketClient();

        // depth
        client.onDepthEvent("BTCUSDT", response -> System.out.println(response));

        // kline
        client.onCandlestickEvent("BTCUSDT", CandlestickInterval.ONE_MINUTE, response -> System.out.println(response));

        // trades
        client.onTradeEvent("BTCUSDT", response -> System.out.println(response));

        // ticker for 24 hour
        client.onTicker24HourEvent("BTCUSDT", response -> System.out.println(response));

        // index
        client.onIndexEvent("BTCUSDT", System.out::println);
    }
}
