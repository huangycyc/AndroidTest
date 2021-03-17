package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test.tools.BaseActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TesterActivity extends BaseActivity {

    private ImageView imageView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        imageView = (ImageView)findViewById(R.id.iv_test_image);
    }



    public void setBtnSave1(View view) {
        //实现将图片从assets资源文件夹中读取并保存到本机内部储存器中
        saveImge();
    }

    public void saveImge() {
        AssetManager manager = getAssets();
        InputStream is = null;
        FileOutputStream fos = null;
        String imageName = new String();
        imageName = "images_o.jpg";
        try {
            //采取边读边写的方式
            is =  manager.open(imageName);
            fos = openFileOutput(imageName, Context.MODE_PRIVATE);
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = is.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }
            Toast.makeText(this,"图片保存成功",Toast.LENGTH_SHORT).show();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public void setBtnLoad(View view) {
        //加载存储器中的图片，设置其为ImageView的图片来源
        String imageName = new String();
        imageName = "images_o.jpg";
        String filePath = getFilesDir().getAbsolutePath() +"/"+imageName;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        imageView.setImageBitmap(bitmap);
    }
}