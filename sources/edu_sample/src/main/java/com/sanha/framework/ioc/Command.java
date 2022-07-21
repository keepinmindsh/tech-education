package com.sanha.framework.ioc;

public class Command {

    private final Order order;
    private final Target target;

    public Command(Order order, Target target) {
        this.order = order;
        this.target = target;
    }

    void doSomething(){
        // Order
        order.order();

        // Target
        target.target();
    }
}
