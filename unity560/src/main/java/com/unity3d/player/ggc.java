//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.unity3d.player;

import android.os.Build.VERSION;
import com.unity3d.player.f;

public final class ggc {
    public static final boolean a;
    public static final boolean b;
    static final Ccls c;

    static {
        a = VERSION.SDK_INT >= 21;
        c = (b = VERSION.SDK_INT >= 23)?new f():null;
    }
}
