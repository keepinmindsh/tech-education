package com.sanha.framework.ioc.order;

import com.sanha.framework.ioc.Order;

public class AHand implements Order {
    @Override
    public void order() {
        System.out.println("Order");
    }
}
