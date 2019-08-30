package com.bhrachan;

import com.bhrachan.Abilities.Ability;
import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;
import com.bhrachan.Tokens.Token;

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
    protected int secsOnTimeline;
    protected int lastAddedSecs;
    protected int lastHealthManipulation;
    protected int AC; //precalculated and won't be changed, only 10 + armor, dex will be added seperately

    protected ArrayList<ActiveAbility> activeAbilities;
    protected ArrayList<PassiveAbility> passiveAbilities;
    protected ArrayList<Token> tokens;

    protected Map<A.eSkills, Integer> combatSkills;

    public Combatant(String _name, int _currentHP, int _maxHP, int _currentEnergy, int _maxEnergy, A.eDice _HD, A.eDice _ED, A.eRace _race,
                     ArrayList<PassiveAbility> _passiveAbilities, ArrayList<ActiveAbility> _activeAbilities, Map<A.eSkills, Integer> _combatSkills, ArrayList<Token> _tokens)
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
        tokens = _tokens;
    }

    public void ManipulateHealth(int _value, boolean _useAbilities)
    {
        lastHealthManipulation = _value;

        currentHP += _value;
        if(currentHP >= maxHP)
            currentHP = maxHP;
        else if(currentHP < 0)
            currentHP = 0;

        if(_useAbilities)
        {
            for(int i = 0 ; i < passiveAbilities.size(); i++)
            {
                if(passiveAbilities.get(i).GetTrigger() == A.eAbilityTrigger.onDamage && _value < 0)
                {
                    passiveAbilities.get(i).Effect(0, new Combatant[]{this}, this);
                }
                else if(passiveAbilities.get(i).GetTrigger() == A.eAbilityTrigger.onHeal && _value > 0)
                {
                    passiveAbilities.get(i).Effect(0, new Combatant[]{this}, this);
                }
            }
        }
    }

    public void ManipulateHealth(int _value)
    {
        ManipulateHealth(_value, true);
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

    public void AddSecs(int _secs, boolean _useAbilities)
    {
        lastAddedSecs = _secs;
        secsOnTimeline += _secs;
        if(_useAbilities)
        {
            for(int i = 0 ; i < passiveAbilities.size(); i++)
            {
                if(passiveAbilities.get(i).GetTrigger() == A.eAbilityTrigger.onCalculateNewTurn)
                {
                    passiveAbilities.get(i).Effect(0, new Combatant[]{this}, this);
                }
            }
        }
    }

    public void AddSecs(int _secs)
    {
        AddSecs(_secs, true);
    }

    public int GetSecs()
    {
        return secsOnTimeline;
    }

    public int GetLastAddedSecs()
    {
        return lastAddedSecs;
    }

    public int GetLastHealthManipulation()
    {
        return lastHealthManipulation;
    }

    public int GetHP()
    {
        return currentHP;
    }

    public int GetMaxHP()
    {
        return maxHP;
    }

    public int GetEP()
    {
        return currentEnergy;
    }

    public int GetMaxEP()
    {
        return maxEnergy;
    }

    public int GetAC()
    {
        int tokenMods = 0;

        for(int i = 0 ; i < tokens.size(); i++)
        {
            if(tokens.get(i).GetType() == A.eTokenType.AC)
            {
                tokenMods += (int)tokens.get(i).Value();
            }
        }

        return AC + GetSkill(A.eSkills.Dexterity);
    }
}
