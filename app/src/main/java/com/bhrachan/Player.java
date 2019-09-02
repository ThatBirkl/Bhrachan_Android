package com.bhrachan;

import android.os.HardwarePropertiesManager;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player
{
    private static String id;
    private static String name;
    private static int currentHP;
    private static int maxHP;
    private static int currentEnergy;
    private static int maxEnergy;
    private static A.eDice HD;
    private static A.eDice ED;
    private static A.eRace race;

    private static Map<A.eSkills, Integer> skillLvl;
    private static Map<A.eSkills, Float> skillProgress;

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
        id = "test_id_replace"; //TODO UTIL.GetUUID();
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

        skillProgress = new HashMap<A.eSkills, Float>();
        skillProgress.put(A.eSkills.Alchemy, 0f);
        skillProgress.put(A.eSkills.Arcane, 0f);
        skillProgress.put(A.eSkills.Axe, 0f);
        skillProgress.put(A.eSkills.Bow, 0f);
        skillProgress.put(A.eSkills.Constitution, 0f);
        skillProgress.put(A.eSkills.Cooking, 0f);
        skillProgress.put(A.eSkills.Crafting, 0f);
        skillProgress.put(A.eSkills.Dexterity, 0f);
        skillProgress.put(A.eSkills.Fauna, 0f);
        skillProgress.put(A.eSkills.Flora, 0f);
        skillProgress.put(A.eSkills.Instantanious, 0f);
        skillProgress.put(A.eSkills.Instincts, 0f);
        skillProgress.put(A.eSkills.Intelligence, 0f);
        skillProgress.put(A.eSkills.Lockpicking, 0f);
        skillProgress.put(A.eSkills.Lore, 0f);
        skillProgress.put(A.eSkills.MagicProwess, 0f);
        skillProgress.put(A.eSkills.Manipulation, 0f);
        skillProgress.put(A.eSkills.Materialization, 0f);
        skillProgress.put(A.eSkills.Medicine, 0f);
        skillProgress.put(A.eSkills.Restoration, 0f);
        skillProgress.put(A.eSkills.Ritual, 0f);
        skillProgress.put(A.eSkills.Shield, 0f);
        skillProgress.put(A.eSkills.Social, 0f);
        skillProgress.put(A.eSkills.Staff, 0f);
        skillProgress.put(A.eSkills.Strength, 0f);
        skillProgress.put(A.eSkills.Sword, 0f);
    }

    public static String GetId()
    {
        return id;
    }

    public static void SetName(String _name)
    {
        DB.Update("CHARACTER", new String[]{"NAME"}, new String[]{_name}, "CHARACTERID = '" + id + "'");
        name = _name;
    }

    public static String GetName()
    {
        return name;
    }

    public static void SetSkill(A.eSkills _skill, int _value)
    {
        DB.Update("SKILL", new String[]{"LEVEL"}, new String[]{"" + _value}, "SKILLID = " + A.GetSkillInt(_skill));
        skillLvl.put(_skill, _value);
    }

    public static int GetSkill(A.eSkills _skill)
    {
        return skillLvl.get(_skill);
    }

    public static float GetSkillProgress(A.eSkills _skill)
    {
        return skillProgress.get(_skill);
    }

    public static void SetSkillProgress(A.eSkills _skill, float _value)
    {
        DB.Update("SKILL", new String[]{"PROGRESS"}, new String[]{"" + _value}, "SKILLID = " + A.GetSkillInt(_skill));
        skillProgress.put(_skill, 0f);
    }

    public static void IncrementSkillLevel(A.eSkills _skill, int _amount, boolean _clearProgress)
    {
        SetSkill(_skill, GetSkill(_skill) + _amount);

        if(_clearProgress)
            SetSkillProgress(_skill, 0f);
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
        DB.Update("CHARACTER", new String[]{"RACE"}, new String[]{""+A.GetRaceInt(_race)}, "CHARACTERID = '" + id + "'");
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

    public static void EquipPrimaryWeapon(Weapon _weapon, boolean _addToInv)
    {
        if(_addToInv)
            AddToInventory(_weapon);

        if(_weapon.IsTwoHanded())
        {
            if(mainHand != null)
            {
                inventory.add(mainHand);
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + mainHand.GetId() + "'");
            }


            if(offHand != null)
            {
                inventory.add(offHand);
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + offHand.GetId() + "'");
            }


            mainHand = _weapon;
            offHand = _weapon;
            DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"true"}, "ITEMID = '" + _weapon.GetId() + "'");
            DB.Update("CHARACTER", new String[]{"MAINHAND"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
        }
        else
        {
            if(mainHand != null)
            {
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + mainHand.GetId() + "'");
                inventory.add(mainHand);

                if(mainHand.IsTwoHanded())
                {
                    offHand = null;
                    DB.Update("CHARACTER", new String[]{"OFFHAND"}, new String[]{null}, "CHARACTERID = '" + id + "'");
                }

                mainHand = _weapon;
                DB.Update("CHARACTER", new String[]{"MAINHAND"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
            }
            else
            {
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + mainHand.GetId() + "'");
                mainHand = _weapon;
            }
        }
    }

    public static void EquipPrimaryWeapon(Weapon _weapon)
    {
        EquipPrimaryWeapon(_weapon, false);
    }

    public static void EquipSecondaryWeapon(Weapon _weapon, boolean _addToInv)
    {
        //TODO add database updates like in primary
        if(_addToInv)
            AddToInventory(_weapon);

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

    public static void EquipSecondaryWeapon(Weapon _weapon)
    {
        EquipSecondaryWeapon(_weapon, false);
    }

    public static void EquipHat(Hat _hat, boolean _addToInv)
    {
        //TODO add database insert/updates
        if(_addToInv)
            AddToInventory(_hat);

        if(hat != null)
            inventory.add(hat);

        hat = _hat;
    }

    public static void EquipHat(Hat _hat)
    {
        EquipHat(_hat, false);
    }

    public static void EquipShirt(Shirt _shirt, boolean _addToInv)
    {
        //TODO add database insert/updates
        if(_addToInv)
            AddToInventory(_shirt);

        if(shirt != null)
            inventory.add(shirt);

        shirt = _shirt;
    }

    public static void EquipShirt(Shirt _shirt)
    {
        EquipShirt(_shirt, false);
    }

    public static void EquipPants(Pants _pants, boolean _addToInv)
    {
        //TODO add database insert/updates
        if(_addToInv)
            AddToInventory(_pants);

        if(pants != null)
            inventory.add(pants);

        pants = _pants;
    }

    public static void EquipPants(Pants _pants)
    {
        EquipPants(_pants, false);
    }

    public static void EquipBoots(Boots _boots, boolean _addToInv)
    {
        //TODO add database insert/updates
        if(_addToInv)
            AddToInventory(_boots);

        if(boots != null)
            inventory.add(boots);

        boots = _boots;
    }

    public static void EquipBoots(Boots _boots)
    {
        EquipBoots(_boots, false);
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

    public static int GetCurrentHP()
    {
        return currentHP;
    }

    public static int GetCurrentEP()
    {
        return currentEnergy;
    }

    public static int GetMaxHP()
    {
        return maxHP;
    }

    public static int GetMaxEP()
    {
        return maxEnergy;
    }

    public static A.eDice GetHD()
    {
        return HD;
    }

    public static A.eDice GetED()
    {
        return ED;
    }

    public static void AddToInventory(Item _item)
    {
        byte[] obj;
        inventory.add(_item);
        try
        {
            obj = UTIL.Serialize(_item);

            DB.Insert("ITEM",
                    new String[]{"ITEMID", "ITEM_TYPE", "EQUIPPED", "OBJECT"},
                    new String[]{_item.GetId(), "" + A.GetItemTypeInt(_item.GetType()), "false", new String(obj)});
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
