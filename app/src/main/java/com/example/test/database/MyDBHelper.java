package com.example.test.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MyDBHelper extends SQLiteOpenHelper {

    private Context context;
    public  MyDBHelper(Context context,String name, int version){
        super(context,name,null,version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table person(_id integer primary key autoincrement,name varchar,age int)";
        db.execSQL(sql);
        db.execSQL("insert into person(name ,age) values('Tom',18)");
        db.execSQL("insert into person(name ,age) values('Jack',19)");
        db.execSQL("insert into person(name ,age) values('Thoms',20)");
        Toast.makeText(context,"MyDBHelper onCreate()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
