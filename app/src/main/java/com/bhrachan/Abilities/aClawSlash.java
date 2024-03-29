package com.bhrachan.Abilities;

import com.bhrachan.A;
import com.bhrachan.Combatant;
import com.bhrachan.Dice;

public class aClawSlash extends AttackAbility
{
    public aClawSlash()
    {
        super("Claw Slash", "You use your claws to attack an enemy.", A.eDice.d4, 1, 0);
        targetLevelMap.put(0, A.eCombatantType.enemy);
    }

    @Override
    public void Effect(int _targetLevel, Combatant[] _targets, Combatant _caster)
    {
        switch(_targetLevel)
        {
            case 0:
                _targets[0].ManipulateHealth( - Dice.Roll(damageDice, numDamageDice * Math.max(_caster.GetSkill(A.eSkills.Dexterity), 1), A.eDiceMode.add));
                break;
            default:
                break;
        }
    }
}
