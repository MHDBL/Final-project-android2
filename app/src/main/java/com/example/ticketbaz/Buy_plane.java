package com.example.ticketbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Buy_plane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_plane);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        CheckBox ch2 = findViewById(R.id.checkbox2);
        Button btn = findViewById(R.id.btnsabtnahaei);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch2.isChecked()) {
                    Intent intent = new Intent(Buy_plane.this,Final_signup.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Buy_plane.this, "لطفا در صورت پذیرش قوانین تیک موافقت با قوانین را بزنید", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}