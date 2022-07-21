package com.lines.framework.ioc.factory;

import com.lines.framework.ioc.Order;
import com.lines.framework.ioc.order.AHand;

public class OrderFactory {

    public static Order makeOrder(){
        return new AHand();
    }
}
