//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import com.google.vr.cardboard.ContentProviderVrParamsProvider;
import com.google.vr.cardboard.LegacyVrParamsProvider;
import com.google.vr.cardboard.PackageUtils;
import com.google.vr.cardboard.VrParamsProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class VrParamsProviderFactory {
    private static final String TAG = VrParamsProviderFactory.class.getSimpleName();
    private static final boolean DEBUG = false;
    private static VrParamsProvider providerForTesting;

    public VrParamsProviderFactory() {
    }

    public static VrParamsProvider create(Context var0) {
        VrParamsProviderFactory.ContentProviderClientHandle var1;
        return (VrParamsProvider)(providerForTesting != null?providerForTesting:((var1 = tryToGetContentProviderClientHandle(var0)) != null?new ContentProviderVrParamsProvider(var1.client, var1.authority):new LegacyVrParamsProvider()));
    }

    public static VrParamsProviderFactory.ContentProviderClientHandle tryToGetContentProviderClientHandle(Context var0) {
        List var1;
        if((var1 = getValidContentProviderAuthorities(var0)) != null) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                ContentProviderClient var4;
                if((var4 = var0.getContentResolver().acquireContentProviderClient(var3)) != null) {
                    return new VrParamsProviderFactory.ContentProviderClientHandle(var4, var3);
                }
            }
        }

        return null;
    }

    public static boolean isContentProviderAvailable(Context var0) {
        List var1;
        return providerForTesting != null && providerForTesting instanceof ContentProviderVrParamsProvider?true:(var1 = getValidContentProviderAuthorities(var0)) != null && !var1.isEmpty();
    }

    private static List<String> getValidContentProviderAuthorities(Context var0) {
        if(VERSION.SDK_INT < 19) {
            return null;
        } else {
            PackageManager var1 = var0.getPackageManager();
            Intent var2 = new Intent("android.content.action.VR_SETTINGS_PROVIDER");
            List var3;
            if((var3 = var1.queryIntentContentProviders(var2, 0)) != null && !var3.isEmpty()) {
                ArrayList var4 = new ArrayList();
                Iterator var5 = var3.iterator();

                while(var5.hasNext()) {
                    ProviderInfo var7;
                    if(PackageUtils.isGooglePackage((var7 = ((ResolveInfo)var5.next()).providerInfo).packageName)) {
                        var4.add(var7.authority);
                    }
                }

                return var4;
            } else {
                return null;
            }
        }
    }

    public static void setProviderForTesting(VrParamsProvider var0) {
        providerForTesting = var0;
    }

    public static class ContentProviderClientHandle {
        public final ContentProviderClient client;
        public final String authority;

        ContentProviderClientHandle(ContentProviderClient var1, String var2) {
            this.client = var1;
            this.authority = var2;
        }
    }
}
