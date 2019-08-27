package com.bhrachan.Items;

import com.bhrachan.A;
import com.bhrachan.Abilities.aSlash;

public class Dagger extends Weapon
{
    public Dagger(String _name, String _description, int _numDice, int _addDamage)
    {
        super(_name, _description, A.eDice.d4, _numDice, _addDamage);

        twoHanded = false;

        activeAbilities.add(new aSlash(damageDice, numDice, addDamage));
    }

    public Dagger(String _name, String _description, int _numDice)
    {
        this(_name, _description, _numDice, 0);
    }

    public Dagger(String _name, String _description)
    {
        this(_name, _description, 1);
    }

    public Dagger()
    {
        this("Dagger", "Just a simple dagger.");
    }
}
