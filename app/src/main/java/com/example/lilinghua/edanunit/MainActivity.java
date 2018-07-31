package com.example.lilinghua.edanunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new BtnListener());
    }

    class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast tot = Toast.makeText(
                    MainActivity.this,
                    "跳到第二个界面",
                    Toast.LENGTH_LONG);
            tot.show();
            //新建一个Intent对象
            Intent intent = new Intent();
            //指定intent要启动的类
            intent.setClass(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            //关闭当前Activity
            finish();
        }
    }
}
//        btn1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast tot = Toast.makeText(
//                        MainActivity.this,
//                        "Welcomto Edan",
//                        Toast.LENGTH_LONG);
//                tot.show();
//            }
//        });

