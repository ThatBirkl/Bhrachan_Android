package com.bhrachan.Abilities;

import com.bhrachan.A;

public class aSlash extends AttackAbility
{
    public aSlash(A.eDice _dice, int _numDice, int _addDamage)
    {
        super("Slash", "A bbasic slashing ability doing some damage.", _dice, _numDice, _addDamage);
    }
}
