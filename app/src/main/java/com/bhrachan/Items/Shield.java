package com.bhrachan.Items;

import com.bhrachan.A;

public class Shield extends Weapon
{
    private int AC;

    public Shield(String _name, String _description, int _AC)
    {
        super(_name, _description, A.eDice.d1, 0);

        twoHanded = false;
    }

    public Shield()
    {
        this("Shield", "A simple shield", 1);
    }

    public int GetAC()
    {
        return AC;
    }
}
