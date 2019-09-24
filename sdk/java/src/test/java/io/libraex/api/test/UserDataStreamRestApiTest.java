package io.libraex.api.test;

import io.libraex.api.client.libraexApiClientFactory;
import io.libraex.api.client.libraexApiRestClient;
import io.libraex.api.client.constant.libraexConstants;
import io.libraex.api.test.constant.Constants;

public class UserDataStreamRestApiTest {

    public static void main(String[] args) {

        libraexApiClientFactory factory = libraexApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        libraexApiRestClient client = factory.newRestClient();

        System.out.println("\n ------start user data stream-----");
        String listenKey = client.startUserDataStream(libraexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(listenKey);

        System.out.println("\n ------keepAlive user data stream-----");
        client.keepAliveUserDataStream(listenKey, libraexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

        System.out.println("\n ------close user data stream-----");
        client.closeUserDataStream(listenKey, libraexConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

    }

}
