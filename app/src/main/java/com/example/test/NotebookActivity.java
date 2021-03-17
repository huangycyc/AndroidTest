package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.tools.BaseActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotebookActivity extends BaseActivity {
    private Button btnSave;
    private EditText etContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);
        etContent = findViewById(R.id.et_tester_content);
        String str =load();
        if (!TextUtils.isEmpty(str)){
            etContent.setText(str);
            Toast.makeText(this,"文件加载成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void saveFile(View view) {
        //保存文本框中俄的文本，以文件的方式保存在内部存储器中
        save(etContent.getText().toString());
    }

    /**
     *
     * @return
     */
    public String load(){
        FileInputStream fileInputStream = null;
        BufferedReader reader =null;
        StringBuilder content = new StringBuilder();
        try {
            fileInputStream = openFileInput("note.text");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String str;
            while ((str=reader.readLine())!=null){
                content.append(str);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
     return content.toString();
    }
    public void save(String str){
        FileOutputStream fos = null;
        BufferedWriter writer =null;
        try {
            fos = openFileOutput("note.text", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(fos));
            //写入到的目标目录是 /data/data/packagename/files/note.text
            writer.write(str);
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
