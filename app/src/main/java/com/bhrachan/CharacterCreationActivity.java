package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        lbl_points.setText(skillPointsLeft);

        return true;
    }

    private void UncheckSkill()
    {
        skillPointsLeft++;
        lbl_points.setText(skillPointsLeft);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        skillPointsLeft = 5;

        lbl_points = (TextView) findViewById(R.id.lbl_skillPoints);

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

        CheckBox chk_skill_arcane = (CheckBox)findViewById(R.id.chk_skill_arcane);
        chk_skill_arcane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                boolean checked = ((CheckBox) view).isChecked();
            }
        });
    }
}
