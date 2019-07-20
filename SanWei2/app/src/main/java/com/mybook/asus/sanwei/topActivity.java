package com.mybook.asus.sanwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class topActivity extends AppCompatActivity {
    ImageButton btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        btn= (ImageButton) findViewById(R.id.zhanghu);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(topActivity.this , topActivity.class);
                startActivity(i);
            }
        });
    }
}
