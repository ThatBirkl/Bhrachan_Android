package com.bhrachan.Abilities;

import android.util.SparseArray;
import android.util.SparseIntArray;

import com.bhrachan.A;
import com.bhrachan.Combatant;
import com.bhrachan.Dice;

public abstract class Ability
{
    protected boolean active;
    protected int targetLevels;
    protected SparseArray<A.eCombatantType> targetLevelMap;
    protected SparseIntArray targetsPerLevel;
    protected String name;
    protected String description;

    public Ability(String _name, String _description)
    {
        targetLevels = 1;
        targetLevelMap = new SparseArray<A.eCombatantType>();
        targetsPerLevel = new SparseIntArray();
        targetLevelMap.put(0, A.eCombatantType.x);
        targetsPerLevel.put(0, 1);
        name = _name;
        description = _description;
    }

    public void Effect(int _targetLevel, Combatant[] _targets, Combatant _caster)
    {

    }

    public boolean IsActive()
    {
        return active;
    }

    public String GetName()
    {
        return name;
    }

    public String GetDescription()
    {
        return description;
    }
}
