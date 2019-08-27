package com.bhrachan.Abilities;

import com.bhrachan.A;

public abstract class PassiveAbility extends Ability
{
    protected A.eAbilityTrigger trigger;

    public PassiveAbility()
    {
        super();
        active = false;
        trigger = A.eAbilityTrigger.onBeginTurn;
    }
}
