package com.android.kz.mvvmpattern.otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:04 PM
 */
public class MVVMBus extends Bus {

    private MVVMBus(ThreadEnforcer enforcer) { super(enforcer);}

    private static class MVPBusHolder {
        private static final MVVMBus MVP_BUS_HOLDER = new MVVMBus(ThreadEnforcer.MAIN);
    }

    public static MVVMBus getInstance() {
        return MVPBusHolder.MVP_BUS_HOLDER;
    }

}
