package com.example.lilinghua.edanunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lilinghua on 2018/7/23.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast tot = Toast.makeText(
                        SecondActivity.this,
                        "跳到第一个界面",
                        Toast.LENGTH_LONG);
                tot.show();
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}