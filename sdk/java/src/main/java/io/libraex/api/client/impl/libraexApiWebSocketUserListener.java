package io.libraex.api.client.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import io.libraex.api.client.libraexApiCallback;
import io.libraex.api.client.constant.libraexConstants;
import io.libraex.api.client.domain.account.SocketAccount;
import io.libraex.api.client.domain.account.SocketOrder;
import io.libraex.api.client.domain.account.SocketUserResponse;
import io.libraex.api.client.domain.channel.EventType;
import io.libraex.api.client.exception.libraexApiException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * libraex API WebSocket listener.
 */
public class libraexApiWebSocketUserListener<T> extends WebSocketListener {

    private libraexApiCallback<T> callback;

    private boolean closing = false;

    private boolean failure = false;

    private Map<String, Long> pingMap = Maps.newHashMap();

    public libraexApiWebSocketUserListener(libraexApiCallback<T> callback) {
        this.callback = callback;
    }

    public boolean getFailure() {
        return failure;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        this.failure = false;
        ObjectMapper mapper = new ObjectMapper();
        try {

            JsonNode jsonNode = mapper.readTree(text);

            Long pingTime = 0L;
            List<SocketOrder> orderList = Lists.newArrayList();
            List<SocketAccount> accountList = Lists.newArrayList();
            if (jsonNode.isArray()) {
                for (int i = 0; i < jsonNode.size(); i++) {

                    JsonNode node = jsonNode.get(i);
                    if (node == null) {
                        continue;
                    }

                    String eventType = node.get("e").asText();
                    if (eventType.equals(EventType.ACCOUNT_INFO.getType())) {
                        SocketAccount account = mapper.readValue(node.toString(), SocketAccount.class);
                        accountList.add(account);
                    } else if (eventType.equals(EventType.EXECUTION_REPORT.getType())) {
                        SocketOrder order = mapper.readValue(node.toString(), SocketOrder.class);
                        orderList.add(order);
                    }
                }
            } else {
                JsonNode pingNode = jsonNode.get(libraexConstants.PING_MSG_KEY);
                if (pingNode != null) {
                    pingTime = pingNode.asLong();
                    pingMap.put(libraexConstants.PONG_MSG_KEY, System.currentTimeMillis());
                    String message = mapper.writeValueAsString(pingMap);
                    webSocket.send(message);
                }

            }

            SocketUserResponse event = SocketUserResponse.builder()
                    .pingTime(pingTime)
                    .orderList(orderList)
                    .accountList(accountList)
                    .build();

            callback.onResponse((T) event);
        } catch (IOException e) {
            e.printStackTrace();
            throw new libraexApiException(e);
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        this.failure = true;
        if (!closing) {
            callback.onFailure(t);
        }
    }

}
