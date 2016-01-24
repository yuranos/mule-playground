package com.yuranos;

import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ino on 1/22/2016.
 */
public class TestConfiguration {

    private static MuleTestServer muleTestServer;

    private static MuleClient muleClient;

    public static void startEnv() throws IOException, MuleException {
        muleTestServer = new MuleTestServer("routers.xml");
        muleClient = new MuleClient(muleTestServer.getMuleContext());
    }

    public static void stopEnv() throws Exception {
        muleTestServer.stop();
    }

    public static MuleMessage sendMuleMessage(String endpoint, Object payload, Map messageProperties) throws MuleException {
        if (muleClient == null) {
            throw new IllegalStateException("Mule client is not initialized. " +
                    "Please include TestConfiguration in your test suite.");
        }

        return muleClient.send(endpoint, payload, messageProperties);
    }

}
