package com.bhrachan.Abilities;

import com.bhrachan.A;
import com.bhrachan.Combatant;

public class aEscapeDeath extends PassiveAbility
{
    boolean used;
    float regenFactor;
    A.eCalculator calculator;

    public aEscapeDeath(float _regenFactor, A.eCalculator _calculator)
    {
        super("Escape Death", "This ability is automatically activated the first time your HP reach 0. You regenerate some HP.");
        regenFactor = _regenFactor;
        calculator = _calculator;
    }

    @Override
    public void Effect(int _targetLevel, Combatant[] _targets, Combatant _caster)
    {
        int health = _caster.GetHP();
        if(health <= 0 && !used)
        {
            used = true;
            _caster.ManipulateHealth(-health, false); //reset HP to 0
            switch(calculator)
            {

                case add:
                    _caster.ManipulateHealth((int)regenFactor, false);
                    break;
                case multiply:
                    _caster.ManipulateHealth((int)regenFactor * _caster.GetMaxHP(), false);
                    break;
            }
        }
    }
}
