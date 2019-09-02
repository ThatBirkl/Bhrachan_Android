package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    
    private void CreateCharacter()
    {
        MainActivity.this.startActivity(new Intent(MainActivity.this, CharacterCreationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        A.Init();
        DB.Init(this);

        //TODO remove this again once the creation is complete
        DB.Delete("CHARACTER", "CHARACTERID = 'test_id_replace'");
        DB.Delete("SKILL", "1 = 1");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_createChar = (Button)findViewById(R.id.btn_createChar);

        if(!UTIL.HasAliveCharacter())
        {
            btn_createChar.setVisibility(View.VISIBLE);
        }
        else
        {
            btn_createChar.setVisibility(View.GONE);
        }


        btn_createChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CreateCharacter();
                view.setVisibility(View.GONE);
            }
        });
    }
}
