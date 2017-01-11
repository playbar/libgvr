/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.widget.FrameLayout;
/*     */ import com.google.vr.cardboard.ContextUtils;
/*     */ import com.google.vr.cardboard.UiLayer;
/*     */ import com.google.vr.cardboard.UiUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GvrUiLayout
/*     */   extends FrameLayout
/*     */ {
/*     */   private static final float DAYDREAM_ALIGNMENT_MARKER_SCALE = 0.35F;
/*     */   private final UiLayer uiLayer;
/*     */   private final Runnable defaultCloseButtonRunnable;
/*  39 */   private boolean daydreamModeEnabled = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   GvrUiLayout(Context paramContext)
/*     */   {
/*  47 */     this(paramContext, new DaydreamUtilsWrapper());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   GvrUiLayout(Context paramContext, DaydreamUtilsWrapper paramDaydreamUtilsWrapper)
/*     */   {
/*  56 */     super(paramContext);
/*     */     
/*  58 */     if (!ContextUtils.canGetActivity(paramContext)) {
/*  59 */       throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  65 */     this.defaultCloseButtonRunnable = createDefaultCloseButtonRunnable(paramContext, paramDaydreamUtilsWrapper);
/*     */     
/*  67 */     this.uiLayer = new UiLayer(paramContext);
/*  68 */     this.uiLayer.setBackButtonListener(this.defaultCloseButtonRunnable);
/*  69 */     addView(this.uiLayer.getView());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void launchOrInstallGvrApp(Activity paramActivity)
/*     */   {
/*  77 */     UiUtils.launchOrInstallCardboard(paramActivity);
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
/*     */ 
/*     */   public void setEnabled(boolean paramBoolean)
/*     */   {
/*  91 */     this.uiLayer.setEnabled(paramBoolean);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCloseButtonListener(Runnable paramRunnable)
/*     */   {
/* 108 */     this.uiLayer.setBackButtonListener(paramRunnable != null ? paramRunnable : this.defaultCloseButtonRunnable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransitionViewEnabled(boolean paramBoolean)
/*     */   {
/* 120 */     this.uiLayer.setTransitionViewEnabled((paramBoolean) && (!this.daydreamModeEnabled));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setViewerName(String paramString)
/*     */   {
/* 131 */     this.uiLayer.setViewerName(paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UiLayer getUiLayer()
/*     */   {
/* 139 */     return this.uiLayer;
/*     */   }
/*     */   
/*     */   void invokeCloseButtonListener()
/*     */   {
/*     */     Runnable localRunnable;
/* 145 */     if ((localRunnable = this.uiLayer.getBackButtonRunnable()) != null) {
/* 146 */       localRunnable.run();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setDaydreamModeEnabled(boolean paramBoolean)
/*     */   {
/* 159 */     if (this.daydreamModeEnabled == paramBoolean) {
/* 160 */       return;
/*     */     }
/*     */     
/* 163 */     this.daydreamModeEnabled = paramBoolean;
/*     */     
/* 165 */     if (paramBoolean)
/*     */     {
/* 167 */       this.uiLayer.setAlignmentMarkerScale(0.35F);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 172 */       this.uiLayer.setTransitionViewEnabled(false);return;
/*     */     }
/* 174 */     this.uiLayer.setAlignmentMarkerScale(1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isDaydreamModeEnabled()
/*     */   {
/* 180 */     return this.daydreamModeEnabled;
/*     */   }
/*     */   
/*     */ 
/*     */   private static Runnable createDefaultCloseButtonRunnable(Context paramContext, DaydreamUtilsWrapper paramDaydreamUtilsWrapper)
/*     */   {
/* 186 */     Activity localActivity = ContextUtils.getActivity(paramContext);
/*     */     
/*     */ 
/*     */ 
/* 190 */     if (paramDaydreamUtilsWrapper.isDaydreamActivity(localActivity)) {
/* 191 */       new Runnable()
/*     */       {
/*     */         public final void run() {
/*     */           Intent localIntent;
/* 195 */           (localIntent = new Intent("android.intent.action.MAIN")).addCategory("android.intent.category.HOME");
/* 196 */           localIntent.setFlags(268435456);
/* 197 */           GvrUiLayout.this.startActivity(localIntent);
/* 198 */           GvrUiLayout.this.finish();
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */ 
/* 204 */     new Runnable()
/*     */     {
/*     */       public final void run() {
/* 207 */         GvrUiLayout.this.onBackPressed();
/*     */       }
/*     */     };
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\GvrUiLayout.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */