package com.bhrachan.Abilities;

import com.bhrachan.A;

public abstract class AttackAbility extends ActiveAbility
{
    protected A.eDice damageDice;
    protected int numDamageDice;
    protected int addDamage;

    public AttackAbility()
    {
        super();
    }

    public AttackAbility(A.eDice _damageDice, int _numDamageDice, int _addDamage)
    {
        super();
        damageDice = _damageDice;
        numDamageDice = _numDamageDice;
        addDamage = _addDamage;
    }
}
