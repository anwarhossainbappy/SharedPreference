package com.example.bappy_cox.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1,e2;
    Button b1,b2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.usernameId);
        e2=findViewById(R.id.passwordId);

        b1=findViewById(R.id.savebuttonId);
        b2=findViewById(R.id.loadbuttonId);
        textView=findViewById(R.id.resultshow);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.savebuttonId){
            String username  = e1.getText().toString();
            String password = e2.getText().toString();

            if (username.equals("") && password.equals("")){
                Toast.makeText(getApplicationContext(),"Please Enter Some Data",Toast.LENGTH_SHORT).show();
            }
            else {

                //To Write Data

                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
            }



        }
        else if (view.getId()==R.id.loadbuttonId){
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("username") && sharedPreferences.contains("password")){
                //To Read Data
                String username = sharedPreferences.getString("username","Data not Found");
                String password = sharedPreferences.getString("password","Data not Found");

                textView.setText(username + "\n"+password);
            }
        }
    }
}
