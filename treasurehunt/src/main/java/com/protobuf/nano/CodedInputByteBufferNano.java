package com.google.protobuf.nano;

public final class CodedInputByteBufferNano
{
  private final byte[] buffer;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int bufferStart;
  private int currentLimit = Integer.MAX_VALUE;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private int sizeLimit = 67108864;
  
  private CodedInputByteBufferNano(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.bufferStart = paramInt1;
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
  }
  
  public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedInputByteBufferNano(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private final void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.bufferSize;
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  public final void checkLastTagWas(int paramInt)
  {
    if (this.lastTag != paramInt) {
      throw InvalidProtocolBufferNanoException.invalidEndTag();
    }
  }
  
  public final int getBytesUntilLimit()
  {
    if (this.currentLimit == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.bufferPos;
    return this.currentLimit - i;
  }
  
  public final byte[] getData(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return WireFormatNano.EMPTY_BYTES;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.bufferStart;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final int getPosition()
  {
    return this.bufferPos - this.bufferStart;
  }
  
  public final boolean isAtEnd()
  {
    return this.bufferPos == this.bufferSize;
  }
  
  public final void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public final int pushLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    paramInt = this.bufferPos + paramInt;
    int i = this.currentLimit;
    if (paramInt > i) {
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }
  
  public final boolean readBool()
  {
    return readRawVarint32() != 0;
  }
  
  public final double readDouble()
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public final int readInt32()
  {
    return readRawVarint32();
  }
  
  public final long readInt64()
  {
    return readRawVarint64();
  }
  
  public final void readMessage(MessageNano paramMessageNano)
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramMessageNano.mergeFrom(this);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
  }
  
  public final byte readRawByte()
  {
    if (this.bufferPos == this.bufferSize) {
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public final int readRawLittleEndian32()
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }
  
  public final long readRawLittleEndian64()
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final int readRawVarint32()
  {
    int i = readRawByte();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0) {
        return i | k << 21;
      }
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (readRawByte() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw InvalidProtocolBufferNanoException.malformedVarint();
  }
  
  public final long readRawVarint64()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferNanoException.malformedVarint();
  }
  
  public final String readString()
  {
    int i = readRawVarint32();
    if (i < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    if (i > this.bufferSize - this.bufferPos) {
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    String str = new String(this.buffer, this.bufferPos, i, InternalNano.UTF_8);
    this.bufferPos = (i + this.bufferPos);
    return str;
  }
  
  public final int readTag()
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    if (this.lastTag == 0) {
      throw InvalidProtocolBufferNanoException.invalidTag();
    }
    return this.lastTag;
  }
  
  public final void rewindToPosition(int paramInt)
  {
    if (paramInt > this.bufferPos - this.bufferStart)
    {
      int i = this.bufferPos;
      int j = this.bufferStart;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    this.bufferPos = (this.bufferStart + paramInt);
  }
  
  public final boolean skipField(int paramInt)
  {
    switch (WireFormatNano.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferNanoException.invalidWireType();
    case 0: 
      readInt32();
      return true;
    case 1: 
      readRawLittleEndian64();
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    readRawLittleEndian32();
    return true;
  }
  
  public final void skipMessage()
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public final void skipRawBytes(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    if (this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.bufferPos);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      this.bufferPos += paramInt;
      return;
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
  }
}


/* Location:              D:\MyWorks\Baofeng\gvr\google vr service\classes-dex2jar.jar!\com\google\protobuf\nano\CodedInputByteBufferNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */