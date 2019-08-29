package com.bhrachan.Abilities;

import com.bhrachan.A;
import com.bhrachan.Combatant;

public class aAlterNextTurnTime extends PassiveAbility
{
    float factor;
    A.eCalculator calculator;

    public aAlterNextTurnTime(String _name, String _description, float _factor, A.eCalculator _calculator)
    {
        super(_name, _description);
        factor = _factor;
        calculator = _calculator;
        trigger = A.eAbilityTrigger.onCalculateNewTurn;
        targetLevels = 0;
    }

    @Override
    public void Effect(int _targetLevel, Combatant[] _targets, Combatant _caster)
    {
        int lastAdded = _caster.GetLastAddedSecs();
        int adding = -lastAdded;
        switch (calculator)
        {

            case add:
                adding += (int) factor + lastAdded;
                break;
            case multiply:
                adding += factor * lastAdded;
                break;
        }
        _caster.AddSecs(adding, false);
    }
}
