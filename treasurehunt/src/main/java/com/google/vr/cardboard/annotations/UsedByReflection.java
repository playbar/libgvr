package com.google.vr.cardboard.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface UsedByReflection
{
  String value();
}


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\annotations\UsedByReflection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */