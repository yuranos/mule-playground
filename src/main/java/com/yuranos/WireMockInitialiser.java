package com.yuranos;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * Created by ino on 12/28/2015.
 * This is an entry point to WireMock instance. Startable and Stoppable interfaces are mostly used for infrastructural components,
 * which this mock implementation tends to be.
 */
@Component
public class WireMockInitialiser implements Startable, Stoppable {

    WireMockServer wireMockServer;

    int wiremockPort = 8085;

    @Override
    public void start() throws MuleException {
        wireMockServer = new WireMockServer(wireMockConfig().port(wiremockPort)); //No-args constructor will start on port 8080, no HTTPS
//        stubFor(post(urlMatching(".*"))
//                .willReturn(aResponse().withStatus(200).withFixedDelay(2000).withBody("I'm your response from Wiremock")));
        wireMockServer.start();
    }

    @Override
    public void stop() throws MuleException {
        wireMockServer.stop();
    }


}
