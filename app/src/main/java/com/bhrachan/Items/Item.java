package com.bhrachan.Items;

import com.bhrachan.A;
import com.bhrachan.UTIL;

import java.io.Serializable;

public abstract class Item implements Serializable
{
    protected String name;
    protected String description;
    protected String id;
    protected A.eItemType type;

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

    public A.eItemType GetType()
    {
        return type;
    }
}
