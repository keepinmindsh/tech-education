package com.lines.framework.ioc;

import com.lines.framework.ioc.factory.OrderFactory;
import com.lines.framework.ioc.factory.TargetFactory;

public class Brain {
    public static void main(String[] args) {
        Command command = new Command(
                OrderFactory.makeOrder(),
                TargetFactory.makeTarget()
        );

        command.doSomething();
    }
}
