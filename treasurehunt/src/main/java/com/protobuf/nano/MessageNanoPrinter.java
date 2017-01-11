package com.google.protobuf.nano;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MessageNanoPrinter
{
  private static void appendQuotedBytes(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j == 92) || (j == 34)) {
        paramStringBuffer.append('\\').append((char)j);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
    }
    paramStringBuffer.append('"');
  }
  
  private static String deCamelCaseify(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private static String escapeString(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String print(MessageNano paramMessageNano)
  {
    if (paramMessageNano == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      print(null, paramMessageNano, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramMessageNano)
    {
      paramMessageNano = String.valueOf(paramMessageNano.getMessage());
      if (paramMessageNano.length() != 0) {
        return "Error printing proto: ".concat(paramMessageNano);
      }
      return new String("Error printing proto: ");
    }
    catch (InvocationTargetException paramMessageNano)
    {
      paramMessageNano = String.valueOf(paramMessageNano.getMessage());
      if (paramMessageNano.length() != 0) {
        return "Error printing proto: ".concat(paramMessageNano);
      }
    }
    return new String("Error printing proto: ");
  }
  
  private static void print(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof MessageNano)) {
        break label487;
      }
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(deCamelCaseify(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      Class localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      int i = 0;
      Object localObject3;
      if (i < n)
      {
        Object localObject4 = localObject1[i];
        j = ((Field)localObject4).getModifiers();
        localObject2 = ((Field)localObject4).getName();
        if ((!"cachedSize".equals(localObject2)) && ((j & 0x1) == 1) && ((j & 0x8) != 8) && (!((String)localObject2).startsWith("_")) && (!((String)localObject2).endsWith("_")))
        {
          localObject3 = ((Field)localObject4).getType();
          localObject4 = ((Field)localObject4).get(paramObject);
          if (!((Class)localObject3).isArray()) {
            break label246;
          }
          if (((Class)localObject3).getComponentType() != Byte.TYPE) {
            break label195;
          }
          print((String)localObject2, localObject4, paramStringBuffer1, paramStringBuffer2);
        }
        for (;;)
        {
          i += 1;
          break;
          label195:
          if (localObject4 == null) {}
          for (j = 0;; j = Array.getLength(localObject4))
          {
            int k = 0;
            while (k < j)
            {
              print((String)localObject2, Array.get(localObject4, k), paramStringBuffer1, paramStringBuffer2);
              k += 1;
            }
            break;
          }
          label246:
          print((String)localObject2, localObject4, paramStringBuffer1, paramStringBuffer2);
        }
      }
      Object localObject2 = localClass.getMethods();
      int j = localObject2.length;
      i = 0;
      if (i < j)
      {
        localObject1 = localObject2[i].getName();
        if (((String)localObject1).startsWith("set")) {
          localObject3 = ((String)localObject1).substring(3);
        }
        for (;;)
        {
          try
          {
            localObject1 = String.valueOf(localObject3);
            if (((String)localObject1).length() != 0)
            {
              localObject1 = "has".concat((String)localObject1);
              localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
              if (!((Boolean)((Method)localObject1).invoke(paramObject, new Object[0])).booleanValue()) {}
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            continue;
            String str = new String("get");
            continue;
          }
          try
          {
            localObject1 = String.valueOf(localObject3);
            if (((String)localObject1).length() == 0) {
              continue;
            }
            localObject1 = "get".concat((String)localObject1);
            localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
            print((String)localObject3, ((Method)localObject1).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            continue;
          }
          i += 1;
          break;
          localObject1 = new String("has");
        }
      }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(m);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    return;
    label487:
    paramString = deCamelCaseify(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramString = sanitizeString((String)paramObject);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[])) {
        appendQuotedBytes((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static String sanitizeString(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200) {
        str = String.valueOf(paramString.substring(0, 200)).concat("[...]");
      }
    }
    return escapeString(str);
  }
}


/* Location:              D:\MyWorks\Baofeng\gvr\google vr service\classes-dex2jar.jar!\com\google\protobuf\nano\MessageNanoPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */