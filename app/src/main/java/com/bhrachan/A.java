package com.bhrachan;

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
        Instincts,
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
}
