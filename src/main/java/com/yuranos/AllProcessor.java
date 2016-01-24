package com.yuranos;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ino on 1/22/2016.
 */
@Component
public class AllProcessor implements Callable {

    @Override
    public Object onCall(MuleEventContext muleEventContext) throws Exception {
        if (muleEventContext.getMessage().getPayload() instanceof List) {
            ((List) muleEventContext.getMessage().getPayload()).forEach(System.out::println);
            return muleEventContext.getMessage();
        }
        throw new RuntimeException();
    }
}
