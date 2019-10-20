package com.bhrachan.Items;

import com.bhrachan.A;
import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;

import java.util.ArrayList;

public abstract class Weapon extends Equipment
{
    protected ArrayList<ActiveAbility> activeAbilities;
    protected ArrayList<PassiveAbility> passiveAbilities;
    protected A.eDice damageDice;
    protected int numDice;
    protected int addDamage;
    protected boolean twoHanded;

    public Weapon(String _name, String _description, A.eDice _dice, int _numDice, int _addDamage)
    {
        super(_name, _description);
        activeAbilities = new ArrayList<ActiveAbility>();
        passiveAbilities = new ArrayList<PassiveAbility>();
        damageDice = _dice;
        numDice = _numDice;
        addDamage = _addDamage;
        type = A.eItemType.weapon;
    }

    public Weapon(String _name, String _description, A.eDice _dice, int _numDice)
    {
        this(_name, _description, _dice, _numDice, 0);
    }

    public boolean IsTwoHanded()
    {
        return twoHanded;
    }
}
