package com.fkinh.uiautomator.test;

import android.os.RemoteException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * Author: fkinh
 * Date: 2015-09-24
 */
public class Sanity extends UiAutomatorTestCase {

    public void test000() throws RemoteException {
        System.out.println(getName());
    }
}
