package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class forminfo implements CompoundButton.OnCheckedChangeListener {

    private Activity activity;
    private EditText editText_email;
    private EditText editText_name;
    private EditText getEditText_phone;
    private CheckBox checkBox;
    private Button button;
    public forminfo(Activity activity){
        this.activity=activity;
        ini();


    }

    private void ini() {
        editText_email=activity.findViewById(R.id.email);
        editText_name=activity.findViewById(R.id.name);
        getEditText_phone=activity.findViewById(R.id.PHONE);
        button=activity.findViewById(R.id.btnsubmit);
        checkBox=activity.findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText_name.getText().toString().trim();
                String email=editText_email.getText().toString().trim();
                String phone=getEditText_phone.getText().toString().trim();
               if(isvalid(name,email, phone)) {

                   Toast.makeText(activity, "Accept", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(activity,Main4Activity.class);
                   intent.putExtra("name",name);
                   intent.putExtra("email",email);



                   activity.startActivity(intent);
               }
            }


            private boolean isvalid(String name,String email,String phone) {
                if(name.length()<3) {
                    Toast.makeText(activity, "name isvalid", Toast.LENGTH_SHORT).show();
                    editText_name.requestFocus();
                    return false;
                }
                    if(!email.contains("@") && !email.contains(".")){
                        Toast.makeText(activity, "email isvalid", Toast.LENGTH_SHORT).show();
                        editText_email.requestFocus();
                    return false;}
                    if(phone.length()!=11 && !phone.isEmpty()){

                        Toast.makeText(activity, "phone isvalid", Toast.LENGTH_SHORT).show();
                        getEditText_phone.requestFocus();
                   return false;}

                    return true;
            }

        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId()==R.id.checkBox){
            getEditText_phone.setEnabled(isChecked);

            }
        }
    }

