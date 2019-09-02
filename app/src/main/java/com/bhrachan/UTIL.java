package com.bhrachan;

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
}
