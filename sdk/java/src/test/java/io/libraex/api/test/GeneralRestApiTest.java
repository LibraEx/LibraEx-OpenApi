package io.libraex.api.test;

import io.libraex.api.client.libraexApiClientFactory;
import io.libraex.api.client.libraexApiRestClient;
import io.libraex.api.client.domain.general.BrokerInfo;
import io.libraex.api.test.constant.Constants;

public class GeneralRestApiTest {

    public static void main(String[] args) {

        libraexApiClientFactory factory = libraexApiClientFactory.newInstance();
        libraexApiRestClient client = factory.newRestClient();

        System.out.println("\n ------BrokerInfo-----");
        BrokerInfo brokerInfo = client.getBrokerInfo();
        System.out.println(brokerInfo);

    }


}
