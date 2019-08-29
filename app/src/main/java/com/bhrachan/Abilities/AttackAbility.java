package com.bhrachan.Abilities;

import com.bhrachan.A;

public abstract class AttackAbility extends ActiveAbility
{
    protected A.eDice damageDice;
    protected int numDamageDice;
    protected int addDamage;

    public AttackAbility(String _name, String _description, A.eDice _damageDice, int _numDamageDice, int _addDamage)
    {
        super(_name, _description);
        damageDice = _damageDice;
        numDamageDice = _numDamageDice;
        addDamage = _addDamage;
    }
}
