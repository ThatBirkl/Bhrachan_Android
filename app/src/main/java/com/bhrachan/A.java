package com.bhrachan;

import android.util.Log;

import com.bhrachan.Items.Item;

import java.util.HashMap;
import java.util.Map;

public class A
{
	public enum eSkills
    {
        Social,
        //KNOWLEDGE
        Intelligence,
        Arcane,
        Medicine,
        Flora,
        Fauna,
        Lore,
        //PHYSICAL
        Dexterity,
        Strength,
        Constitution,
        Bow,
        Sword,
        Axe,
        Shield,
        Staff,
        Pickpocketing,
        Lockpicking,
        Cooking,
        Alchemy,
        Crafting,
        //MAGIC
        MagicProwess,
        Manipulation,
        Restoration,
        Materialization,
        Ritual,
        Instantanious
    }
	
	//when passive abilities should be called
	public enum eAbilityTrigger
    {
        onHeal,
        onHealDealt,
        onDamage,
        onDamageDealt,
        onBeginCombat,
        onEndCombat,
        onBeginTurn,
        onEndTurn,
        onCalculateNewTurn
    }
	
	//used if more than one dice is thrown
	public enum eDiceMode
	{
		add,
		advantage,
		disadvantage
	}

	public enum eDice
    {
        d1,
        d2,
        d4,
        d6,
        d8,
        d10,
        d12,
        d20,
        d100
    }

    public enum eRace
    {
        Avian,
        Centaur,
        Dwarf,
        Elf,
        Felin,
        Human,
        Lacertan,
        Orc
    }

    public enum eCombatantType
    {
        x,
        enemy,
        ally
    }

    public enum eCalculator
    {
        add,
        multiply
    }

    public enum eItemType
    {
        item,
        resource,
        clothing,
        weapon
    }

    public enum eTokenType
    {
        AC
    }

    private static Map<String, Object> images;

	public static void Init()
    {
        images = new HashMap<String, Object>();
    }

    public static void SetImage(String _name, Object _data)
    {
        images.put(_name, _data);
    }

    public static Object GetImage(String _name)
    {
        return images.get(_name);
    }

    public static void DeleteImage(String _name)
    {
        images.remove(_name);
    }

    public static boolean ImageExists(String _name)
    {
        return images.containsKey(_name);
    }

    public static String GetRaceString(A.eRace _race)
    {
        String ret = "";

        switch (_race)
        {

            case Avian:
                ret = "Avian";
                break;
            case Centaur:
                ret = "Centaur";
                break;
            case Dwarf:
                ret = "Dwarf";
                break;
            case Elf:
                ret = "Elf";
                break;
            case Felin:
                ret = "Felin";
                break;
            case Human:
                ret = "Human";
                break;
            case Lacertan:
                ret = "Lacertan";
                break;
            case Orc:
                ret = "Orc";
                break;
        }

        return ret;
    }

    public static int GetRaceInt(A.eRace _race)
    {
        int ret = 0;
        switch (_race)
        {

            case Avian:
                break;
            case Centaur:
                ret = 1;
                break;
            case Dwarf:
                ret = 2;
                break;
            case Elf:
                ret = 3;
                break;
            case Felin:
                ret = 4;
                break;
            case Human:
                ret = 5;
                break;
            case Lacertan:
                ret = 6;
                break;
            case Orc:
                ret = 7;
                break;
        }
        return ret;
    }

    public static A.eRace GetRaceFromInt(int _race)
    {
        eRace ret = eRace.Avian;

        switch (_race)
        {
            case 1:
                ret = eRace.Centaur;
                break;
            case 2:
                ret = eRace.Dwarf;
                break;
            case 3:
                ret = eRace.Elf;
                break;
            case 4:
                ret = eRace.Felin;
                break;
            case 5:
                ret = eRace.Human;
                break;
            case 6:
                ret = eRace.Lacertan;
                break;
            case 7:
                ret = eRace.Orc;
                break;
        }

        return ret;
    }

    public static String GetItemArt(Item _item)
    {
        String ret = "";
        String itemClass = _item.getClass().toString();
        Log.d("Item", itemClass);
        if(itemClass.equals("class com.bhrachan.Items.Sword"))
        {
            ret =   "            /| ________________________\n" +
                    "O|===|* >________________________>\n" +
                    "           \\|";
        }
        else if(itemClass.equals("class com.bhrachan.Items.Dagger"))
        {
            ret = "            /| ____________\n" +
                     "O|===|* >____________>\n" +
                    "            \\|";
        }
        else if(itemClass.equals("class com.bhrachan.Items.Axe"))
        {
            ret =   " _   _\n" +
                    "/ \\|/ \\\n" +
                    "\\_/|\\_/\n" +
                    "   |\n" +
                    "   |\n" +
                    "   |";
        }
        else if(itemClass.equals("class com.bhrachan.Items.Shield"))
        {
            ret =   "|`\\_/\\_/`|\n" +
                    "|__(<>)__|\n" +
                    "\\   ||   /\n" +
                    " \\  ||  /\n" +
                    "  '.||.'";
        }
        return ret;
    }

    public static int GetDiceInt(A.eDice _dice)
    {
        int ret = 0;
        switch (_dice)
        {
            case d1:
                ret = 1;
                break;
            case d2:
                ret = 2;
                break;
            case d4:
                ret = 4;
                break;
            case d6:
                ret = 6;
                break;
            case d8:
                break;
            case d10:
                ret = 10;
                break;
            case d12:
                ret = 12;
                break;
            case d20:
                ret = 20;
                break;
            case d100:
                ret = 100;
                break;
        }

        return ret;
    }

    public static eDice GetDiceFromInt(int _dice)
    {
        eDice ret = eDice.d1;

        switch (_dice)
        {
            case 2:
                ret = eDice.d2;
                break;
            case 4:
                ret = eDice.d4;
                break;
            case 6:
                ret = eDice.d6;
                break;
            case 8:
                ret = eDice.d8;
                break;
            case 10:
                ret = eDice.d10;
                break;
            case 12:
                ret = eDice.d12;
                break;
            case 20:
                ret = eDice.d20;
                break;
            case 100:
                ret = eDice.d100;
                break;
        }

        return ret;
    }

    public static int GetSkillInt(A.eSkills _skill)
    {
        int ret = 0;

        switch (_skill)
        {
            case Social:
                break;
            case Intelligence:
                ret = 1;
                break;
            case Arcane:
                ret = 2;
                break;
            case Medicine:
                ret = 3;
                break;
            case Flora:
                ret = 4;
                break;
            case Fauna:
                ret = 5;
                break;
            case Lore:
                ret = 6;
                break;
            case Dexterity:
                ret = 7;
                break;
            case Strength:
                ret = 8;
                break;
            case Constitution:
                ret = 9;
                break;
            case Bow:
                ret = 10;
                break;
            case Sword:
                ret = 11;
                break;
            case Axe:
                ret = 12;
                break;
            case Shield:
                ret = 13;
                break;
            case Staff:
                ret = 14;
                break;
            case Instincts:
                ret = 15;
                break;
            case Lockpicking:
                ret = 16;
                break;
            case Cooking:
                ret = 17;
                break;
            case Alchemy:
                ret = 18;
                break;
            case Crafting:
                ret = 19;
                break;
            case MagicProwess:
                ret = 20;
                break;
            case Manipulation:
                ret = 21;
                break;
            case Restoration:
                ret = 22;
                break;
            case Materialization:
                ret = 23;
                break;
            case Ritual:
                ret = 24;
                break;
            case Instantanious:
                ret = 25;
                break;
        }

        return ret;
    }

    public static eSkills GetSkillFromInt(int _skill)
    {
        eSkills ret = eSkills.Social;
        switch(_skill)
        {
            case 1:
                ret = eSkills.Intelligence;
                break;
            case 2:
                ret = eSkills.Arcane;
                break;
            case 3:
                ret = eSkills.Medicine;
                break;
            case 4:
                ret = eSkills.Flora;
                break;
            case 5:
                ret = eSkills.Fauna;
                break;
            case 6:
                ret = eSkills.Lore;
                break;
            case 7:
                ret = eSkills.Dexterity;
                break;
            case 8:
                ret = eSkills.Strength;
                break;
            case 9:
                ret = eSkills.Constitution;
                break;
            case 10:
                ret = eSkills.Bow;
                break;
            case 11:
                ret = eSkills.Sword;
                break;
            case 12:
                ret = eSkills.Axe;
                break;
            case 13:
                ret = eSkills.Shield;
                break;
            case 14:
                ret = eSkills.Staff;
                break;
            case 15:
                ret = eSkills.Instincts;
                break;
            case 16:
                ret = eSkills.Lockpicking;
                break;
            case 17:
                ret = eSkills.Cooking;
                break;
            case 18:
                ret = eSkills.Alchemy;
                break;
            case 19:
                ret = eSkills.Crafting;
                break;
            case 20:
                ret = eSkills.MagicProwess;
                break;
            case 21:
                ret = eSkills.Manipulation;
                break;
            case 22:
                ret = eSkills.Restoration;
                break;
            case 23:
                ret = eSkills.Materialization;
                break;
            case 24:
                ret = eSkills.Ritual;
                break;
            case 25:
                ret = eSkills.Instantanious;
                break;
        }

        return ret;
    }

    public static int GetItemTypeInt(A.eItemType _itemType)
    {
        int ret = 0;

        switch(_itemType)
        {
            case item:
                break;
            case resource:
                ret = 1;
                break;
            case clothing:
                ret = 2;
                break;
            case weapon:
                ret = 3;
                break;
        }

        return ret;
    }

    public static eItemType GetItemTypeFromInt(int _itemType)
    {
        A.eItemType t = eItemType.item;

        switch(_itemType)
        {
            case 1:
                t = eItemType.resource;
                break;
            case 2:
                t = eItemType.clothing;
                break;
            case 3:
                t = eItemType.weapon;
                break;
        }
        return t;
    }

    public static eSkills[] GetCompleteSkillArray()
    {
        return eSkills.values();
    }
}
