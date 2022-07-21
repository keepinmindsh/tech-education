package com.sanha.framework.ioc;

import com.sanha.framework.ioc.factory.OrderFactory;
import com.sanha.framework.ioc.factory.TargetFactory;

public class Brain {
    public static void main(String[] args) {
        Command command = new Command(
                OrderFactory.makeOrder(),
                TargetFactory.makeTarget()
        );

        command.doSomething();
    }
}
