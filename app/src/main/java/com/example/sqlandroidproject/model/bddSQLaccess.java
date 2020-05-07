package com.example.sqlandroidproject.model;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlandroidproject.outil.MySQLOpenHelper;

public class bddSQLaccess {
    private String bddName = "myBddTest.sqlite";
    private Integer versionBase = 1;
    private MySQLOpenHelper bddAccess;
    private SQLiteDatabase bd;

    public bddSQLaccess(Context context){
        bddAccess = new MySQLOpenHelper ( context, bddName, null, versionBase );
    }

    public void ajout( User user ){
        bd = bddAccess.getWritableDatabase ();
        String request = "insert into user (firstName, lastName, age, job) values ";
        request += "(\"" + user.getFirstName () + "\",\"" + user.getLastName () + "\"," + user.getAge () + ",\"" + user.getJob () + "\")";
        bd.execSQL ( request );
    }
    public User recupLastInput(){
        bd = bddAccess.getReadableDatabase ();
        User user = null;
        String request = "select * from user";
        Cursor cursor = bd.rawQuery ( request, null );
        cursor.moveToLast ();
        if(!cursor.isAfterLast ()){
            String firstName = cursor.getString ( 0 );
            String lastName = cursor.getString ( 1 );
            int age = cursor.getInt ( 2 );
            String job = cursor.getString ( 3 );

            user = new User ( firstName, lastName, age, job );
        }
        cursor.close ();
        return user;
    }
}
