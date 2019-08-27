package com.bhrachan.Abilities;

import com.bhrachan.A;

public abstract class AttackAbility extends ActiveAbility
{
    protected A.eDice damageDice;
    protected int numDamageDice;

    public AttackAbility()
    {
        super();
    }
}
