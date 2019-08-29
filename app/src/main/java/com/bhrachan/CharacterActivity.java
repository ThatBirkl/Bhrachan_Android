package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bhrachan.Items.Clothing;
import com.bhrachan.Items.Weapon;

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

        Button btn_primWpn = (Button) findViewById(R.id.btn_primWpn);
        final Weapon prim = Player.GetPrimaryWeapon();
        if(prim == null)
        {
            btn_primWpn.setText("<Main Hand>");
        }
        else
        {
            btn_primWpn.setText(prim.GetName());
        }
        btn_primWpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                A.SetImage("type", A.eItemType.weapon);
                A.SetImage("item", prim);
                //TODO open activity and load the data there
            }
        });

        Button btn_secWpn = (Button) findViewById(R.id.btn_secWpn);
        final Weapon sec = Player.GetSecondaryWeapon();
        if(sec == null)
        {
            btn_secWpn.setText("<Off Hand>");
        }
        else
        {
            btn_secWpn.setText(sec.GetName());
        }

        Button btn_hat = (Button) findViewById(R.id.btn_hat);
        Clothing hat = Player.GetHat();
        if(hat == null)
        {
            btn_hat.setText("<Head>");
        }
        else
        {
            btn_hat.setText(hat.GetName());
        }

        Button btn_shirt = (Button) findViewById(R.id.btn_shirt);
        Clothing shirt = Player.GetShirt();
        if(shirt == null)
        {
            btn_shirt.setText("<Chest>");
        }
        else
        {
            btn_shirt.setText(shirt.GetName());
        }

        Button btn_pants = (Button) findViewById(R.id.btn_pants);
        Clothing pants = Player.GetPants();
        if(pants == null)
        {
            btn_pants.setText("<Legs>");
        }
        else
        {
            btn_pants.setText(pants.GetName());
        }

        Button btn_boots = (Button) findViewById(R.id.btn_boots);
        Clothing boots = Player.GetBoots();
        if(boots == null)
        {
            btn_boots.setText("<Feet>");
        }
        else
        {
            btn_boots.setText(boots.GetName());
        }
    }
}
