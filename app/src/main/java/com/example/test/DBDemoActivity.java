package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import  com.example.test.database.MyDBHelper;
import com.example.test.tools.BaseActivity;

public class DBDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_demo);
    }

    public void createDB(View view) {
        MyDBHelper helper = new MyDBHelper(this, "mydb.db", 1);
        SQLiteDatabase db = helper.getReadableDatabase();
    }

    public void insertData(View view) {
        MyDBHelper helper = new MyDBHelper(this, "mydba.db", 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "LiLei");
        contentValues.put("age", 20);
        long id = db.insert("person", null, contentValues);
        db.close();
        Toast.makeText(this, "id" + id, Toast.LENGTH_SHORT).show();
    }

    public void updataData(View view) {
        MyDBHelper helper = new MyDBHelper(this, "mydba.db", 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "HanMeiMei");
        contentValues.put("age", 21);
        int rows = db.update("person", contentValues, "name = ?", new String[]{"Tom"});
        db.close();
        Toast.makeText(this, "rows" + rows, Toast.LENGTH_SHORT).show();
    }

    public void deleteData(View view) {
        MyDBHelper helper = new MyDBHelper(this, "mydba.db", 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        int rows = db.delete("person", "id = ?", new String[]{"2"});
        db.close();
        Toast.makeText(this, "rows" + rows, Toast.LENGTH_SHORT).show();
    }


    public void queryData(View view) {
        MyDBHelper helper = new MyDBHelper(this, "mydba.db", 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("person", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                Log.d("TAG", name + ":" + age);
            } while (cursor.moveToNext());
            db.close();
        }
    }
}