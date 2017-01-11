//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.protobuf.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.FieldArray;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public abstract class ExtendableMessageNano extends MessageNano {
  public FieldArray unknownFieldData;

  public ExtendableMessageNano() {
  }

  public ExtendableMessageNano clone() {
    ExtendableMessageNano var1 = (ExtendableMessageNano)super.clone();
    InternalNano.cloneUnknownFieldData(this, var1);
    return var1;
  }

  public int computeSerializedSize() {
    int var2 = 0;
    int var3;
    if(this.unknownFieldData != null) {
      int var1 = 0;

      while(true) {
        var3 = var1;
        if(var2 >= this.unknownFieldData.size()) {
          break;
        }

        var1 += this.unknownFieldData.dataAt(var2).a();
        ++var2;
      }
    } else {
      var3 = 0;
    }

    return var3;
  }

  public final boolean storeUnknownField(CodedInputByteBufferNano var1, int var2) {
    int var3 = var1.getPosition();
    if(!var1.skipField(var2)) {
      return false;
    } else {
      int var4 = WireFormatNano.getTagFieldNumber(var2);
      aqo var6 = new aqo(var2, var1.getData(var3, var1.getPosition() - var3));
      aqn var7 = null;
      if(this.unknownFieldData == null) {
        this.unknownFieldData = new FieldArray();
      } else {
        var7 = this.unknownFieldData.get(var4);
      }

      aqn var5 = var7;
      if(var7 == null) {
        var5 = new aqn();
        this.unknownFieldData.put(var4, var5);
      }

      var5.a.add(var6);
      return true;
    }
  }

  public void writeTo(CodedOutputByteBufferNano var1) {
    if(this.unknownFieldData != null) {
      for(int var2 = 0; var2 < this.unknownFieldData.size(); ++var2) {
        this.unknownFieldData.dataAt(var2).a(var1);
      }
    }

  }
}
