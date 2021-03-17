package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactsMainActivity extends AppCompatActivity {
    private EditText etContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_main);
        initView();
    }

    public void initView(){
        etContact = findViewById(R.id.et_contact);
    }
    public void openContactsList(View view) {
        startActivityForResult(new Intent(ContactsMainActivity.this,
                ContactsListActivity.class),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK){
            String reslut = data.getStringExtra("msg");
            etContact.setText(reslut);
        }else {
            etContact.setText("没有联系人信息");
        }
    }
}