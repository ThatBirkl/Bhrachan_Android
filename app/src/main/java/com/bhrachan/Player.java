package com.bhrachan;

import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;
import com.bhrachan.Items.Boots;
import com.bhrachan.Items.Clothing;
import com.bhrachan.Items.Hat;
import com.bhrachan.Items.Item;
import com.bhrachan.Items.Pants;
import com.bhrachan.Items.Shield;
import com.bhrachan.Items.Shirt;
import com.bhrachan.Items.Weapon;
import com.bhrachan.Tokens.Token;

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
    private static ArrayList<Token> tokens;

    private static ArrayList<Item> inventory;

    private static Weapon mainHand;
    private static Weapon offHand;
    private static Hat hat;
    private static Shirt shirt;
    private static Pants pants;
    private static Boots boots;

    public static void Init()
    {
        name = new String();
        HD = A.eDice.d8;
        ED = A.eDice.d6;
        currentHP = maxHP = Dice.GetMaxValue(HD);
        currentEnergy = maxEnergy = Dice.GetMaxValue(ED);

        activeAbilities = new ArrayList<ActiveAbility>();
        passiveAbilities = new ArrayList<PassiveAbility>();
        tokens = new ArrayList<Token>();

        inventory = new ArrayList<Item>();

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

    public static void EquipPrimaryWeapon(Weapon _weapon)
    {
        if(_weapon.IsTwoHanded())
        {
            if(mainHand != null)
                inventory.add(mainHand);

            if(offHand != null)
                inventory.add(offHand);

            mainHand = _weapon;
            offHand = _weapon;
        }
        else
        {
            if(mainHand != null)
            {
                inventory.add(mainHand);
                mainHand = _weapon;

                if(mainHand.IsTwoHanded())
                    offHand = null;

            }
            else
            {
                mainHand = _weapon;
            }
        }
    }

    public static void EquipSecondaryWeapon(Weapon _weapon)
    {
        if(_weapon.IsTwoHanded())
        {
            if(mainHand != null)
                inventory.add(mainHand);

            if(offHand != null)
                inventory.add(offHand);

            mainHand = _weapon;
            offHand = _weapon;
        }
        else
        {
            if(offHand != null)
            {
                inventory.add(offHand);
                offHand = _weapon;

                if(offHand.IsTwoHanded())
                    mainHand = null;

            }
            else
            {
                offHand = _weapon;
            }
        }
    }

    public static void EquipHat(Hat _hat)
    {
        if(hat != null)
            inventory.add(hat);

        hat = _hat;
    }

    public static void EquipShirt(Shirt _shirt)
    {
        if(shirt != null)
            inventory.add(shirt);

        shirt = _shirt;
    }

    public static void EquipPants(Pants _pants)
    {
        if(pants != null)
            inventory.add(pants);

        pants = _pants;
    }

    public static void EquipBoots(Boots _boots)
    {
        if(boots != null)
            inventory.add(boots);

        boots = _boots;
    }

    public static void SetHD(A.eDice _dice)
    {
        HD = _dice;
        maxHP = Dice.GetMaxValue(_dice);
        currentHP = maxHP;
    }

    public static void SetED(A.eDice _dice)
    {
        ED = _dice;
        maxEnergy = Dice.GetMaxValue(_dice);
        currentEnergy = maxEnergy;
    }

    public static A.eRace GetRace()
    {
        return race;
    }

    public static Weapon GetPrimaryWeapon()
    {
        return mainHand;
    }

    public static Weapon GetSecondaryWeapon()
    {
        return offHand;
    }

    public static Clothing GetHat()
    {
        return hat;
    }

    public static Clothing GetShirt()
    {
        return shirt;
    }

    public static Clothing GetPants()
    {
        return pants;
    }

    public static Clothing GetBoots()
    {
        return boots;
    }

    /*
    * @return returns AC of 10 + equipment AC
    * */
    public static int GetAC()
    {
        int ret = 10;

        if(offHand.getClass().equals("class com.bhrachan.Items.Shield"))
            ret += ((Shield)offHand).GetAC();
        if(hat != null)
            ret += hat.GetAC();
        if(shirt != null)
            ret += shirt.GetAC();
        if(pants != null)
            ret += pants.GetAC();
        if(boots != null)
            ret += boots.GetAC();

        return ret;
    }

    public static int GetFullAC()
    {
        int ret = GetAC();
        for(int i = 0 ; i < tokens.size(); i++)
        {
            if(tokens.get(i).GetType() == A.eTokenType.AC)
            {
                ret += (int)tokens.get(i).Value();
            }
        }
        ret += GetSkill(A.eSkills.Constitution);

        return ret;
    }

    public static void LvlUp()
    {
        int HP = Dice.Roll(HD, 1, A.eDiceMode.add);
        maxHP += HP;
        currentHP += HP;

        int EP = Dice.Roll(ED, 1, A.eDiceMode.add);
        maxEnergy += EP;
        currentEnergy += EP;
    }
}
