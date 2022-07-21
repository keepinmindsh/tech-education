package com.lines.framework.ioc.factory;

import com.lines.framework.ioc.Target;
import com.lines.framework.ioc.target.ARoad;

public class TargetFactory {

    public static Target makeTarget(){
        return new ARoad();
    }
}
