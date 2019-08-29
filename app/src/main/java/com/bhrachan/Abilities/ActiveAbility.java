package com.bhrachan.Abilities;

public abstract class ActiveAbility extends Ability
{
    public ActiveAbility(String _name, String _description)
    {
        super(_name, _description);
        active = true;
    }
}
