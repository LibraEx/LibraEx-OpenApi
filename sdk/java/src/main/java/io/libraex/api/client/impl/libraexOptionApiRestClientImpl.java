package io.libraex.api.client.impl;

import static io.libraex.api.client.impl.libraexApiServiceGenerator.createService;
import static io.libraex.api.client.impl.libraexApiServiceGenerator.executeSync;

import java.util.List;

import io.libraex.api.client.libraexOptionApiRestClient;
import io.libraex.api.client.constant.libraexConstants;
import io.libraex.api.client.domain.account.request.CancelOrderRequest;
import io.libraex.api.client.domain.option.OptionMatchResult;
import io.libraex.api.client.domain.option.OptionOrderResult;
import io.libraex.api.client.domain.option.PositionResult;
import io.libraex.api.client.domain.option.SettlementResult;
import io.libraex.api.client.domain.option.TokenOptionResult;
import io.libraex.api.client.domain.option.request.OptionHistoryOrderRequest;
import io.libraex.api.client.domain.option.request.OptionOpenOrderRequest;
import io.libraex.api.client.domain.option.request.OptionOrderRequest;
import io.libraex.api.client.domain.option.request.OptionPositionRequest;
import io.libraex.api.client.domain.option.request.OptionSettlementRequest;
import io.libraex.api.client.domain.option.request.OptionTradeRequest;
import io.libraex.api.client.domain.option.request.OptionsRequest;
import io.libraex.api.client.service.libraexOptionApiService;

/**
 * Implementation of libraex's Option REST API using Retrofit with synchronous/blocking method calls.
 */
public class libraexOptionApiRestClientImpl implements libraexOptionApiRestClient {

    private final libraexOptionApiService libraexOptionApiService;

    public libraexOptionApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        libraexOptionApiService = createService(baseUrl, libraexOptionApiService.class, apiKey, secret);
    }

    @Override
    public List<TokenOptionResult> getOptions(OptionsRequest request) {
        return executeSync(libraexOptionApiService.getOptions(request.getExpired()));
    }

    @Override
    public OptionOrderResult newOptionOrder(OptionOrderRequest request) {
        return executeSync(libraexOptionApiService.newOptionOrder(
                request.getSymbol(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getOrderType() == null ? "" : request.getOrderType().name(),
                request.getTimeInForce().name(),
                request.getQuantity(),
                request.getPrice(),
                request.getClientOrderId(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public OptionOrderResult cancelOptionOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(libraexOptionApiService.cancelOptionOrder(
                cancelOrderRequest.getOrderId(),
                cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(),
                cancelOrderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionOpenOrders(OptionOpenOrderRequest orderRequest) {
        return executeSync(libraexOptionApiService.getOptionOpenOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getLimit(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionHistoryOrders(OptionHistoryOrderRequest orderRequest) {
        return executeSync(libraexOptionApiService.getOptionHistoryOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit(),
                orderRequest.getOrderStatus() == null ? "" : orderRequest.getOrderStatus().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionMatchResult> getOptionMyTrades(OptionTradeRequest request) {
        return executeSync(libraexOptionApiService.getOptionMyTrades(
                request.getSymbol(),
                request.getFromId(),
                request.getToId(),
                request.getLimit(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<PositionResult> getOptionPositions(OptionPositionRequest request) {
        return executeSync(libraexOptionApiService.getOptionPositions(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<SettlementResult> getOptionSettlements(OptionSettlementRequest request) {
        return executeSync(libraexOptionApiService.getOptionSettlements(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }
}
