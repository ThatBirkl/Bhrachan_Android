package com.bhrachan.Tokens;

import com.bhrachan.A;
import com.bhrachan.Combatant;

public abstract class Token
{
    private A.eAbilityTrigger trigger;
    private Object value;
    private A.eTokenType type;
    private int remainingTurns;

    public Token(A.eTokenType _type, A.eAbilityTrigger _trigger, Object _value, int _remainingTurns)
    {
        type = _type;
        trigger = _trigger;
        value = _value;
        remainingTurns = _remainingTurns;
    }

    public void Effect(Combatant _caster)
    {

    }

    public Object Value()
    {
        return value;
    }

    public A.eTokenType GetType()
    {
        return type;
    }
}
