package com.bhrachan;

import android.os.HardwarePropertiesManager;
import android.util.Log;

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
    private static int lvl;

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
        id = UTIL.GetUUID();
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
        {
            //Add to inventory and database
            AddToInventory(_weapon);
        }


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
            DB.Update("CHARACTER", new String[]{"MAINHAND_ID"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
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
                    DB.Update("CHARACTER", new String[]{"OFFHAND_ID"}, new String[]{null}, "CHARACTERID = '" + id + "'");
                }

                mainHand = _weapon;
                DB.Update("CHARACTER", new String[]{"MAINHAND_ID"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
            }
            else
            {
                mainHand = _weapon;
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + mainHand.GetId() + "'");
            }
        }
    }

    public static void EquipPrimaryWeapon(Weapon _weapon)
    {
        EquipPrimaryWeapon(_weapon, false);
    }

    public static void EquipSecondaryWeapon(Weapon _weapon, boolean _addToInv)
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
            DB.Update("CHARACTER", new String[]{"OFFHAND_ID"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
        }
        else
        {
            if(offHand != null)
            {
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + offHand.GetId() + "'");
                inventory.add(offHand);


                if(offHand.IsTwoHanded())
                {
                    mainHand = null;
                    DB.Update("CHARACTER", new String[]{"MAINHAND_ID"}, new String[]{null}, "CHARACTERID = '" + id + "'");
                }


                offHand = _weapon;
                DB.Update("CHARACTER", new String[]{"OFFHAND_ID"}, new String[]{_weapon.GetId()}, "CHARACTERID = '" + id + "'");
            }
            else
            {
                DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + offHand.GetId() + "'");
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
        if(_addToInv)
            AddToInventory(_hat);

        if(hat != null)
        {
            DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + hat.GetId() + "'");
            inventory.add(hat);
        }


        hat = _hat;
        DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"true"}, "ITEMID = '" + hat.GetId() + "'");
        DB.Update("CHARACTER", new String[]{"HAT_ID"}, new String[]{hat.GetId()}, "CHARACTERID = '" + id + "'");
    }

    public static void EquipHat(Hat _hat)
    {
        EquipHat(_hat, false);
    }

    public static void EquipShirt(Shirt _shirt, boolean _addToInv)
    {
        if(_addToInv)
            AddToInventory(_shirt);

        if(shirt != null)
        {
            DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + shirt.GetId() + "'");
            inventory.add(shirt);
        }

        shirt = _shirt;
        DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"true"}, "ITEMID = '" + shirt.GetId() + "'");
        DB.Update("CHARACTER", new String[]{"SHIRT_ID"}, new String[]{shirt.GetId()}, "CHARACTERID = '" + id + "'");
    }

    public static void EquipShirt(Shirt _shirt)
    {
        EquipShirt(_shirt, false);
    }

    public static void EquipPants(Pants _pants, boolean _addToInv)
    {
        if(_addToInv)
            AddToInventory(_pants);

        if(pants != null)
        {
            DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + pants.GetId() + "'");
            inventory.add(pants);
        }

        pants = _pants;
        DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"true"}, "ITEMID = '" + pants.GetId() + "'");
        DB.Update("CHARACTER", new String[]{"PANTS_ID"}, new String[]{pants.GetId()}, "CHARACTERID = '" + id + "'");
    }

    public static void EquipPants(Pants _pants)
    {
        EquipPants(_pants, false);
    }

    public static void EquipBoots(Boots _boots, boolean _addToInv)
    {
        if(_addToInv)
            AddToInventory(_boots);

        if(boots != null)
        {
            DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"false"}, "ITEMID = '" + boots.GetId() + "'");
            inventory.add(boots);
        }

        boots = _boots;
        DB.Update("ITEM", new String[]{"EQUIPPED"}, new String[]{"true"}, "ITEMID = '" + boots.GetId() + "'");
        DB.Update("CHARACTER", new String[]{"BOOTS_ID"}, new String[]{boots.GetId()}, "CHARACTERID = '" + id + "'");
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
            String itemStr = UTIL.BytesToHexString(obj);

            DB.Insert("ITEM",
                    new String[]{"ITEMID", "ITEM_TYPE", "EQUIPPED", "OBJECT"},
                    new String[]{_item.GetId(), "" + A.GetItemTypeInt(_item.GetType()), "false", itemStr});
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Log.e("Inserting Item", e.getMessage(), e);
        }
    }

    public static void LoadCharacter()
    {
        String[] character = DB.Table("select * from CHARACTER")[0];
        id = character[0];
        currentHP = UTIL.ParseInt(character[1]);
        maxHP = UTIL.ParseInt(character[2]);
        currentEnergy = UTIL.ParseInt(character[3]);
        maxEnergy = UTIL.ParseInt(character[4]);
        race = A.GetRaceFromInt(UTIL.ParseInt(character[5]));
        name = character[6];
        HD = A.GetDiceFromInt(UTIL.ParseInt(character[7]));
        ED = A.GetDiceFromInt(UTIL.ParseInt(character[8]));
        lvl = UTIL.ParseInt(character[15]);

        //MAINHAND
        String[][] dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = MAINHAND_ID where CHARACTERID = '" + id + "'");
        String[] data;
        Log.e("dateTmp.length", "" + dataTmp.length);
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                mainHand = (Weapon)UTIL.Deserialize(UTIL.HexStringToBytes(data[3]));
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }

        //OFFHAND
        dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = OFFHAND_ID where CHARACTERID = '" + id + "'");
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                offHand = (Weapon)UTIL.Deserialize(data[3].getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }

        //HAT
        dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = HAT_ID where CHARACTERID = '" + id + "'");
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                hat = (Hat)UTIL.Deserialize(UTIL.HexStringToBytes(data[3]));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }

        //SHIRT
        dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = SHIRT_ID where CHARACTERID = '" + id + "'");
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                shirt = (Shirt)UTIL.Deserialize(UTIL.HexStringToBytes(data[3]));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }

        //PANTS
        dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = PANTS_ID where CHARACTERID = '" + id + "'");
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                pants = (Pants)UTIL.Deserialize(UTIL.HexStringToBytes(data[3]));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }

        //BOOTS
        dataTmp = DB.Table("select * from ITEM join CHARACTER on ITEMID = BOOTS_ID where CHARACTERID = '" + id + "'");
        if(dataTmp.length != 0)
        {
            data = dataTmp[0];
            try {
                boots = (Boots)UTIL.Deserialize(UTIL.HexStringToBytes(data[3]));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("Deserializing mainHand", e.getStackTrace().toString());
            }
        }


        LoadSkills();
    }

    private static void LoadSkills()
    {
        if(skillLvl == null)
            skillLvl = new HashMap<A.eSkills, Integer>();

        if(skillProgress == null)
            skillProgress = new HashMap<A.eSkills, Float>();

        A.eSkills[] skills = A.GetCompleteSkillArray();

        String[] data;
        for(int i = 0; i < skills.length; i++)
        {
            data = DB.Table("select * from SKILL where SKILLID = " + A.GetSkillInt(skills[i]))[0];
            skillLvl.put(skills[i], UTIL.ParseInt(data[2]));
            skillProgress.put(skills[i], UTIL.ParseFloat(data[1]));
        }
    }
}
