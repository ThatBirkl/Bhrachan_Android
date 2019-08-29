package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bhrachan.Abilities.Ability;
import com.bhrachan.Abilities.aAlterNextTurnTime;
import com.bhrachan.Abilities.aClawSlash;
import com.bhrachan.Abilities.aEscapeDeath;
import com.bhrachan.Items.Dagger;
import com.bhrachan.Items.Hat;
import com.bhrachan.Items.Pants;
import com.bhrachan.Items.Shirt;

public class CharacterCreationActivity extends AppCompatActivity
{

    private int skillPointsLeft;
    private TextView lbl_points;

    private boolean CheckSkill()
    {
        if(skillPointsLeft == 0)
            return false;

        skillPointsLeft--;

        lbl_points.setText("" + skillPointsLeft);

        return true;
    }

    private void UncheckSkill()
    {
        skillPointsLeft++;
        lbl_points.setText("" + skillPointsLeft);
    }

    private void SetStatsOnPlayer()
    {
        String name = ((EditText) findViewById(R.id.edt_charName)).getText().toString();
        Player.SetName(name);

        if(((CheckBox)findViewById(R.id.chk_skill_alchemy)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Alchemy);
        if(((CheckBox)findViewById(R.id.chk_skill_arcane)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Arcane);
        if(((CheckBox)findViewById(R.id.chk_skill_axe)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Axe);
        if(((CheckBox)findViewById(R.id.chk_skill_bow)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Bow);
        if(((CheckBox)findViewById(R.id.chk_skill_cooking)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Cooking);
        if(((CheckBox)findViewById(R.id.chk_skill_crafting)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Crafting);
        if(((CheckBox)findViewById(R.id.chk_skill_fauna)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Fauna);
        if(((CheckBox)findViewById(R.id.chk_skill_flora)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Flora);
        if(((CheckBox)findViewById(R.id.chk_skill_instant)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Instantanious);
        if(((CheckBox)findViewById(R.id.chk_skill_instincts)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Instincts);
        if(((CheckBox)findViewById(R.id.chk_skill_lockpicking)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Lockpicking);
        if(((CheckBox)findViewById(R.id.chk_skill_lore)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Lore);
        if(((CheckBox)findViewById(R.id.chk_skill_manipulation)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Manipulation);
        if(((CheckBox)findViewById(R.id.chk_skill_materialization)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Materialization);
        if(((CheckBox)findViewById(R.id.chk_skill_medical)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Medicine);
        if(((CheckBox)findViewById(R.id.chk_skill_restoration)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Restoration);
        if(((CheckBox)findViewById(R.id.chk_skill_ritual)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Ritual);
        if(((CheckBox)findViewById(R.id.chk_skill_shield)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Shield);
        if(((CheckBox)findViewById(R.id.chk_skill_staff)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Staff);
        if(((CheckBox)findViewById(R.id.chk_skill_sword)).isChecked())
            Player.IncrementSkillLevel(A.eSkills.Sword);
    }

    private void SetRaceOnPlayer()
    {
        //TODO give all boni to the races
        Spinner cmb_race = (Spinner)findViewById(R.id.cmb_race);
        String race = cmb_race.getSelectedItem().toString();

        if(race.equals("Avian"))
        {
            Player.AddPassiveAbility(new aAlterNextTurnTime("Quick", "Due to your avian nature you are quicker than other people.",2/3f, A.eCalculator.multiply));
            Player.SetED(A.eDice.d6);
            Player.SetRace(A.eRace.Avian);
        }
        else if(race.equals("Centaur"))
        {
            Player.SetED(A.eDice.d10);
            //negative
            Player.SetRace(A.eRace.Centaur);
        }
        else if(race.equals("Dwarf"))
        {
            Player.IncrementSkillLevel(A.eSkills.Strength);
            Player.AddPassiveAbility(new aAlterNextTurnTime("Slow", "Due to your dwarven nature you are slower than other people.", 4/3f, A.eCalculator.multiply));
            Player.SetRace(A.eRace.Dwarf);
        }
        else if(race.equals("Elf"))
        {
            Player.AddActiveAbility(new aClawSlash());
            //negative
            Player.SetRace(A.eRace.Elf);
        }
        else if(race.equals("Felin"))
        {
            Player.SetED(A.eDice.d8);
            //negative
            Player.SetRace(A.eRace.Felin);
        }
        else if(race.equals("Human"))
        {
            Player.IncrementSkillLevel(UTIL.GetRandomSkill());
            //negative
            Player.SetRace(A.eRace.Human);
        }
        else if(race.equals("Lacertan"))
        {
            Player.AddPassiveAbility(new aEscapeDeath(0.1f, A.eCalculator.multiply));
            //negative
            Player.SetRace(A.eRace.Lacertan);
        }
        else if(race.equals("Orc"))
        {
            Player.IncrementSkillLevel(A.eSkills.Constitution);
            //negative
            Player.SetRace(A.eRace.Orc);
        }
    }

    private void SetEquipmentOnPlayer()
    {
        Player.EquipPrimaryWeapon(new Dagger());
        Player.EquipShirt(new Shirt("Linen Shirt","Just a simple shirt made from linen."));
        Player.EquipPants(new Pants("Linen Pants", "Just a regular pair of pants made from linen."));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        skillPointsLeft = 5;

        lbl_points = (TextView) findViewById(R.id.lbl_skillPoints);
        lbl_points.setText("" + skillPointsLeft);

        Button btn_ok = (Button)findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(skillPointsLeft == 0)
                {
                    String name = ((EditText) findViewById(R.id.edt_charName)).getText().toString();

                    if(!name.equals(""))
                    {
                        Player.Init();
                        SetStatsOnPlayer();
                        SetRaceOnPlayer();
                        SetEquipmentOnPlayer();
                        CharacterCreationActivity.this.startActivity(new Intent(getApplicationContext(), CharacterActivity.class));
                        finish();
                    }
                    else
                    {
                        Context context = getApplicationContext();
                        CharSequence text = "You need a name.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Still " + skillPointsLeft + " skill points remaining.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        View.OnClickListener chk_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();

                if(checked)
                {
                    if(skillPointsLeft == 0)
                    {
                        ((CheckBox) view).setChecked(false);
                    }
                    else
                    {
                        CheckSkill();
                    }

                }
                else
                {
                    UncheckSkill();
                }
            }
        };

        ((CheckBox)findViewById(R.id.chk_skill_axe)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_arcane)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_alchemy)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_bow)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_crafting)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_cooking)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_fauna)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_flora)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_instant)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_instincts)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_lockpicking)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_lore)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_manipulation)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_materialization)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_medical)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_restoration)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_ritual)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_shield)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_staff)).setOnClickListener(chk_listener);
        ((CheckBox)findViewById(R.id.chk_skill_sword)).setOnClickListener(chk_listener);

    }
}
