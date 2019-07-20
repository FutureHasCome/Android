package com.example.administrator.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * 这是一个配置汇率的页面
 */
public class ConfigActivity extends AppCompatActivity {

    EditText rateDollar,rateEuro,rateWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        rateDollar = (EditText)findViewById(R.id.rate_dollar);
        rateEuro = (EditText)findViewById(R.id.rate_euro);
        rateWon = (EditText)findViewById(R.id.rate_won);
        float dollar2 = getIntent().getFloatExtra("key_dollar",0.1f);
        float euro2 = getIntent().getFloatExtra("key_euro",0.2f);
        float won2 = getIntent().getFloatExtra("key_won",0.3f);
        Log.i("cfg","get rate1:" + dollar2);
        Log.i("cfg","get rate2:" + euro2);
        Log.i("cfg","get rate3:" + won2);
        rateDollar.setText("" + dollar2);
        rateEuro.setText("" + euro2);
        rateWon.setText("" + won2);
    }

    public void onSave(View btn) {
        float newDollar = Float.parseFloat(rateDollar.getText().toString());
        float newEuro = Float.parseFloat(rateEuro.getText().toString());
        float newWon = Float.parseFloat(rateWon.getText().toString());

        //写入到SharedPreferences里
        SharedPreferences sp = getSharedPreferences("rate", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("sp_key_dollar",newDollar);
        editor.putFloat("sp_key_euro",newEuro);
        editor.putFloat("sp_key_won",newWon);
        editor.apply();


        Intent retIntent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putFloat("key_dollar_ret",newDollar);
        bdl.putFloat("key_euro_ret",newEuro);
        bdl.putFloat("key_won_ret",newWon);
        retIntent.putExtras(bdl);
        setResult(2,retIntent);

        Log.i("cfg","onSave called.......");
        finish();
    }

}
