package com.sanha.framework.ioc.factory;

import com.sanha.framework.ioc.Order;
import com.sanha.framework.ioc.order.AHand;

public class OrderFactory {

    public static Order makeOrder(){
        return new AHand();
    }
}
