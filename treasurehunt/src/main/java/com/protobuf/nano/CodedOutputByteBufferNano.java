//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.protobuf.nano;

import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class CodedOutputByteBufferNano {
  private final ByteBuffer buffer;

  private CodedOutputByteBufferNano(ByteBuffer var1) {
    this.buffer = var1;
    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
  }

  private CodedOutputByteBufferNano(byte[] var1, int var2, int var3) {
    this(ByteBuffer.wrap(var1, var2, var3));
  }

  public static int computeBoolSize(int var0, boolean var1) {
    return computeTagSize(var0) + computeBoolSizeNoTag(var1);
  }

  public static int computeBoolSizeNoTag(boolean var0) {
    return 1;
  }

  public static int computeDoubleSize(int var0, double var1) {
    return computeTagSize(var0) + computeDoubleSizeNoTag(var1);
  }

  public static int computeDoubleSizeNoTag(double var0) {
    return 8;
  }

  public static int computeFloatSize(int var0, float var1) {
    return computeTagSize(var0) + computeFloatSizeNoTag(var1);
  }

  public static int computeFloatSizeNoTag(float var0) {
    return 4;
  }

  public static int computeGroupSize(int var0, MessageNano var1) {
    return (computeTagSize(var0) << 1) + computeGroupSizeNoTag(var1);
  }

  public static int computeGroupSizeNoTag(MessageNano var0) {
    return var0.getSerializedSize();
  }

  public static int computeInt32Size(int var0, int var1) {
    return computeTagSize(var0) + computeInt32SizeNoTag(var1);
  }

  public static int computeInt32SizeNoTag(int var0) {
    return var0 >= 0?computeRawVarint32Size(var0):10;
  }

  public static int computeInt64Size(int var0, long var1) {
    return computeTagSize(var0) + computeInt64SizeNoTag(var1);
  }

  public static int computeInt64SizeNoTag(long var0) {
    return computeRawVarint64Size(var0);
  }

  public static int computeMessageSize(int var0, MessageNano var1) {
    return computeTagSize(var0) + computeMessageSizeNoTag(var1);
  }

  public static int computeMessageSizeNoTag(MessageNano var0) {
    int var1 = var0.getSerializedSize();
    return var1 + computeRawVarint32Size(var1);
  }

  public static int computeRawVarint32Size(int var0) {
    return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
  }

  public static int computeRawVarint64Size(long var0) {
    return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((-9223372036854775808L & var0) == 0L?9:10))))))));
  }

  public static int computeStringSize(int var0, String var1) {
    return computeTagSize(var0) + computeStringSizeNoTag(var1);
  }

  public static int computeStringSizeNoTag(String var0) {
    int var1 = encodedLength(var0);
    return var1 + computeRawVarint32Size(var1);
  }

  public static int computeTagSize(int var0) {
    return computeRawVarint32Size(WireFormatNano.makeTag(var0, 0));
  }

  private static int encode(CharSequence var0, byte[] var1, int var2, int var3) {
    int var7 = var0.length();
    byte var6 = 0;
    int var8 = var2 + var3;

    for(var3 = var6; var3 < var7 && var3 + var2 < var8; ++var3) {
      char var10 = var0.charAt(var3);
      if(var10 >= 128) {
        break;
      }

      var1[var2 + var3] = (byte)var10;
    }

    if(var3 == var7) {
      return var2 + var7;
    } else {
      var2 += var3;

      int var11;
      while(true) {
        if(var3 >= var7) {
          return var2;
        }

        char var4 = var0.charAt(var3);
        if(var4 < 128 && var2 < var8) {
          var11 = var2 + 1;
          var1[var2] = (byte)var4;
          var2 = var11;
        } else if(var4 < 2048 && var2 <= var8 - 2) {
          var11 = var2 + 1;
          var1[var2] = (byte)(var4 >>> 6 | 960);
          var2 = var11 + 1;
          var1[var11] = (byte)(var4 & 63 | 128);
        } else {
          int var9;
          if((var4 < '\ud800' || '\udfff' < var4) && var2 <= var8 - 3) {
            var11 = var2 + 1;
            var1[var2] = (byte)(var4 >>> 12 | 480);
            var9 = var11 + 1;
            var1[var11] = (byte)(var4 >>> 6 & 63 | 128);
            var2 = var9 + 1;
            var1[var9] = (byte)(var4 & 63 | 128);
          } else {
            if(var2 > var8 - 4) {
              throw new ArrayIndexOutOfBoundsException((new StringBuilder(37)).append("Failed writing ").append(var4).append(" at index ").append(var2).toString());
            }

            var11 = var3;
            if(var3 + 1 == var0.length()) {
              break;
            }

            ++var3;
            char var5 = var0.charAt(var3);
            if(!Character.isSurrogatePair(var4, var5)) {
              var11 = var3;
              break;
            }

            var11 = Character.toCodePoint(var4, var5);
            var9 = var2 + 1;
            var1[var2] = (byte)(var11 >>> 18 | 240);
            var2 = var9 + 1;
            var1[var9] = (byte)(var11 >>> 12 & 63 | 128);
            var9 = var2 + 1;
            var1[var2] = (byte)(var11 >>> 6 & 63 | 128);
            var2 = var9 + 1;
            var1[var9] = (byte)(var11 & 63 | 128);
          }
        }

        ++var3;
      }

      throw new IllegalArgumentException((new StringBuilder(39)).append("Unpaired surrogate at index ").append(var11 - 1).toString());
    }
  }

  private static void encode(CharSequence var0, ByteBuffer var1) {
    if(var1.isReadOnly()) {
      throw new ReadOnlyBufferException();
    } else if(var1.hasArray()) {
      try {
        var1.position(encode(var0, var1.array(), var1.arrayOffset() + var1.position(), var1.remaining()) - var1.arrayOffset());
      } catch (ArrayIndexOutOfBoundsException var2) {
        BufferOverflowException var3 = new BufferOverflowException();
        var3.initCause(var2);
        throw var3;
      }
    } else {
      encodeDirect(var0, var1);
    }
  }

  private static void encodeDirect(CharSequence var0, ByteBuffer var1) {
    int var6 = var0.length();
    int var4 = 0;

    int var5;
    while(true) {
      if(var4 >= var6) {
        return;
      }

      char var2 = var0.charAt(var4);
      if(var2 < 128) {
        var1.put((byte)var2);
      } else if(var2 < 2048) {
        var1.put((byte)(var2 >>> 6 | 960));
        var1.put((byte)(var2 & 63 | 128));
      } else if(var2 >= '\ud800' && '\udfff' >= var2) {
        var5 = var4;
        if(var4 + 1 == var0.length()) {
          break;
        }

        ++var4;
        char var3 = var0.charAt(var4);
        if(!Character.isSurrogatePair(var2, var3)) {
          var5 = var4;
          break;
        }

        var5 = Character.toCodePoint(var2, var3);
        var1.put((byte)(var5 >>> 18 | 240));
        var1.put((byte)(var5 >>> 12 & 63 | 128));
        var1.put((byte)(var5 >>> 6 & 63 | 128));
        var1.put((byte)(var5 & 63 | 128));
      } else {
        var1.put((byte)(var2 >>> 12 | 480));
        var1.put((byte)(var2 >>> 6 & 63 | 128));
        var1.put((byte)(var2 & 63 | 128));
      }

      ++var4;
    }

    throw new IllegalArgumentException((new StringBuilder(39)).append("Unpaired surrogate at index ").append(var5 - 1).toString());
  }

  private static int encodedLength(CharSequence var0) {
    int var4 = var0.length();

    int var1;
    for(var1 = 0; var1 < var4 && var0.charAt(var1) < 128; ++var1) {
      ;
    }

    int var2 = var1;
    var1 = var4;

    int var3;
    while(true) {
      var3 = var1;
      if(var2 >= var4) {
        break;
      }

      char var7 = var0.charAt(var2);
      if(var7 >= 2048) {
        var3 = var1 + encodedLengthGeneral(var0, var2);
        break;
      }

      ++var2;
      var1 += 127 - var7 >>> 31;
    }

    if(var3 < var4) {
      long var5 = (long)var3;
      throw new IllegalArgumentException((new StringBuilder(54)).append("UTF-8 length does not fit in int: ").append(var5 + 4294967296L).toString());
    } else {
      return var3;
    }
  }

  private static int encodedLengthGeneral(CharSequence var0, int var1) {
    int var5 = var0.length();

    int var2;
    int var3;
    for(var2 = 0; var1 < var5; var1 = var3 + 1) {
      char var6 = var0.charAt(var1);
      if(var6 < 2048) {
        var2 += 127 - var6 >>> 31;
        var3 = var1;
      } else {
        int var4 = var2 + 2;
        var3 = var1;
        var2 = var4;
        if('\ud800' <= var6) {
          var3 = var1;
          var2 = var4;
          if(var6 <= '\udfff') {
            if(Character.codePointAt(var0, var1) < 65536) {
              throw new IllegalArgumentException((new StringBuilder(39)).append("Unpaired surrogate at index ").append(var1).toString());
            }

            var3 = var1 + 1;
            var2 = var4;
          }
        }
      }
    }

    return var2;
  }

  public static CodedOutputByteBufferNano newInstance(byte[] var0) {
    return newInstance(var0, 0, var0.length);
  }

  public static CodedOutputByteBufferNano newInstance(byte[] var0, int var1, int var2) {
    return new CodedOutputByteBufferNano(var0, var1, var2);
  }

  public final void checkNoSpaceLeft() {
    if(this.spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }

  public final int spaceLeft() {
    return this.buffer.remaining();
  }

  public final void writeBool(int var1, boolean var2) {
    this.writeTag(var1, 0);
    this.writeBoolNoTag(var2);
  }

  public final void writeBoolNoTag(boolean var1) {
    byte var2;
    if(var1) {
      var2 = 1;
    } else {
      var2 = 0;
    }

    this.writeRawByte((int)var2);
  }

  public final void writeDouble(int var1, double var2) {
    this.writeTag(var1, 1);
    this.writeDoubleNoTag(var2);
  }

  public final void writeDoubleNoTag(double var1) {
    this.writeRawLittleEndian64(Double.doubleToLongBits(var1));
  }

  public final void writeFloat(int var1, float var2) {
    this.writeTag(var1, 5);
    this.writeFloatNoTag(var2);
  }

  public final void writeFloatNoTag(float var1) {
    this.writeRawLittleEndian32(Float.floatToIntBits(var1));
  }

  public final void writeGroupNoTag(MessageNano var1) {
    var1.writeTo(this);
  }

  public final void writeInt32(int var1, int var2) {
    this.writeTag(var1, 0);
    this.writeInt32NoTag(var2);
  }

  public final void writeInt32NoTag(int var1) {
    if(var1 >= 0) {
      this.writeRawVarint32(var1);
    } else {
      this.writeRawVarint64((long)var1);
    }
  }

  public final void writeInt64(int var1, long var2) {
    this.writeTag(var1, 0);
    this.writeInt64NoTag(var2);
  }

  public final void writeInt64NoTag(long var1) {
    this.writeRawVarint64(var1);
  }

  public final void writeMessage(int var1, MessageNano var2) {
    this.writeTag(var1, 2);
    this.writeMessageNoTag(var2);
  }

  public final void writeMessageNoTag(MessageNano var1) {
    this.writeRawVarint32(var1.getCachedSize());
    var1.writeTo(this);
  }

  public final void writeRawByte(byte var1) {
    if(!this.buffer.hasRemaining()) {
      throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    } else {
      this.buffer.put(var1);
    }
  }

  public final void writeRawByte(int var1) {
    this.writeRawByte((byte)var1);
  }

  public final void writeRawBytes(byte[] var1) {
    this.writeRawBytes(var1, 0, var1.length);
  }

  public final void writeRawBytes(byte[] var1, int var2, int var3) {
    if(this.buffer.remaining() >= var3) {
      this.buffer.put(var1, var2, var3);
    } else {
      throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }
  }

  public final void writeRawLittleEndian32(int var1) {
    if(this.buffer.remaining() < 4) {
      throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    } else {
      this.buffer.putInt(var1);
    }
  }

  public final void writeRawLittleEndian64(long var1) {
    if(this.buffer.remaining() < 8) {
      throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    } else {
      this.buffer.putLong(var1);
    }
  }

  public final void writeRawVarint32(int var1) {
    while((var1 & -128) != 0) {
      this.writeRawByte(var1 & 127 | 128);
      var1 >>>= 7;
    }

    this.writeRawByte(var1);
  }

  public final void writeRawVarint64(long var1) {
    while((-128L & var1) != 0L) {
      this.writeRawByte((int)var1 & 127 | 128);
      var1 >>>= 7;
    }

    this.writeRawByte((int)var1);
  }

  public final void writeString(int var1, String var2) {
    this.writeTag(var1, 2);
    this.writeStringNoTag(var2);
  }



  public final void writeStringNoTag(String var1) {
    try {
      int var2 = computeRawVarint32Size(var1.length());
      if(var2 == computeRawVarint32Size(var1.length() * 3)) {
        int var3 = this.buffer.position();
        if(this.buffer.remaining() < var2) {
          throw new OutOfSpaceException(var2 + var3, this.buffer.limit());
        } else {
          this.buffer.position(var3 + var2);
          encode(var1, this.buffer);
          int var4 = this.buffer.position();
          this.buffer.position(var3);
          this.writeRawVarint32(var4 - var3 - var2);
          this.buffer.position(var4);
        }
      } else {
        this.writeRawVarint32(encodedLength(var1));
        encode(var1, this.buffer);
      }
    } catch (BufferOverflowException var6) {
      OutOfSpaceException var5 = new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
      var5.initCause(var6);
      throw var5;
    }
  }

  public final void writeTag(int var1, int var2) {
    this.writeRawVarint32(WireFormatNano.makeTag(var1, var2));
  }

  public class OutOfSpaceException extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;
    OutOfSpaceException(int var1, int var2) {
      super((new StringBuilder(108)).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(var1).append(" limit ").append(var2).append(").").toString());
    }
  }
}
