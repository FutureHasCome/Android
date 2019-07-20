package com.mybook.asus.sanwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cover extends AppCompatActivity {

    Button but;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        but = (Button) findViewById(R.id.cover_but);
        but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(cover.this , LoginActivity.class);
                startActivity(i);
            }
        });
    }

}
