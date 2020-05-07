package com.example.sqlandroidproject.outil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLOpenHelper extends SQLiteOpenHelper {


    // Constructor
    public MySQLOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super ( context, name, factory, version );
    }

// Si changement de base
    @Override
    public void onCreate(SQLiteDatabase db) {

        String creationBdd = "create table user ("
                + "firstName VARCHAR (25) NOT NULL, "
                + "lastName VARCHAR (25) NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "job VARCHAR (25) NOT NULL);";

        db.execSQL ( creationBdd );
    }

// Si changement de version (Pas besoin)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
