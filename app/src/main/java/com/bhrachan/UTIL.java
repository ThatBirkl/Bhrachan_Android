package com.bhrachan;

import java.util.Random;

public class UTIL
{
    public static boolean HasAliveCharacter()
    {
        return false;
    }

    public static A.eSkills GetRandomSkill()
    {
        Random random = new Random();

        return A.eSkills.values()[random.nextInt(A.eSkills.values().length)];
    }
}
