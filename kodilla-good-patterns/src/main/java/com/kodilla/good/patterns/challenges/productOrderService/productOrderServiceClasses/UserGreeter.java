package com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses;

import com.kodilla.good.patterns.challenges.productOrderService.interfaces.GreetingService;

public class UserGreeter implements GreetingService {
    private User user;

    public UserGreeter(User user) {
        this.user = user;
    }

    @Override
    public void greet() {
        System.out.println(String.format("Welcome back to ElagroBay, %s", user.getName()));
        System.out.println(String.format("You have last visited us on %s.", user.getLastLoginDate()));
        System.out.println("");
    }
}
