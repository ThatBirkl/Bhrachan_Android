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

    public Ability()
    {
        targetLevels = 1;
        targetLevelMap = new SparseArray<A.eCombatantType>();
        targetsPerLevel = new SparseIntArray();
        targetLevelMap.put(0, A.eCombatantType.x);
        targetsPerLevel.put(0, 1);
    }

    public void Effect(int _targetLevel, Combatant[] _targets, Combatant _caster)
    {

    }

    public boolean GetActive()
    {
        return active;
    }
}
