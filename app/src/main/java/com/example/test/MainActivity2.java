package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.test.tools.BaseActivity;

public class MainActivity2 extends BaseActivity {


    private  Button btn_tester =null;
    private  Button btn_remember_password_demo = null;
    private Button btn_DBDemo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button3 = findViewById(R.id.button3);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        btn_tester = (Button)findViewById(R.id.btn_tester);
        btn_remember_password_demo = (Button) findViewById(R.id.btn_remember_password_demo);
        btn_DBDemo = findViewById(R.id.btn_DBDemo);
        TextView textView =(TextView)findViewById(R.id.textView);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this,"You click Button4",Toast.LENGTH_SHORT).show();
                textView.setText(data);
//                Log.d(data, "onCreate: MainActivity2");
            }
        });
        Button buttonVideo = (Button)findViewById(R.id.buttonVideo);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent1);
            }
        });

        Button buttonBaidu = (Button)findViewById(R.id.buttonBaidu);
        buttonBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBaidu = new Intent(Intent.ACTION_VIEW);
                intentBaidu.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intentBaidu);
            }
        });

        Button buttonUi = findViewById(R.id.buttonUi);
        buttonUi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUi = new Intent(MainActivity2.this,Ui.class);
                startActivity(intentUi);
            }
        });
        Button buttonLocalMusic = (Button) findViewById(R.id.buttonLocalMusic);
        buttonLocalMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLocalMusic = new Intent(MainActivity2.this,LocalMusic.class);
                startActivity(intentLocalMusic);
            }
        });

        Button btn_notebook = (Button)findViewById(R.id.btn_notebook);
        btn_notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_notebook = new Intent(MainActivity2.this,NotebookActivity.class);
                startActivity(intent_notebook);
            }
        });

        btn_tester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tester = new  Intent(MainActivity2.this,TesterActivity.class);
                startActivity(intent_tester);
            }
        });
        btn_remember_password_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_remember_psw = new Intent(MainActivity2.this,RememberPasswordDemoActivity.class);
                startActivity(intent_remember_psw);
            }
        });
        btn_DBDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_DBDemo = new Intent(MainActivity2.this,DBDemoActivity.class);
                startActivity(intent_DBDemo);
            }
        });
    }

    /**
     * 打开广播测试
     * @param view
     */
    public void openBroadCast(View view) {
        Intent intent_MyBroadcast = new Intent(MainActivity2.this,MyBroadcastActivity.class);
        startActivity(intent_MyBroadcast);
    }

    /**
     * 进入读取本机联系人功能
     * @param view
     */
    public void readContacts(View view) {
        Intent intentContacts = new Intent(MainActivity2.this,ContactsMainActivity.class);
        startActivity(intentContacts);
    }
}