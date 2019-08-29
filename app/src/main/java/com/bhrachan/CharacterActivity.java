package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CharacterActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        TextView lbl_name = (TextView) findViewById(R.id.lbl_name);
        lbl_name.setText(Player.GetName());

        TextView lbl_race = (TextView) findViewById(R.id.lbl_race);
        lbl_race.setText(A.GetRaceString(Player.GetRace()));
    }
}
