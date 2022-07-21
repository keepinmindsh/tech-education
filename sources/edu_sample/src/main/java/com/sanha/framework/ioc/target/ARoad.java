package com.sanha.framework.ioc.target;

import com.sanha.framework.ioc.Target;

public class ARoad implements Target {
    @Override
    public void target() {
        System.out.println("길");
    }
}
