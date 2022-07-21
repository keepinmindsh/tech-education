package com.lines.framework.ioc.order;

import com.lines.framework.ioc.Order;

public class AHand implements Order {
    @Override
    public void order() {
        System.out.println("Order");
    }
}
