//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.protobuf.nano;

public final class FieldArray implements Cloneable {
  private static final aqn DELETED = new aqn();
  private aqn[] mData;
  private int[] mFieldNumbers;
  private boolean mGarbage;
  private int mSize;

  FieldArray() {
    this(10);
  }

  FieldArray(int var1) {
    this.mGarbage = false;
    var1 = this.idealIntArraySize(var1);
    this.mFieldNumbers = new int[var1];
    this.mData = new aqn[var1];
    this.mSize = 0;
  }

  private final boolean arrayEquals(int[] var1, int[] var2, int var3) {
    for(int var4 = 0; var4 < var3; ++var4) {
      if(var1[var4] != var2[var4]) {
        return false;
      }
    }

    return true;
  }

  private final boolean arrayEquals(aqn[] var1, aqn[] var2, int var3) {
    for(int var4 = 0; var4 < var3; ++var4) {
      if(!var1[var4].equals(var2[var4])) {
        return false;
      }
    }

    return true;
  }

  private final int binarySearch(int var1) {
    int var3 = this.mSize;
    int var2 = 0;
    --var3;

    while(true) {
      if(var2 > var3) {
        var3 = ~var2;
        break;
      }

      int var4 = var2 + var3 >>> 1;
      int var5 = this.mFieldNumbers[var4];
      if(var5 < var1) {
        var2 = var4 + 1;
      } else {
        var3 = var4;
        if(var5 <= var1) {
          break;
        }

        var3 = var4 - 1;
      }
    }

    return var3;
  }

  private final void gc() {
    int var4 = this.mSize;
    int[] var5 = this.mFieldNumbers;
    aqn[] var6 = this.mData;
    int var1 = 0;

    int var2;
    int var3;
    for(var2 = 0; var1 < var4; var2 = var3) {
      aqn var7 = var6[var1];
      var3 = var2;
      if(var7 != DELETED) {
        if(var1 != var2) {
          var5[var2] = var5[var1];
          var6[var2] = var7;
          var6[var1] = null;
        }

        var3 = var2 + 1;
      }

      ++var1;
    }

    this.mGarbage = false;
    this.mSize = var2;
  }

  private final int idealByteArraySize(int var1) {
    int var2 = 4;

    int var3;
    while(true) {
      var3 = var1;
      if(var2 >= 32) {
        break;
      }

      if(var1 <= (1 << var2) - 12) {
        var3 = (1 << var2) - 12;
        break;
      }

      ++var2;
    }

    return var3;
  }

  private final int idealIntArraySize(int var1) {
    return this.idealByteArraySize(var1 << 2) / 4;
  }

  public final FieldArray clone() {
    int var1 = 0;
    int var2 = this.size();
    FieldArray var3 = new FieldArray(var2);
    System.arraycopy(this.mFieldNumbers, 0, var3.mFieldNumbers, 0, var2);

    for(; var1 < var2; ++var1) {
      if(this.mData[var1] != null) {
        var3.mData[var1] = this.mData[var1].b();
      }
    }

    var3.mSize = var2;
    return var3;
  }

  final aqn dataAt(int var1) {
    if(this.mGarbage) {
      this.gc();
    }

    return this.mData[var1];
  }

  public final boolean equals(Object var1) {
    if(var1 != this) {
      if(!(var1 instanceof FieldArray)) {
        return false;
      }

      FieldArray var2 = (FieldArray)var1;
      if(this.size() != var2.size()) {
        return false;
      }

      if(!this.arrayEquals(this.mFieldNumbers, var2.mFieldNumbers, this.mSize) || !this.arrayEquals(this.mData, var2.mData, this.mSize)) {
        return false;
      }
    }

    return true;
  }

  final aqn get(int var1) {
    var1 = this.binarySearch(var1);
    return var1 >= 0 && this.mData[var1] != DELETED?this.mData[var1]:null;
  }

  public final int hashCode() {
    if(this.mGarbage) {
      this.gc();
    }

    int var2 = 17;

    for(int var1 = 0; var1 < this.mSize; ++var1) {
      var2 = (var2 * 31 + this.mFieldNumbers[var1]) * 31 + this.mData[var1].hashCode();
    }

    return var2;
  }

  final void put(int var1, aqn var2) {
    int var3 = this.binarySearch(var1);
    if(var3 >= 0) {
      this.mData[var3] = var2;
    } else {
      int var4 = ~var3;
      if(var4 < this.mSize && this.mData[var4] == DELETED) {
        this.mFieldNumbers[var4] = var1;
        this.mData[var4] = var2;
      } else {
        var3 = var4;
        if(this.mGarbage) {
          var3 = var4;
          if(this.mSize >= this.mFieldNumbers.length) {
            this.gc();
            var3 = ~this.binarySearch(var1);
          }
        }

        if(this.mSize >= this.mFieldNumbers.length) {
          var4 = this.idealIntArraySize(this.mSize + 1);
          int[] var5 = new int[var4];
          aqn[] var6 = new aqn[var4];
          System.arraycopy(this.mFieldNumbers, 0, var5, 0, this.mFieldNumbers.length);
          System.arraycopy(this.mData, 0, var6, 0, this.mData.length);
          this.mFieldNumbers = var5;
          this.mData = var6;
        }

        if(this.mSize - var3 != 0) {
          System.arraycopy(this.mFieldNumbers, var3, this.mFieldNumbers, var3 + 1, this.mSize - var3);
          System.arraycopy(this.mData, var3, this.mData, var3 + 1, this.mSize - var3);
        }

        this.mFieldNumbers[var3] = var1;
        this.mData[var3] = var2;
        ++this.mSize;
      }
    }
  }

  final int size() {
    if(this.mGarbage) {
      this.gc();
    }

    return this.mSize;
  }
}
