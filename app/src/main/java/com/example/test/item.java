package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class item extends AppCompatActivity {
    private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Strawberry","Cherry","Mango",
            "Apple","Banana","Orange","Watermelon","Pear","Grape","Strawberry","Cherry","Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                item.this, android.R.layout.simple_list_item_1,data);
        ListView listViewItem = (ListView) findViewById(R.id.list_view_item);
        listViewItem.setAdapter(adapter);
    }
}