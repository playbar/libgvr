/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Version
/*     */ {
/*  10 */   public static final String TAG = BuildConstants.class.getSimpleName();
/*     */   
/*     */ 
/*  13 */   public static final Version CURRENT = parse("1.10.0");
/*     */   
/*     */   public final int majorVersion;
/*     */   
/*     */   public final int minorVersion;
/*     */   
/*     */   public final int patchVersion;
/*     */   
/*     */ 
/*     */   public Version(int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  24 */     this.majorVersion = paramInt1;
/*  25 */     this.minorVersion = paramInt2;
/*  26 */     this.patchVersion = paramInt3;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static Version parse(String arg0)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnull +10 -> 11
/*     */     //   4: aload_0
/*     */     //   5: invokevirtual 31	java/lang/String:isEmpty	()Z
/*     */     //   8: ifeq +5 -> 13
/*     */     //   11: aconst_null
/*     */     //   12: areturn
/*     */     //   13: ldc 2
/*     */     //   15: invokestatic 37	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   18: aload_0
/*     */     //   19: invokevirtual 38	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   22: dup
/*     */     //   23: astore_1
/*     */     //   24: invokevirtual 36	java/util/regex/Matcher:matches	()Z
/*     */     //   27: ifne +40 -> 67
/*     */     //   30: getstatic 17	com/google/vr/ndk/base/Version:TAG	Ljava/lang/String;
/*     */     //   33: ldc 4
/*     */     //   35: aload_0
/*     */     //   36: invokestatic 33	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   39: dup
/*     */     //   40: invokevirtual 32	java/lang/String:length	()I
/*     */     //   43: ifeq +9 -> 52
/*     */     //   46: invokevirtual 29	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   49: goto +12 -> 61
/*     */     //   52: pop
/*     */     //   53: new 12	java/lang/String
/*     */     //   56: dup_x1
/*     */     //   57: swap
/*     */     //   58: invokespecial 28	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   61: invokestatic 21	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   64: pop
/*     */     //   65: aconst_null
/*     */     //   66: areturn
/*     */     //   67: new 7	com/google/vr/ndk/base/Version
/*     */     //   70: dup
/*     */     //   71: aload_1
/*     */     //   72: iconst_1
/*     */     //   73: invokevirtual 35	java/util/regex/Matcher:group	(I)Ljava/lang/String;
/*     */     //   76: invokestatic 25	java/lang/Integer:parseInt	(Ljava/lang/String;)I
/*     */     //   79: aload_1
/*     */     //   80: iconst_2
/*     */     //   81: invokevirtual 35	java/util/regex/Matcher:group	(I)Ljava/lang/String;
/*     */     //   84: invokestatic 25	java/lang/Integer:parseInt	(Ljava/lang/String;)I
/*     */     //   87: aload_1
/*     */     //   88: iconst_3
/*     */     //   89: invokevirtual 35	java/util/regex/Matcher:group	(I)Ljava/lang/String;
/*     */     //   92: invokestatic 25	java/lang/Integer:parseInt	(Ljava/lang/String;)I
/*     */     //   95: invokespecial 22	com/google/vr/ndk/base/Version:<init>	(III)V
/*     */     //   98: areturn
/*     */     // Line number table:
/*     */     //   Java source line #37	-> byte code offset #0
/*     */     //   Java source line #38	-> byte code offset #11
/*     */     //   Java source line #41	-> byte code offset #13
/*     */     //   Java source line #42	-> byte code offset #23
/*     */     //   Java source line #43	-> byte code offset #30
/*     */     //   Java source line #44	-> byte code offset #65
/*     */     //   Java source line #47	-> byte code offset #67
/*     */     //   Java source line #48	-> byte code offset #73
/*     */     //   Java source line #47	-> byte code offset #98
                return CURRENT;
/*     */   }
/*     */   
/*     */   public final boolean isAtLeast(Version paramVersion)
/*     */   {
/*  56 */     if (this.majorVersion > paramVersion.majorVersion) {
/*  57 */       return true;
/*     */     }
/*  59 */     if (this.majorVersion < paramVersion.majorVersion) {
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (this.minorVersion > paramVersion.minorVersion) {
/*  65 */       return true;
/*     */     }
/*  67 */     if (this.minorVersion < paramVersion.minorVersion) {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (this.patchVersion > paramVersion.patchVersion) {
/*  73 */       return true;
/*     */     }
/*  75 */     if (this.patchVersion < paramVersion.patchVersion) {
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject)
/*     */   {
/*  85 */     if (!(paramObject instanceof Version)) {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     Version localVersion = (Version)paramObject;
/*  90 */     return (this.majorVersion == localVersion.majorVersion) && (this.minorVersion == localVersion.minorVersion) && (this.patchVersion == localVersion.patchVersion);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/*  97 */     return Objects.hash(new Object[] { Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion) });
/*     */   }
/*     */   
/*     */   public final String toString()
/*     */   {
/* 102 */     return String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion) });
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\Version.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */