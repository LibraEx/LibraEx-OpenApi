import time

from libraex.client import LibraexClient

if __name__ == '__main__':

    proxies = {
        "http": "",
        "https": "",
    }

    b = LibraexClient(api_key='', secret='', proxies=proxies)

    print(b.time())

    print(int(time.time() * 1000))

    print(b.broker_info())

    print(b.depth('BTCUSDT'))

    print(b.trades('BTCUSDT'))

    print(b.klines('BTCUSDT'))

    print(b.ticker_24hr('BTCUSDT'))

    result = b.order_new(symbol='BTCUSDT', side='BUY', type='LIMIT', quantity='10', price='0.1', timeInForce='GTC')

    print(result)

    order_id = result['orderId']

    print(order_id)

    print(b.order_get(order_id=order_id))

    print(b.order_cancel(order_id=order_id))

    print(b.open_orders())

    print(b.history_orders())

    print(b.account())

    print(b.my_trades())

    listen_key = b.stream_get_listen_key()

    print(listen_key)

    print(b.stream_keepalive(listen_key.get('listenKey')))

    print(b.stream_close(listen_key.get('listenKey')))

    print(b.deposit_orders())
