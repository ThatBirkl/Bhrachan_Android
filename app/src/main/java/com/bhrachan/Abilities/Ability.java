package com.bhrachan.Abilities;

import android.util.SparseArray;
import android.util.SparseIntArray;

import com.bhrachan.A;
import com.bhrachan.Combatant;
import com.bhrachan.Dice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Ability implements Serializable
{
    protected boolean active;
    protected int targetLevels;
    protected Map<Integer, A.eCombatantType> targetLevelMap;
    protected Map<Integer, Integer> targetsPerLevel;
    protected String name;
    protected String description;

    public Ability(String _name, String _description)
    {
        targetLevels = 1;
        targetLevelMap = new HashMap<Integer, A.eCombatantType>();
        targetsPerLevel = new HashMap<Integer, Integer>();
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
