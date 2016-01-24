# mule-playground
Demonstration of some cool new features of Mule ESB that will make your application faster and more robust.

Will also show how to bind [Mule ESB 3.7 (Community Edition)](https://developer.mulesoft.com/download-mule-esb-runtime) and [Wiremock](http://wiremock.org/index.html)

Unlike All router, Scatter-Gather router sends messages in parallel, concurrently.

In 2 Tests(testAllRouter and testScatterGatherRouter), the benefits of using concurrent approach are clearly displayed.

Inside Wiremock server I've stubbed all POST responses making them delay for 2000 milliseconds to exacerbate potential problems with all router.
In my experience of integrating enterprise applications, I'm stumbled upon some legacy systems multiple times, and as a result the performance of your application will also falter.

Test results:

**testAllRouter**
```
Wiremock has just started
I'm your response from POST Wiremock
I'm your response from POST Wiremock
I'm your response from POST Wiremock
6532564117
```

**testScatterGather**
```
Wiremock has just started
I'm your response from POST Wiremock
I'm your response from POST Wiremock
I'm your response from POST Wiremock
2074106161
```
Predictably, scatter-gather approach is more than 3 times faster.