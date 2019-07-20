package com.example.administrator.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity implements View.OnClickListener{
    EditText rmb,other;
    float dollar=0.1f,euro=100,won=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        rmb = (EditText)findViewById(R.id.editRMB);
        other = (EditText)findViewById(R.id.editOther);
        ((Button)findViewById(R.id.btn_dollar)).setOnClickListener(this);
        (findViewById(R.id.btn_euro)).setOnClickListener(this);
        findViewById(R.id.btn_won).setOnClickListener(this);
        findViewById(R.id.btn_set_rate).setOnClickListener(this);

        SharedPreferences sp= getSharedPreferences("rate", Activity.MODE_PRIVATE);
        dollar = sp.getFloat("sp_key_dollar",0.22f);
        euro = sp.getFloat("sp_key_euro",0.33f);
        won = sp.getFloat("sp_key_won",0.44f);

        Log.i("onCreate" ,"get rate:" + dollar);
        Log.i("onCreate" ,"get rate:" + euro);
        Log.i("onCreate" ,"get rate:" + won);

        Log.i("Rate","OnCreate方法执行完成");
    }

    @Override
    public void onClick(View btn) {
        if(btn.getId()==R.id.btn_set_rate){
            Intent rateIntent = new Intent(this,ConfigActivity.class);
            rateIntent.putExtra("key_dollar",dollar);
            rateIntent.putExtra("key_euro",euro);
            rateIntent.putExtra("key_won",won);
            //startActivity(rateIntent);
            startActivityForResult(rateIntent,1);
        }else{
            String rmbTxt = rmb.getText().toString();
            if(rmbTxt!=null && rmbTxt.length()>0){
                float cny = Float.parseFloat(rmbTxt);
                if(btn.getId()==R.id.btn_dollar){
                    Log.i("Rate","btn_dollar......");
                    other.setText((cny*dollar)+"");
                }else if(btn.getId()==R.id.btn_euro){
                    Log.i("Rate","btn_euro......");
                    other.setText(String.valueOf(cny*euro));
                }else if(btn.getId()==R.id.btn_won){
                    Log.i("Rate","btn_won......");
                    other.setText((cny*won)+"");
                }
            }else{
                Toast.makeText(this, "请输入数据", Toast.LENGTH_SHORT).show();
            }
        }

        Log.i("Rate","onClick......");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("Rate","onActivityResult......");
        Log.i("Rate","onActivityResult....requestCode.." + requestCode);
        Log.i("Rate","onActivityResult....resultCode.." + resultCode);
        if(requestCode==1 && resultCode==2){
            Bundle bdl = data.getExtras();
            dollar = bdl.getFloat("key_dollar_ret");
            euro = bdl.getFloat("key_euro_ret");
            won = bdl.getFloat("key_won_ret");
            Log.i("rate" ,"get return rate:" + dollar);
            Log.i("rate" ,"get return rate:" + euro);
            Log.i("rate" ,"get return rate:" + won);
            Toast.makeText(this, "数据已更新", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
