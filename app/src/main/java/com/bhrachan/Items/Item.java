package com.bhrachan.Items;

import com.bhrachan.UTIL;

public abstract class Item
{
    protected String name;
    protected String description;
    protected String id;

    public Item(String _name, String _description)
    {
        name = _name;
        description = _description;
        id = UTIL.GetUUID();
    }

    public String GetName()
    {
        return name;
    }

    public String GetDescription()
    {
        return description;
    }

    public String GetId()
    {
        return id;
    }
}
