package com.bhrachan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_Interface extends SQLiteOpenHelper
{
    private static final int db_version = 1;
    private static final String db_name = "bhrachan.db";
    private static SQLiteDatabase db;
    private static Context context;

    public DB_Interface(Context _context)
    {
        super(_context, db_name, null, db_version);
        context = _context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public boolean DatabaseExists()
    {
        String path = "";
        return UTIL.FileExists(context.getDatabasePath(db_name).getPath());
    }

    public void CreateDatabase()
    {
        db = SQLiteDatabase.openOrCreateDatabase(context.getDatabasePath(db_name).getPath(), null);

        db.execSQL("create table CHARACTER\n" +
                "(\n" +
                "  CHARACTERID TEXT(36) NOT NULL PRIMARY KEY,\n" +
                "  CURRENT_HP INTEGER NOT NULL,\n" +
                "  MAX_HP INTEGER NOT NULL,\n" +
                "  CURRENT_EP INTEGER NOT NULL,\n" +
                "  MAX_EP INTEGER NOT NULL,\n" +
                "  RACE INTEGER NOT NULL,\n" +
                "  NAME TEXT NOT NULL,\n" +
                "  HD INTEGER NOT NULL,\n" +
                "  ED INTEGER NOT NULL,\n" +
                "  MAINHAND_ID TEXT(36) NOT NULL,\n" +
                "  OFFHAND_ID TEXT(36) NOT NULL,\n" +
                "  HAT_ID TEXT(36) NOT NULL,\n" +
                "  SHIRT_ID TEXT(36) NOT NULL,\n" +
                "  PANTS_ID TEXT(36) NOT NULL,\n" +
                "  BOOTS_ID TEXT(36) NOT NULL,\n" +
                "  LEVEL INTEGER NOT NULL\n" +
                ")");

        db.execSQL("create table CHARACTER_DEAD\n" +
                "(\n" +
                "  CHARACTER_DEADID TEXT(36) NOT NULL PRIMARY KEY,\n" +
                "  RACE INTEGER NOT NULL,\n" +
                "  NAME TEXT NOT NULL\n" +
                ")");

        db.execSQL("create table SKILL\n" +
                "(\n" +
                "  SKILLID INTEGER NOT NULL PRIMARY KEY,\n" +
                "  PROGRESS NUMBER NOT NULL,\n" +
                "  LEVEL INTEGER NOT NULL\n" +
                ")");

        db.execSQL("create TABLE ITEM\n" +
                "(\n" +
                "  ITEMID TEXT(36) NOT NULL PRIMARY KEY,\n" +
                "  ITEM_TYPE INTEGER NOT NULL,\n" +
                "  EQUIPPED BOOLEAN NOT NULL,\n" +
                "  OBJECT BLOB NOT NULL\n" +
                ")");
    }

    public void Execute(String _command)
    {
        db.execSQL(_command);
    }

    public String[][] Get(String _query)
    {
        Cursor c = db.rawQuery(_query, null);
        String[][] ret = new String[c.getCount()][c.getColumnCount()];
        if(c.moveToFirst())
        {
            for(int row = 0 ; row < ret.length; row++)
            {

                for(int column = 0 ; column < ret[row].length; column++)
                {
                    ret[row][column] = c.getString(column);
                }
                c.moveToNext();
            }
        }
        return ret;
    }

    public void OpenDatabase()
    {
        db = SQLiteDatabase.openDatabase(context.getDatabasePath(db_name).getPath(), null, 0);
    }
}
