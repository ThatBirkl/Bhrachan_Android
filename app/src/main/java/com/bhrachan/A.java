package com.bhrachan;

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
}
