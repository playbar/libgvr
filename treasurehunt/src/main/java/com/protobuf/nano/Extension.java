package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;

public class Extension
{
  public final Class clazz;
  public final boolean repeated;
  public final int tag;
  public final int type;
  
  protected int computeRepeatedSerializedSize(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + computeSingularSerializedSize(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int computeSerializedSize(Object paramObject)
  {
    if (this.repeated) {
      return computeRepeatedSerializedSize(paramObject);
    }
    return computeSingularSerializedSize(paramObject);
  }
  
  protected int computeSingularSerializedSize(Object paramObject)
  {
    int i = WireFormatNano.getTagFieldNumber(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return CodedOutputByteBufferNano.computeGroupSize(i, (MessageNano)paramObject);
    }
    return CodedOutputByteBufferNano.computeMessageSize(i, (MessageNano)paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Extension)) {
        return false;
      }
      paramObject = (Extension)paramObject;
    } while ((this.type == ((Extension)paramObject).type) && (this.clazz == ((Extension)paramObject).clazz) && (this.tag == ((Extension)paramObject).tag) && (this.repeated == ((Extension)paramObject).repeated));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.type;
    int k = this.clazz.hashCode();
    int m = this.tag;
    if (this.repeated) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        writeSingularData(localObject, paramCodedOutputByteBufferNano);
      }
      i += 1;
    }
  }
  
  protected void writeSingularData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    for (;;)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
        switch (this.type)
        {
        case 10: 
          i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (MessageNano)paramObject;
      int i = WireFormatNano.getTagFieldNumber(this.tag);
      paramCodedOutputByteBufferNano.writeGroupNoTag((MessageNano)paramObject);
      paramCodedOutputByteBufferNano.writeTag(i, 4);
      return;
      paramCodedOutputByteBufferNano.writeMessageNoTag((MessageNano)paramObject);
      return;
    }
  }
  
  public void writeTo(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.repeated)
    {
      writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
      return;
    }
    writeSingularData(paramObject, paramCodedOutputByteBufferNano);
  }
}


/* Location:              D:\MyWorks\Baofeng\gvr\google vr service\classes-dex2jar.jar!\com\google\protobuf\nano\Extension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */