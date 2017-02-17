//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.sdk.base;

import android.content.Context;
import com.google.vr.sdk.base.CardboardViewApi;
import com.google.vr.sdk.base.CardboardViewNativeImpl;

public class ImplementationSelector {
    public ImplementationSelector() {
    }

    public static CardboardViewApi createCardboardViewApi(Context context) {
        return new CardboardViewNativeImpl(context);
    }
}
