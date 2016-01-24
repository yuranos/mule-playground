package com.yuranos;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
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
        wireMockServer.stubFor(WireMock.post(urlMatching("/test"))
                .willReturn(aResponse().withFixedDelay(2000).withStatus(201).withBody("I'm your response from POST Wiremock")));
        wireMockServer.stubFor(get(urlMatching("/test"))
                .willReturn(aResponse().withStatus(200).withBody("I'm your response from GET Wiremock")));
        wireMockServer.start();
        System.out.println("Wiremock has just started");
    }

    @Override
    public void stop() throws MuleException {
        wireMockServer.stop();
    }
}
