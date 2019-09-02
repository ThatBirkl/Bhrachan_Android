package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        Player.EquipPrimaryWeapon(new Dagger(), true);
        Player.EquipShirt(new Shirt("Linen Shirt","Just a simple shirt made from linen."), true);
        Player.EquipPants(new Pants("Linen Pants", "Just a regular pair of pants made from linen."), true);
    }

    private void InsertPlayerInDB()
    {
        String[] columns = DB.GetNames("CHARACTER");
        String[] values = { "" + Player.GetId(),
                            "" + Player.GetCurrentHP(),
                            "" + Player.GetMaxHP(),
                            "" + Player.GetCurrentEP(),
                            "" + Player.GetMaxEP(),
                            "" + A.GetRaceInt(Player.GetRace()),
                            "" + Player.GetName(),
                            "" + A.GetDiceInt(Player.GetHD()),
                            "" + A.GetDiceInt(Player.GetED()),
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "" + 0};
        DB.Insert("CHARACTER", columns, values);

        columns = DB.GetNames("SKILL");
        String[][][] statements = new String[26][4][columns.length];

        statements[0][0][0] = "SKILL";
        statements[0][1] = columns;
        statements[0][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Axe), "" + Player.GetSkill(A.eSkills.Axe), "" + Player.GetSkill(A.eSkills.Axe)};

        statements[1][0][0] = "SKILL";
        statements[1][1] = columns;
        statements[1][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Arcane), "" + Player.GetSkill(A.eSkills.Arcane), "" + Player.GetSkill(A.eSkills.Arcane)};

        statements[2][0][0] = "SKILL";
        statements[2][1] = columns;
        statements[2][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Alchemy), "" + Player.GetSkill(A.eSkills.Alchemy), "" + Player.GetSkill(A.eSkills.Alchemy)};

        statements[3][0][0] = "SKILL";
        statements[3][1] = columns;
        statements[3][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Bow), "" + Player.GetSkill(A.eSkills.Bow), "" + Player.GetSkill(A.eSkills.Bow)};

        statements[4][0][0] = "SKILL";
        statements[4][1] = columns;
        statements[4][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Constitution), "" + Player.GetSkill(A.eSkills.Constitution), "" + Player.GetSkill(A.eSkills.Constitution)};

        statements[5][0][0] = "SKILL";
        statements[5][1] = columns;
        statements[5][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Crafting), "" + Player.GetSkill(A.eSkills.Crafting), "" + Player.GetSkill(A.eSkills.Crafting)};

        statements[6][0][0] = "SKILL";
        statements[6][1] = columns;
        statements[6][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Cooking), "" + Player.GetSkill(A.eSkills.Cooking), "" + Player.GetSkill(A.eSkills.Cooking)};

        statements[7][0][0] = "SKILL";
        statements[7][1] = columns;
        statements[7][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Dexterity), "" + Player.GetSkill(A.eSkills.Dexterity), "" + Player.GetSkill(A.eSkills.Dexterity)};

        statements[8][0][0] = "SKILL";
        statements[8][1] = columns;
        statements[8][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Flora), "" + Player.GetSkill(A.eSkills.Flora), "" + Player.GetSkill(A.eSkills.Flora)};

        statements[9][0][0] = "SKILL";
        statements[9][1] = columns;
        statements[9][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Fauna), "" + Player.GetSkill(A.eSkills.Fauna), "" + Player.GetSkill(A.eSkills.Fauna)};

        statements[10][0][0] = "SKILL";
        statements[10][1] = columns;
        statements[10][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Instincts), "" + Player.GetSkill(A.eSkills.Instincts), "" + Player.GetSkill(A.eSkills.Instincts)};


        statements[11][0][0] = "SKILL";
        statements[11][1] = columns;
        statements[11][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Instantanious), "" + Player.GetSkill(A.eSkills.Instantanious), "" + Player.GetSkill(A.eSkills.Instantanious)};

        statements[12][0][0] = "SKILL";
        statements[12][1] = columns;
        statements[12][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Intelligence), "" + Player.GetSkill(A.eSkills.Intelligence), "" + Player.GetSkill(A.eSkills.Intelligence)};

        statements[13][0][0] = "SKILL";
        statements[13][1] = columns;
        statements[13][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Lore), "" + Player.GetSkill(A.eSkills.Lore), "" + Player.GetSkill(A.eSkills.Lore)};

        statements[14][0][0] = "SKILL";
        statements[14][1] = columns;
        statements[14][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Lockpicking), "" + Player.GetSkill(A.eSkills.Lockpicking), "" + Player.GetSkill(A.eSkills.Lockpicking)};

        statements[15][0][0] = "SKILL";
        statements[15][1] = columns;
        statements[15][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Medicine), "" + Player.GetSkill(A.eSkills.Medicine), "" + Player.GetSkill(A.eSkills.Medicine)};

        statements[16][0][0] = "SKILL";
        statements[16][1] = columns;
        statements[16][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Materialization), "" + Player.GetSkill(A.eSkills.Materialization), "" + Player.GetSkill(A.eSkills.Materialization)};

        statements[17][0][0] = "SKILL";
        statements[17][1] = columns;
        statements[17][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Manipulation), "" + Player.GetSkill(A.eSkills.Manipulation), "" + Player.GetSkill(A.eSkills.Manipulation)};

        statements[18][0][0] = "SKILL";
        statements[18][1] = columns;
        statements[18][2] = new String[]{"" + A.GetSkillInt(A.eSkills.MagicProwess), "" + Player.GetSkill(A.eSkills.MagicProwess), "" + Player.GetSkill(A.eSkills.MagicProwess)};

        statements[19][0][0] = "SKILL";
        statements[19][1] = columns;
        statements[19][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Ritual), "" + Player.GetSkill(A.eSkills.Ritual), "" + Player.GetSkill(A.eSkills.Ritual)};

        statements[20][0][0] = "SKILL";
        statements[20][1] = columns;
        statements[20][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Restoration), "" + Player.GetSkill(A.eSkills.Restoration), "" + Player.GetSkill(A.eSkills.Restoration)};

        statements[21][0][0] = "SKILL";
        statements[21][1] = columns;
        statements[21][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Sword), "" + Player.GetSkill(A.eSkills.Sword), "" + Player.GetSkill(A.eSkills.Sword)};

        statements[22][0][0] = "SKILL";
        statements[22][1] = columns;
        statements[22][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Staff), "" + Player.GetSkill(A.eSkills.Staff), "" + Player.GetSkill(A.eSkills.Staff)};

        statements[23][0][0] = "SKILL";
        statements[23][1] = columns;
        statements[23][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Shield), "" + Player.GetSkill(A.eSkills.Shield), "" + Player.GetSkill(A.eSkills.Shield)};

        statements[24][0][0] = "SKILL";
        statements[24][1] = columns;
        statements[24][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Strength), "" + Player.GetSkill(A.eSkills.Strength), "" + Player.GetSkill(A.eSkills.Strength)};

        statements[25][0][0] = "SKILL";
        statements[25][1] = columns;
        statements[25][2] = new String[]{"" + A.GetSkillInt(A.eSkills.Social), "" + Player.GetSkill(A.eSkills.Social), "" + Player.GetSkill(A.eSkills.Social)};

        DB.InsertMultiple(statements);
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
                        InsertPlayerInDB();
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
