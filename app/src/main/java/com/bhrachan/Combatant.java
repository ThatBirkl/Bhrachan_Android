package com.bhrachan;

import com.bhrachan.Abilities.Ability;
import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;

import java.util.ArrayList;
import java.util.Map;

public class Combatant
{
    protected String name;
    protected int currentHP;
    protected int maxHP;
    protected int currentEnergy;
    protected int maxEnergy;
    protected A.eDice HD;
    protected A.eDice ED;
    protected A.eRace race;

    protected ArrayList<ActiveAbility> activeAbilities;
    protected ArrayList<PassiveAbility> passiveAbilities;

    protected Map<A.eSkills, Integer> combatSkills;

    public Combatant(String _name, int _currentHP, int _maxHP, int _currentEnergy, int _maxEnergy, A.eDice _HD, A.eDice _ED, A.eRace _race,
                     ArrayList<PassiveAbility> _passiveAbilities, ArrayList<ActiveAbility> _activeAbilities, Map<A.eSkills, Integer> _combatSkills)
    {
        name = _name;
        currentHP = _currentHP;
        maxHP = _maxHP;
        currentEnergy = _currentEnergy;
        maxEnergy = _maxEnergy;
        HD = _HD;
        ED = _ED;
        race = _race;
        passiveAbilities = _passiveAbilities;
        activeAbilities = _activeAbilities;
        combatSkills = _combatSkills;
    }

    public void ManipulateHealth(int _value)
    {
        currentHP += _value;
        if(currentHP >= maxHP)
            currentHP = maxHP;
        else if(currentHP < 0)
            currentHP = 0;
    }

    public int GetSkill(A.eSkills _skill)
    {
        if(combatSkills.containsKey(_skill))
        {
            return combatSkills.get(_skill);
        }
        else
        {
            return 0;
        }
    }
}
