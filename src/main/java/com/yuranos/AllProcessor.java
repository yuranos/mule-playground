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
        if (muleEventContext.getMessage() instanceof List) {
            for(Object element : (List) muleEventContext.getMessage()) {
                System.out.println(element);
            }
            return muleEventContext.getMessage();
        }
        throw new RuntimeException();
    }
}
