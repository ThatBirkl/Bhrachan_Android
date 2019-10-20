package com.bhrachan;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.io.File;
import java.util.UUID;

public class UTIL
{
    //private static String db_path = "";

    public static boolean HasAliveCharacter()
    {
        String d = DB.Cell("select 1 from CHARACTER where NAME is not null");

        return !d.equals("");
    }

    public static A.eSkills GetRandomSkill()
    {
        Random random = new Random();

        return A.eSkills.values()[random.nextInt(A.eSkills.values().length)];
    }

    /*
    * @param _path Path and filename
    * */
    public static boolean FileExists(String _path)
    {
        File f = new File(_path);

        return f.exists();
    }

    public static  String GetUUID()
    {
        return UUID.randomUUID().toString();
    }

    public static byte[] Serialize(Object obj) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public static Object Deserialize(byte[] data) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    public static void WipeDatabase()
    {
        DB.Delete("CHARACTER", "1=1");
        DB.Delete("SKILL", "1=1");
        DB.Delete("ITEM", "1=1");
        DB.Delete("CHARACTER_DEAD", "1=1");
    }

    public static int ParseInt(String _value)
    {
        int i = 0;
        try
        {
            i = Integer.parseInt(_value);
        }
        catch(NumberFormatException ex)
        {
            i = -1;
            ex.printStackTrace();
            Log.e("NumberFormatException", ex.getStackTrace().toString());
        }
        return i;
    }

    public static float ParseFloat(String _value)
    {
        float i = 0;
        try
        {
            i = Float.parseFloat(_value);
        }
        catch(NumberFormatException ex)
        {
            i = -1;
            ex.printStackTrace();
            Log.e("NumberFormatException", ex.getStackTrace().toString());
        }
        return i;
    }

    public static String BytesToHexString(byte[] _bytes)
    {
        String ret = new String();

        for(int i = 0 ; i < _bytes.length; i++)
        {
            ret += ByteToHex(_bytes[i]);
        }

        return ret;
    }

    private static String ByteToHex(byte _byte)
    {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((_byte >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((_byte & 0xF), 16);

        return new String(hexDigits);
    }

    public static byte[] HexStringToBytes(String _hex)
    {
        char[] hexChars = _hex.toCharArray();
        byte[] bytes = new byte[hexChars.length / 2];

        for(int i = 0 ; i < hexChars.length; i = i + 2)
        {
            bytes[i / 2] = CharsToByte(hexChars[i], hexChars[i + 1]);
        }

        return bytes;
    }

    private static byte CharsToByte(char _char1, char _char2)
    {
        int firstDigit = toDigit(_char1);
        int secondDigit = toDigit(_char2);
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private static int toDigit(char hexChar)
    {
        int digit = Character.digit(hexChar, 16);
        if (digit == -1) {
            throw new IllegalArgumentException("Invalid Hexadecimal Character: " + hexChar);
        }
        return digit;
    }
}
