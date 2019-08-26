package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
                    //TODO go to next activity
                }
                else
                {
                    //TODO output message remaining skill points
                }
            }
        });

        View.OnClickListener chk_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();

                if(checked)
                {
                    CheckSkill();
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
