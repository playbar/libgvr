/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.ContentProviderClient;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.ProviderInfo;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.os.Build.VERSION;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class VrParamsProviderFactory
/*     */ {
/*  20 */   private static final String TAG = VrParamsProviderFactory.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static VrParamsProvider providerForTesting;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static VrParamsProvider create(Context paramContext)
/*     */   {
/*  37 */     if (providerForTesting != null) {
/*  38 */       return providerForTesting;
/*     */     }
/*     */     
/*     */     ContentProviderClientHandle localContentProviderClientHandle;
/*     */     
/*  43 */     if ((localContentProviderClientHandle = tryToGetContentProviderClientHandle(paramContext)) != null) {
/*  44 */       return new ContentProviderVrParamsProvider(localContentProviderClientHandle.client, localContentProviderClientHandle.authority);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  51 */     return new LegacyVrParamsProvider();
/*     */   }
/*     */   
/*     */ 
/*     */   public static class ContentProviderClientHandle
/*     */   {
/*     */     public final ContentProviderClient client;
/*     */     
/*     */     public final String authority;
/*     */     
/*     */ 
/*     */     ContentProviderClientHandle(ContentProviderClient paramContentProviderClient, String paramString)
/*     */     {
/*  64 */       this.client = paramContentProviderClient;
/*  65 */       this.authority = paramString;
/*     */     }
/*     */   }
/*     */   
/*     */   public static ContentProviderClientHandle tryToGetContentProviderClientHandle(Context paramContext) {
/*     */     List localList;
/*  71 */     if ((localList = getValidContentProviderAuthorities(paramContext)) != null) {
/*  72 */       for (String str : localList)
/*     */       {
/*     */         ContentProviderClient localContentProviderClient;
/*     */         
/*  76 */         if ((localContentProviderClient = paramContext.getContentResolver().acquireContentProviderClient(str)) != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */           return new ContentProviderClientHandle(localContentProviderClient, str);
/*     */         }
/*     */       }
/*     */     }
/*  90 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isContentProviderAvailable(Context paramContext)
/*     */   {
/* 103 */     if ((providerForTesting != null) && ((providerForTesting instanceof ContentProviderVrParamsProvider)))
/*     */     {
/* 105 */       return true;
/*     */     }
/*     */     List localList;
/* 108 */     return ((localList = getValidContentProviderAuthorities(paramContext)) != null) && (!localList.isEmpty());
/*     */   }
/*     */   
/*     */   private static List<String> getValidContentProviderAuthorities(Context paramContext)
/*     */   {
/* 113 */     if (Build.VERSION.SDK_INT < 19)
/*     */     {
/*     */ 
/*     */ 
/* 117 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 121 */     PackageManager localPackageManager = paramContext.getPackageManager();
/* 122 */     Intent localIntent = new Intent("android.content.action.VR_SETTINGS_PROVIDER");
/*     */     
/*     */     List localList;
/* 125 */     if (((localList = localPackageManager.queryIntentContentProviders(localIntent, 0)) == null) || (localList.isEmpty())) {
/* 126 */       return null;
/*     */     }
/*     */     
/* 129 */     ArrayList localArrayList = new ArrayList();
/*     */     
/*     */ 
/* 132 */     for (Iterator localIterator = localList.iterator(); localIterator.hasNext();) { ResolveInfo localResolveInfo;
/*     */       ProviderInfo localProviderInfo;
/* 134 */       if (PackageUtils.isGooglePackage((localProviderInfo = (localResolveInfo = (ResolveInfo)localIterator.next()).providerInfo).packageName)) {
/* 135 */         localArrayList.add(localProviderInfo.authority);
/*     */       }
/*     */     }
/* 138 */     return localArrayList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setProviderForTesting(VrParamsProvider paramVrParamsProvider)
/*     */   {
/* 149 */     providerForTesting = paramVrParamsProvider;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\VrParamsProviderFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */