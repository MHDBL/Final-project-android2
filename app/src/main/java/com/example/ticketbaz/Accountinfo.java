package com.example.ticketbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Accountinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinfo);

        ImageView im2=findViewById(R.id.gotomain);
        ImageView im1 =findViewById(R.id.Quit);
        TextView username=findViewById(R.id.NameandFamily);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Accountinfo.this,Page01.class);
                startActivity(i);
                finish();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("Mydb", Context.MODE_PRIVATE);
        String savedusername = sharedPreferences.getString("username", "admin");
        username.setText(savedusername +" "+"خوش آمدید");
    }
}