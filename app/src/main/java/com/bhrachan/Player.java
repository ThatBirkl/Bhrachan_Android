package com.bhrachan;

import com.bhrachan.Abilities.Ability;
import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player
{
    private static String name;
    private static int currentHP;
    private static int maxHP;
    private static int currentEnergy;
    private static int maxEnergy;
    private static A.eDice HD;
    private static A.eDice ED;
    private static A.eRace race;

    private static Map<A.eSkills, Integer> skillLvl;
    private static Map<A.eSkills, Integer> skillProgress;

    private static ArrayList<ActiveAbility> activeAbilities;
    private static ArrayList<PassiveAbility> passiveAbilities;

    public static void Init()
    {
        name = new String();
        HD = A.eDice.d8;
        ED = A.eDice.d6;
        currentHP = maxHP = Dice.GetMaxValue(HD);
        currentEnergy = maxEnergy = Dice.GetMaxValue(ED);

        activeAbilities = new ArrayList<ActiveAbility>();
        passiveAbilities = new ArrayList<PassiveAbility>();

        skillLvl = new HashMap<A.eSkills, Integer>();
        skillLvl.put(A.eSkills.Alchemy, 0);
        skillLvl.put(A.eSkills.Arcane, 0);
        skillLvl.put(A.eSkills.Axe, 0);
        skillLvl.put(A.eSkills.Bow, 0);
        skillLvl.put(A.eSkills.Constitution, 0);
        skillLvl.put(A.eSkills.Cooking, 0);
        skillLvl.put(A.eSkills.Crafting, 0);
        skillLvl.put(A.eSkills.Dexterity, 0);
        skillLvl.put(A.eSkills.Fauna, 0);
        skillLvl.put(A.eSkills.Flora, 0);
        skillLvl.put(A.eSkills.Instantanious, 0);
        skillLvl.put(A.eSkills.Instincts, 0);
        skillLvl.put(A.eSkills.Intelligence, 0);
        skillLvl.put(A.eSkills.Lockpicking, 0);
        skillLvl.put(A.eSkills.Lore, 0);
        skillLvl.put(A.eSkills.MagicProwess, 0);
        skillLvl.put(A.eSkills.Manipulation, 0);
        skillLvl.put(A.eSkills.Materialization, 0);
        skillLvl.put(A.eSkills.Medicine, 0);
        skillLvl.put(A.eSkills.Restoration, 0);
        skillLvl.put(A.eSkills.Ritual, 0);
        skillLvl.put(A.eSkills.Shield, 0);
        skillLvl.put(A.eSkills.Social, 0);
        skillLvl.put(A.eSkills.Staff, 0);
        skillLvl.put(A.eSkills.Strength, 0);
        skillLvl.put(A.eSkills.Sword, 0);

        skillProgress = new HashMap<A.eSkills, Integer>();
        skillProgress.put(A.eSkills.Alchemy, 0);
        skillProgress.put(A.eSkills.Arcane, 0);
        skillProgress.put(A.eSkills.Axe, 0);
        skillProgress.put(A.eSkills.Bow, 0);
        skillProgress.put(A.eSkills.Constitution, 0);
        skillProgress.put(A.eSkills.Cooking, 0);
        skillProgress.put(A.eSkills.Crafting, 0);
        skillProgress.put(A.eSkills.Dexterity, 0);
        skillProgress.put(A.eSkills.Fauna, 0);
        skillProgress.put(A.eSkills.Flora, 0);
        skillProgress.put(A.eSkills.Instantanious, 0);
        skillProgress.put(A.eSkills.Instincts, 0);
        skillProgress.put(A.eSkills.Intelligence, 0);
        skillProgress.put(A.eSkills.Lockpicking, 0);
        skillProgress.put(A.eSkills.Lore, 0);
        skillProgress.put(A.eSkills.MagicProwess, 0);
        skillProgress.put(A.eSkills.Manipulation, 0);
        skillProgress.put(A.eSkills.Materialization, 0);
        skillProgress.put(A.eSkills.Medicine, 0);
        skillProgress.put(A.eSkills.Restoration, 0);
        skillProgress.put(A.eSkills.Ritual, 0);
        skillProgress.put(A.eSkills.Shield, 0);
        skillProgress.put(A.eSkills.Social, 0);
        skillProgress.put(A.eSkills.Staff, 0);
        skillProgress.put(A.eSkills.Strength, 0);
        skillProgress.put(A.eSkills.Sword, 0);
    }

    public static void SetName(String _name)
    {
        name = _name;
    }

    public static String GetName()
    {
        return name;
    }

    public static void SetSkill(A.eSkills _skill, int _value)
    {
        skillLvl.put(_skill, _value);
    }

    public static int GetSkill(A.eSkills _skill)
    {
        return skillLvl.get(_skill);
    }

    public static void IncrementSkillLevel(A.eSkills _skill, int _amount, boolean _clearProgress)
    {
        skillLvl.put(_skill, GetSkill(_skill) + _amount);
        if(_clearProgress)
            skillProgress.put(_skill, 0);
    }

    public static void IncrementSkillLevel(A.eSkills _skill, boolean _clearProgress)
    {
        IncrementSkillLevel(_skill, 1, _clearProgress);
    }

    public static void IncrementSkillLevel(A.eSkills _skill)
    {
        IncrementSkillLevel(_skill, 1, false);
    }

    public static void SetRace(A.eRace _race)
    {
        race = _race;
    }

    public static void AddActiveAbility(ActiveAbility _ability)
    {
        activeAbilities.add(_ability);
    }

    public static void AddPassiveAbility(PassiveAbility _ability)
    {
        passiveAbilities.add(_ability);
    }
}
