package io.libraex.api.test;

import io.libraex.api.client.libraexApiClientFactory;
import io.libraex.api.client.libraexApiRestClient;
import io.libraex.api.client.libraexApiWebSocketClient;
import io.libraex.api.client.constant.libraexConstants;
import io.libraex.api.test.constant.Constants;

//@Slf4j
public class UserDataStreamTest {

    public static void main(String[] args) {
//
        libraexApiWebSocketClient client = libraexApiClientFactory.newInstance().newWebSocketClient();
        libraexApiRestClient restClient = libraexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY).newRestClient();

        System.out.println("\n ------Get Listen Key -----");
        System.out.println();
        String listenKey = restClient.startUserDataStream(libraexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println("listenKey:" + listenKey);
        // order
        client.onUserEvent(listenKey, response -> System.out.println(response), true);

    }
}
