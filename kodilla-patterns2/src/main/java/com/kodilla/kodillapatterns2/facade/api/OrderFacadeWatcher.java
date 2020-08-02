package com.kodilla.kodillapatterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Aspect
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId) && target(object)")
    public void logProcessOrder(OrderDto order, Long userId, Object object) {
        LOGGER.info("processOrder() method executed by object " + object +
                " for order with items: " + order.getItems().stream().map(i -> "ID:" + i.getProductId() + "x " + i.getQuantity()).collect(Collectors.joining(","))
                + ", by user " + userId + ".");
    }
}
