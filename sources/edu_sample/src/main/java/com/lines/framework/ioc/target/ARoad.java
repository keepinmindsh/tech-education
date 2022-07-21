package com.lines.framework.ioc.target;

import com.lines.framework.ioc.Target;

public class ARoad implements Target {
    @Override
    public void target() {
        System.out.println("길");
    }
}
