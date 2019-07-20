package com.example.asus.bookmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    SpannableString mSpannableString;
    TextView txtShow;
   Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShow=(TextView) findViewById(R.id.search_baidu);
      mSpannableString =new SpannableString(
                "打开百度,拨打电话,发送短信,发送邮件,发送彩信,打开地图");
        // 设置超链接 （需要添加setMovementMethod方法附加响应）
        mSpannableString.setSpan(new URLSpan("http://www.baidu.com"),0, 4,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       mSpannableString.setSpan(new URLSpan("tel:13756565654"),5, 9,
               Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 电话
        mSpannableString.setSpan(new URLSpan("sms:13756565654"),10, 14,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 短信 使用sms:或者smsto:
        mSpannableString.setSpan(new URLSpan("mailto:779878443@qq.com"),
                15,19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 邮件
       mSpannableString.setSpan(new URLSpan("mms:13756565654"),20, 24,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 彩信 使用mms:或者mmsto:
        mSpannableString.setSpan(new URLSpan("geo:38.899533,-77.036476"),25,
               29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 地图
        txtShow.setMovementMethod(LinkMovementMethod.getInstance());
        txtShow.setText(mSpannableString);
        but=(Button) findViewById(R.id.but_switch);
        but.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent inte=new Intent(this,Test_Activity.class);
        startActivity(inte);
    }


}
