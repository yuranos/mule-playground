package com.yuranos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mule.api.MuleException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:routers.xml"})
public class RoutersTest {

    public static final String ALL_ENDPOINT = "vm://mule-3.4-endpoint";
    public static final String SCATTER_GATHER_ENDPOINT = "vm://mule-3.7-endpoint";

    @Before
    public void setup() throws IOException, MuleException {
        TestConfiguration.startEnv();
    }

    @After
    public void tearDown() throws Exception {
        TestConfiguration.stopEnv();
    }

    @Test
    public void testAllRouter() {
        long start = System.nanoTime();
        try {
            TestConfiguration.sendMuleMessage(ALL_ENDPOINT, "message", null);
        } catch (MuleException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println(end - start);
    }

    @Test
    public void testScatterGatherRouter() {
        long start = System.nanoTime();
        try {
            TestConfiguration.sendMuleMessage(SCATTER_GATHER_ENDPOINT, "message", null);
        } catch (MuleException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println(end - start);
    }


//
//    @Test
//    public void testNIO() {
//        long start = System.nanoTime();
//        long end = System.nanoTime();
//
//        System.out.println(start - end);
//
//    }

}
