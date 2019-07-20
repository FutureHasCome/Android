package com.example.administrator.firstapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Runnable {

    TextView show;
    EditText inputw,inputh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.textView);
        inputw = (EditText)findViewById(R.id.input_w);
        inputh = (EditText)findViewById(R.id.input_h);
        Button btn = (Button)findViewById(R.id.btn_hello);
        findViewById(R.id.btn_open_rate).setOnClickListener(this);
        btn.setOnClickListener(this);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txt = input.getText().toString();
//                show.setText("Welcome " + txt);
//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        Log.i("TAG","5555555555555555555555 onClicked.........");
        if(v.getId()==R.id.btn_hello){

            show.setText("Hello " + inputw.getText().toString());
            Thread t = new Thread(this);
            t.start();


        }else{
            //open rate Activity
            Log.i("TAG","open.............");
            Intent rateIntent = new Intent(this,RateActivity.class);

            Uri uri = Uri.parse("http://www.baidu.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW,uri);

            startActivity(rateIntent);
        }
    }

    public void func(View v) {
        //BMI
        String txth = inputh.getText().toString();
        String txtw = inputw.getText().toString();
        Log.i("TAG","txth=" + txth + " txtw=" + txtw);
        if(txth!=null && txth.length()>0 && txtw!=null && txtw.length()>0){
            float h = Integer.parseInt(txth)/100f;
            float w = Float.parseFloat(txtw);
            float bmi = w/(h*h);
            Log.i("TAG","bmi=" + bmi);
            show.setText("BMI=" + bmi);
        }else{
            Toast.makeText(this, "请输入完整的数据", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void run() {

        Log.i("run","run..........");

        try {
            URL url = new URL("http://www.usd-cny.com/bankofchina.htm");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream input = http.getInputStream();
            Log.i("online","get Data........");

            final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));

            String html = inputstr2Str_ByteArrayOutputStream(input,"gb2312");
            //Log.i("online",html);

            Document doc = Jsoup.parse(html);
            Elements tables = doc.getElementsByTag("table");
            int i = 1;
            for(Element tb : tables){
                //Log.i("jsoup","tb["+(i++)+"]=" + tb);
            }
            Element table = tables.get(5);
            Elements tds = table.getElementsByTag("td");
            Log.i("tds","length" + tds.size());
            for(Element td : tds){
                Log.i("jsoup","td=" + td.text());
            }


            Log.i("JSOUP","DOLLAR=");




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String inputStream2String(InputStream   is)   throws   IOException{
        //final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), “gb2312”));
        ByteArrayOutputStream baos   =   new   ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
            baos.write(i);
        }
        return   baos.toString();
    }

    public static String inputstr2Str_ByteArrayOutputStream(InputStream in,String encode)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        try
        {
            if (encode == null || encode.equals(""))
            {
                // 默认以utf-8形式
                encode = "utf-8";
            }
            while ((len = in.read(b)) > 0)
            {
                out.write(b, 0, len);
            }
            return out.toString(encode);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
