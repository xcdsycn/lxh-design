package com.lxh.spi;

import com.lxh.spi.intf.View;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author lxh
 */
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<View> s = ServiceLoader.load(View.class);
        Iterator<View> iterator = s.iterator();
        while (iterator.hasNext()) {
            View view = iterator.next();
            view.view();
        }
	}
}
