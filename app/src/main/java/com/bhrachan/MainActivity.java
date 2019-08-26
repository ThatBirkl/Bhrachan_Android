package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!UTIL.HasAliveCharacter())
        {
            MainActivity.this.startActivity(new Intent(MainActivity.this, CharacterCreationActivity.class));
        }
        else
        {

        }
    }
}