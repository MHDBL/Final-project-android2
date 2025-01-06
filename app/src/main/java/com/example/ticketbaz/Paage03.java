package com.example.ticketbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Paage03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paage03);

        ImageView im01 = findViewById(R.id.film);
        ImageView im02 = findViewById(R.id.Cinema);

        EditText edtmoviname = findViewById(R.id.Edtfilmnamae);
        EditText edtradif = findViewById(R.id.Edtradif);
        EditText edtsandali = findViewById(R.id.Edtsandali);
        ImageView img03 = findViewById(R.id.menuicon);
        ImageView img04 = findViewById(R.id.goprofile);

        im02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(Paage03.this, Page01.class);
                startActivity(in1);
                finish();
            }
        });
        im01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(Paage03.this, Page02.class);
                startActivity(in2);
                finish();
            }
        });

        CheckBox ch1 = findViewById(R.id.checkBox);
        Button btn = findViewById(R.id.btnsabt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String moviname = edtmoviname.getText().toString().trim();
                String radif=edtradif.getText().toString().trim();
                String sandali=edtsandali.getText().toString().trim();
                if (ch1.isChecked()) {
                    Intent intent = new Intent(Paage03.this, Page04.class);

                    intent.putExtra("filmname", moviname);
                    intent.putExtra("radif", radif);
                    intent.putExtra("sandali", sandali);

                    startActivity(intent);
                    Toast.makeText(Paage03.this, "خرید شما با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Paage03.this, "قبل از خرید قوانین را مطالعه کنید", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(Paage03.this, img03);
                menu.getMenu().add("صفحه اصلی");
                menu.getMenu().add("خرید بلیط");
                menu.getMenu().add("خروج از حساب کاربری");
                menu.getMenu().add("خروج از برنامه");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getTitle().toString()) {
                            case "صفحه اصلی":
                                Intent gomain = new Intent(Paage03.this, Page01.class);
                                startActivity(gomain);
                                break;

                            case "خرید بلیط":
                                Intent buyticket = new Intent(Paage03.this, Paage03.class);
                                startActivity(buyticket);
                                break;

                            case "خروج از حساب کاربری":
                                Intent logout = new Intent(Paage03.this, MainActivity.class);
                                startActivity(logout);
                                break;

                            case "خروج از برنامه":
                                System.exit(0);
                        }
                        return true;
                    }
                });
                menu.show();
                ;
            }
        });
        img04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goprofile=new Intent(Paage03.this,Accountinfo.class);
                startActivity(goprofile);
                finish();
            }
        });
    }
}