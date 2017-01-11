package com.google.protobuf.nano;

import java.nio.charset.Charset;

public final class InternalNano
{
  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Object LAZY_INIT_LOCK = new Object();
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static void cloneUnknownFieldData(ExtendableMessageNano paramExtendableMessageNano1, ExtendableMessageNano paramExtendableMessageNano2)
  {
    if (paramExtendableMessageNano1.unknownFieldData != null) {
      paramExtendableMessageNano2.unknownFieldData = paramExtendableMessageNano1.unknownFieldData.clone();
    }
  }
}


/* Location:              D:\MyWorks\Baofeng\gvr\google vr service\classes-dex2jar.jar!\com\google\protobuf\nano\InternalNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */