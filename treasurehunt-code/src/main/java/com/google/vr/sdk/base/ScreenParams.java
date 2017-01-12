/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.Display;
/*     */ import com.google.vr.cardboard.DisplayUtils;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone;
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
/*     */ public class ScreenParams
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   private float xMetersPerPixel;
/*     */   private float yMetersPerPixel;
/*     */   private float borderSizeMeters;
/*     */   
/*     */   public ScreenParams(Display display)
/*     */   {
/*  38 */     DisplayMetrics metrics = DisplayUtils.getDisplayMetricsLandscape(display);
/*     */     
/*  40 */     this.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(metrics.xdpi);
/*  41 */     this.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(metrics.ydpi);
/*  42 */     this.width = metrics.widthPixels;
/*  43 */     this.height = metrics.heightPixels;
/*  44 */     this.borderSizeMeters = DisplayUtils.getBorderSizeMeters(null);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  49 */     if (this.height > this.width) {
/*  50 */       int tempPx = this.width;
/*  51 */       this.width = this.height;
/*  52 */       this.height = tempPx;
/*     */       
/*  54 */       float tempMetersPerPixel = this.xMetersPerPixel;
/*  55 */       this.xMetersPerPixel = this.yMetersPerPixel;
/*  56 */       this.yMetersPerPixel = tempMetersPerPixel;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ScreenParams fromProto(Display display, Phone.PhoneParams params)
/*     */   {
/*  65 */     if (params == null) {
/*  66 */       return null;
/*     */     }
/*     */     
/*  69 */     ScreenParams screenParams = new ScreenParams(display);
/*     */     
/*  71 */     if (params.hasXPpi())
/*     */     {
/*  73 */       screenParams.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(params.getXPpi());
/*     */     }
/*  75 */     if (params.hasYPpi())
/*     */     {
/*  77 */       screenParams.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(params.getYPpi());
/*     */     }
/*  79 */     screenParams.borderSizeMeters = DisplayUtils.getBorderSizeMeters(params);
/*     */     
/*  81 */     return screenParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ScreenParams(ScreenParams params)
/*     */   {
/*  90 */     this.width = params.width;
/*  91 */     this.height = params.height;
/*  92 */     this.xMetersPerPixel = params.xMetersPerPixel;
/*  93 */     this.yMetersPerPixel = params.yMetersPerPixel;
/*  94 */     this.borderSizeMeters = params.borderSizeMeters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWidth(int width)
/*     */   {
/* 103 */     this.width = width;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getWidth()
/*     */   {
/* 112 */     return this.width;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHeight(int height)
/*     */   {
/* 121 */     this.height = height;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getHeight()
/*     */   {
/* 130 */     return this.height;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getWidthMeters()
/*     */   {
/* 139 */     return this.width * this.xMetersPerPixel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getHeightMeters()
/*     */   {
/* 148 */     return this.height * this.yMetersPerPixel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorderSizeMeters(float displayBorderSize)
/*     */   {
/* 160 */     this.borderSizeMeters = displayBorderSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getBorderSizeMeters()
/*     */   {
/* 169 */     return this.borderSizeMeters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 180 */     if (other == null) {
/* 181 */       return false;
/*     */     }
/*     */     
/* 184 */     if (other == this) {
/* 185 */       return true;
/*     */     }
/*     */     
/* 188 */     if (!(other instanceof ScreenParams)) {
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     ScreenParams o = (ScreenParams)other;
/*     */     
/* 194 */     return (this.width == o.width) && (this.height == o.height) && (this.xMetersPerPixel == o.xMetersPerPixel) && (this.yMetersPerPixel == o.yMetersPerPixel) && (this.borderSizeMeters == o.borderSizeMeters);
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
/*     */   public String toString()
/*     */   {
/* 209 */     int i = this.width;
/* 210 */     i = this.height;
/* 211 */     float f = this.xMetersPerPixel;
/* 212 */     f = this.yMetersPerPixel;
/* 213 */     f = this.borderSizeMeters;return "{\n" + new StringBuilder(22).append("  width: ").append(i).append(",\n").toString() + new StringBuilder(23).append("  height: ").append(i).append(",\n").toString() + new StringBuilder(39).append("  x_meters_per_pixel: ").append(f).append(",\n").toString() + new StringBuilder(39).append("  y_meters_per_pixel: ").append(f).append(",\n").toString() + new StringBuilder(39).append("  border_size_meters: ").append(f).append(",\n").toString() + 
/* 214 */       "}";
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\ScreenParams.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */