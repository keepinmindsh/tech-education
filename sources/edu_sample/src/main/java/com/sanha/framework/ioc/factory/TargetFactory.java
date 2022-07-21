package com.sanha.framework.ioc.factory;

import com.sanha.framework.ioc.Target;
import com.sanha.framework.ioc.target.ARoad;

public class TargetFactory {

    public static Target makeTarget(){
        return new ARoad();
    }
}
