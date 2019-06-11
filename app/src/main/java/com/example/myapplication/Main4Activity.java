package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle extras=getIntent().getExtras();
        if(!extras.isEmpty()){
            String name="";
            String email=""
                    ,phone="";
           if(extras.containsKey("name")){
               name=extras.getString("name");
           }
           if(extras.containsKey("email")){
               email=extras.getString("email");
           }
            if(extras.containsKey("phone")){
              phone= extras.getString("phone");
            }
            TextView textView=findViewById(R.id.tv4);
            textView.setText("name:"+name+"\n");
            textView.append("email:"+email+"\n");
            textView.append("phone:"+phone+"\n");

        }
    }
}
