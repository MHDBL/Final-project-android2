package com.example.ticketbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Page02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page02);

        ImageView im01 =findViewById(R.id.Cinema);
        ImageView im02 =findViewById(R.id.Ticket);
        ImageView img03 = findViewById(R.id.menuicon);
        ImageView img04 = findViewById(R.id.goprofile);

        im01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 =new Intent(Page02.this,Page01.class);
                startActivity(in1);
                finish();
            }
        });

        im02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 =new Intent(Page02.this,Paage03.class);
                startActivity(in2);
                finish();
            }
        });
        img03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(Page02.this, img03);
                menu.getMenu().add("صفحه اصلی");
                menu.getMenu().add("خرید بلیط");
                menu.getMenu().add("خروج از حساب کاربری");
                menu.getMenu().add("خروج از برنامه");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getTitle().toString()) {
                            case "صفحه اصلی":
                                Intent gomain = new Intent(Page02.this, Page01.class);
                                startActivity(gomain);
                                break;

                            case "خرید بلیط":
                                Intent buyticket = new Intent(Page02.this, Paage03.class);
                                startActivity(buyticket);
                                break;

                            case "خروج از حساب کاربری":
                                Intent logout = new Intent(Page02.this, MainActivity.class);
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
                Intent goprofile=new Intent(Page02.this,Accountinfo.class);
                startActivity(goprofile);
                finish();
            }
        });
    }
}