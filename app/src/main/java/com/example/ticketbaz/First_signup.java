package com.example.ticketbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class First_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_signup);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        Button btn_sabt =findViewById(R.id.btnsabt);
        EditText Username = findViewById(R.id.Username);
        EditText Paassword = findViewById(R.id.Password);
        EditText Name = findViewById(R.id.Name);
        EditText Family = findViewById(R.id.Family);

        FloatingActionButton goback = findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(First_signup.this, MainActivity.class);
                startActivity(back);
            }
        });
        FloatingActionButton gonext =findViewById(R.id.gonext);
        gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next =new Intent(First_signup.this,Second_signup.class);
                startActivity(next);
            }
        });
        btn_sabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =Username.getText().toString().trim();
                String password=Paassword.getText().toString().trim();
                String name=Name.getText().toString().trim();
                String family=Family.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || name.isEmpty() || family.isEmpty()){
                    Toast.makeText(First_signup.this, "لطفا تمام فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences =getSharedPreferences("Mydb",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.apply();
                    Toast.makeText(First_signup.this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}