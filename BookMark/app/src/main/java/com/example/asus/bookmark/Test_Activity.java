package com.example.asus.bookmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Test_Activity extends AppCompatActivity implements View.OnClickListener{
     TextView txtShow;
    CharSequence charSequence;
    Button but;
    EditText text1,text2;
    String html5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_);
        String html ="<a style='text-decoration:none' href='http://www.baidu.com'>百度一下</a>";
        String html1 ="<a href='http://tv123.goudaitv.com/index.html'>一部影院</a>";
        String html2="<a href='http://202.115.115.133'>课程中心</a>";
        String html3="<a href='https://oamssl.swufe.edu.cn/oam/server/obrareq.cgi?encquery%3DyXAYpEeqFam9gFz6uXMRAAaoUU48%2FbufOAxeuxSuPDObuEwsPw34IqamQbPWunPwU9tZBNh0F3P0wplgHMqsi290TbClJ%2FJ3dAlyI2jG6SFBShIY9EhKWwiFumo8OgYGyQBcfPND1t5ot9DoNdbk6%2FV0e5H%2BGgoV2AX2EEKDa1kCMQ3UxpnbA9xTIGZPK41VpZjXquuL66PfyqWHPvsg76JWDkGYSTRFourJX%2F2KMFN786j82fkLuBmiMPvnJp%2BVHUSDOlyNdvdiY65HzFoUKiZcYx3apk8Uoo51qR6GgK8%3D%20agentid%3DOAMSSLWT1%20ver%3D1%20crmethod%3D2&ECID-Context=1.005HOjQesbn5MeX5xvh8iW0005tJ001iJG%3BkXjE" +
                "'>查成绩看课表</a>";
        charSequence = Html.fromHtml(html);
        txtShow=(TextView) findViewById(R.id.textView2);
        txtShow.setText(charSequence);
        txtShow.setMovementMethod(LinkMovementMethod.getInstance());
        charSequence = Html.fromHtml(html1);
        txtShow=(TextView) findViewById(R.id.textView3);
        txtShow.setText(charSequence);
        txtShow.setMovementMethod(LinkMovementMethod.getInstance());
        charSequence = Html.fromHtml(html2);
        txtShow=(TextView) findViewById(R.id.textView5);
        txtShow.setText(charSequence);
        txtShow.setMovementMethod(LinkMovementMethod.getInstance());
        charSequence = Html.fromHtml(html3);
        txtShow=(TextView) findViewById(R.id.textView6);
        txtShow.setText(charSequence);


        txtShow.setMovementMethod(LinkMovementMethod.getInstance());
    but=(Button) findViewById(R.id.but_set);
        but.setOnClickListener(this);
    text1= (EditText) findViewById(R.id.mark);
        text2= (EditText) findViewById(R.id.mark_url);
    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.but_set){
           String one=text1.getText().toString();
           System.out.print(one);
           String tuo=text2.getText().toString();
           if(one==null||tuo==null||one.length()==0||tuo.length()==0){
               Toast.makeText(this,"请输入数据",Toast.LENGTH_SHORT).show();
           }
           else{
               html5  ="<a  href='"+text2+">"+text1+"</a>";
               Log.i("",html5.toString());

               charSequence = Html.fromHtml(html5);
               txtShow=(TextView) findViewById(R.id.textView4);
               txtShow.setText(charSequence);
              
           }
       }
    }
}




