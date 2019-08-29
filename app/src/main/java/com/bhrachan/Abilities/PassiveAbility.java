package com.bhrachan.Abilities;

import com.bhrachan.A;

public abstract class PassiveAbility extends Ability
{
    protected A.eAbilityTrigger trigger;

    public PassiveAbility(String _name, String _description)
    {
        super(_name, _description);
        active = false;
        trigger = A.eAbilityTrigger.onBeginTurn;
    }

    public A.eAbilityTrigger GetTrigger()
    {
        return trigger;
    }
}
