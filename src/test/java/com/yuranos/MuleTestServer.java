package com.yuranos;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.api.context.MuleContextFactory;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * This class represents the Mule server. It starts and stops Mule server
 */
public class MuleTestServer {

    private MuleContext muleContext;

    public MuleTestServer(ApplicationContext applicationContext) throws MuleException {
        MuleContextFactory contextFactory = applicationContext.getBean(MuleContextFactory.class);
        ConfigurationBuilder configurationBuilder = applicationContext.getBean(ConfigurationBuilder.class);
        muleContext = contextFactory.createMuleContext(configurationBuilder);
        muleContext.start();
    }

    public MuleTestServer(String configResource) throws MuleException {
        MuleContextFactory contextFactory = new DefaultMuleContextFactory();
        SpringXmlConfigurationBuilder configurationBuilder = new SpringXmlConfigurationBuilder(configResource);
        muleContext = contextFactory.createMuleContext(configurationBuilder);
        muleContext.start();
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

    public void stop() throws MuleException {
        muleContext.stop();
    }

}
