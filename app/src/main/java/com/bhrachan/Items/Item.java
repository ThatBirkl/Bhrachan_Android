package com.bhrachan.Items;

public abstract class Item
{
    protected String name;
    protected String description;

    public Item(String _name, String _description)
    {
        name = _name;
        description = _description;
    }
}
