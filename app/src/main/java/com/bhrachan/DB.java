package com.bhrachan;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class DB
{
    private static DB_Interface helper;

    public static void Init(Context _context)
    {
        helper = new DB_Interface(_context);
        CheckAndCreateDatabase();
        //TODO check if database has the correct version (if not => upgrade it)
    }

    private static void CheckAndCreateDatabase()
    {
        //TODO check if there is a database at the specified path (if no => make it)
        if(!helper.DatabaseExists())
        {
            helper.CreateDatabase();
        }
        else
        {
            helper.OpenDatabase();
        }
    }

    public static void Insert(String _tableName, String[] _columns, String[] _values)
    {
        String command = "insert into " + _tableName + "(\n";
        String[] types = GetTypes(_tableName, _columns);


        for(int i = 0; i < _columns.length - 1; i++)
        {
            command += _columns[i] + ", ";
        }
        command += _columns[_columns.length - 1] + ")\nvalues(\n";

        for(int i = 0; i < _columns.length - 1; i++)
        {
            command += "CAST('" + _values[i] + "' as " + types[i] + "), ";
        }
        command += "CAST('" + _values[_columns.length - 1] + "' as " + types[_columns.length - 1] + ")";
        command += ")";

        helper.Execute(command);
    }

    public static void InsertMultiple(String[][][] _statements)
    {
        for(int i = 0; i < _statements.length; i++)
        {
            DB.Insert(_statements[i][0][0], //tablename
                    _statements[i][1], //columns
                    _statements[i][2] //values
                     );
        }
    }

    public static String[] GetTypes(String _tableName, String[] _columns)
    {
        String[][] all = helper.Get("PRAGMA table_info(" + _tableName + ")");
        String[] ret = new String[_columns.length];
        for(int i = 0; i < _columns.length; i++)
        {
            for(int j = 0; j < all.length; j++)
            {
                if(_columns[i].equals(all[j][1]))
                {
                    ret[i] = all[j][2];
                    j = all.length;
                }
            }
        }
        return ret;
    }

    public static String[] GetNames(String _tableName)
    {
        String[][] all = helper.Get("PRAGMA table_info(" + _tableName + ")");
        String[] ret = new String[all.length];
        for(int j = 0; j < all.length; j++)
        {
            ret[j] = all[j][1];
        }
        return ret;
    }

    public static void Delete(String _tableName, String _condition)
    {
        helper.Execute("delete from " + _tableName + " where " + _condition);
    }

    public static void Update(String _tableName, String[] _columns, String[] _values, String _condition)
    {
        String[] types = GetTypes(_tableName, _columns);

        String command = "update " + _tableName + "\n" +
                        "set ";
        for(int i = 0 ; i < _columns.length - 1; i++)
        {
            command += _columns[i] + " = CAST('" + _values[i] + "' as " + types[i] + "),\n";
        }
        command += _columns[_columns.length - 1] + " = CAST('" + _values[_columns.length - 1] + "' as " + types[_columns.length - 1] + ")\n";
        command += "where " + _condition;

        helper.Execute(command);
    }

    public static void UpdateMultiple(String[][][] _statements)
    {
        for(int i = 0; i < _statements.length; i++)
        {
            DB.Update(_statements[i][0][0], //tablename
                    _statements[i][1], //columns
                    _statements[i][2], //values
                    _statements[i][3][0] //condition
            );
        }
    }

    public static String[][] Table(String _query)
    {
        return helper.Get(_query);
    }

    public static String Cell(String _query)
    {
        String[][] d = helper.Get(_query);
        if(d.length == 0)
            return "";

        if(d[0].length == 0)
            return "";

        return d[0][0];
    }
}
