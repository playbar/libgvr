/*    */ package com.google.vr.vrcore.library.api;
/*    */ 
/*    */ import android.os.IBinder;
/*    */ import com.google.vr.cardboard.annotations.UsedByReflection;
/*    */ import java.lang.reflect.Field;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @UsedByReflection("ObjectWrapper.java")
/*    */ public final class ObjectWrapper<T>
/*    */   extends IObjectWrapper.Stub
/*    */ {
/*    */   @UsedByReflection("ObjectWrapper.java")
/*    */   private final T wrappedObject;
/*    */   
/*    */   private ObjectWrapper(T paramT)
/*    */   {
/* 29 */     this.wrappedObject = paramT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> IObjectWrapper wrap(T paramT)
/*    */   {
/* 39 */     return new ObjectWrapper(paramT);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> T unwrap(IObjectWrapper paramIObjectWrapper, Class<T> paramClass)
/*    */   {
/* 51 */     if ((paramIObjectWrapper instanceof ObjectWrapper)) {
/* 52 */       return (T)((ObjectWrapper)paramIObjectWrapper).wrappedObject;
/*    */     }
/*    */     
/*    */ 
/*    */     IBinder localIBinder;
/*    */     
/*    */     Class localClass;
/*    */     
/*    */     Field[] arrayOfField;
/*    */     
/* 62 */     if ((arrayOfField = (localClass = (localIBinder = paramIObjectWrapper.asBinder()).getClass()).getDeclaredFields()).length == 1) {
/*    */       Field localField;
/* 64 */       if (!(localField = arrayOfField[0]).isAccessible()) {
/* 65 */         localField.setAccessible(true);
/*    */         try {
/* 67 */           Object localObject = localField.get(localIBinder);
/* 68 */           if (!paramClass.isInstance(localObject)) {
/* 69 */             throw new IllegalArgumentException("remoteBinder is the wrong class.");
/*    */           }
/* 71 */           return (T)paramClass.cast(localObject);
/*    */         } catch (NullPointerException localNullPointerException) {
/* 73 */           throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
/*    */         } catch (IllegalArgumentException localIllegalArgumentException) {
/* 75 */           throw new IllegalArgumentException("remoteBinder is the wrong class.", localIllegalArgumentException);
/*    */         } catch (IllegalAccessException localIllegalAccessException) {
/* 77 */           throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
/*    */         }
/*    */       }
/* 80 */       throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 87 */     throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\library\api\ObjectWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */