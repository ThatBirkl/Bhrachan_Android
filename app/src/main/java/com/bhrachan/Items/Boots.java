package com.bhrachan.Items;


import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;

import java.util.ArrayList;

public class Boots extends Clothing
{
    public Boots(String _name, String _description, int _AC, ArrayList<ActiveAbility> _activeAbilities, ArrayList<PassiveAbility> _passiveAbilities)
    {
        super(_name, _description, _AC, _activeAbilities, _passiveAbilities);
    }

    public Boots(String _name, String _description, int _AC)
    {
        this(_name, _description, _AC, new ArrayList<ActiveAbility>(), new ArrayList<PassiveAbility>());
    }

    public Boots(String _name, String _description)
    {
        this(_name, _description, 0);
    }
}
