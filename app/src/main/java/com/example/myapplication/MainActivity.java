package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.UserHandle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    TextView textView;
    public final int req_cod=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button23=findViewById(R.id.button);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivityForResult(intent,req_cod);
            }
        });

        Button button2=findViewById(R.id.button2);
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               textView=findViewById(R.id.textView);
               Random random=new Random();
               textView.setTextColor(Color.rgb(random.nextInt(111),random.nextInt(222),random.nextInt(255)));

           }
       });
        button2.setOnLongClickListener(this);

        Toast.makeText(this, "on creat", Toast.LENGTH_SHORT).show();
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Hello").setNeutralButton("Cancel",null).setPositiveButton("yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Intent intent=new Intent(this,Main2Activity.class);

                textView.setText("yes");
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
        builder.setSingleChoiceItems(new String[]{"saeed", "mahdi"}, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    AlertDialog.Builder builder1=new AlertDialog.Builder(MainActivity.this);
                    builder1.setSingleChoiceItems(new String[] {"Hossein","Ali"},1,null);
                    builder1.setTitle("ssss").setPositiveButton("ok",null);
                    builder1.show();

                }
                else{
                    Toast.makeText(MainActivity.this,getTitle().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
        Button button=findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(v.getId()==R.id.button2) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

               return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==req_cod){

        }
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "on resume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.button2){
            textView.setText("long click");
        }
        return false;
    }
}
