package com.bhrachan.Items;

import com.bhrachan.Abilities.ActiveAbility;
import com.bhrachan.Abilities.PassiveAbility;

import java.util.ArrayList;

public abstract class Clothing extends Equipment
{
    protected int AC;
    protected ArrayList<PassiveAbility> passiveAbilities;
    protected ArrayList<ActiveAbility> activeAbilities;

    public Clothing(String _name, String _description, int _AC, ArrayList<ActiveAbility> _activeAbilities, ArrayList<PassiveAbility> _passiveAbilities)
    {
        super(_name, _description);
        AC = _AC;
        passiveAbilities = _passiveAbilities;
        activeAbilities = _activeAbilities;
    }
}
