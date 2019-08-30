package com.bhrachan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bhrachan.Items.Item;

public class ItemActivity extends AppCompatActivity
{
    //accessible images:
    //type
    //item
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        if(A.ImageExists("item"))
        {
            item = (Item)A.GetImage("item");
        }

        TextView lbl_asciiArt = (TextView) findViewById(R.id.lbl_asciiArt);
        lbl_asciiArt.setText(A.GetItemArt(item));

    }
}
