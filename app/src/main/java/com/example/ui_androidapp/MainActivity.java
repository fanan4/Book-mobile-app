package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private  Button SeeAllBooks,AlreadyRead,CurrentlyRead,WishBooks,FavoriteBooks,About;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBtn();
        SeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AllBooks2.class);
                startActivity(intent);
            }
        });
        AlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AlreadyReadActivity2.class);
                startActivity(intent);
            }
        });
        CurrentlyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CurrentlyReadActivity2.class);
                startActivity(intent);
            }
        });
        WishBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WantReadBook2.class);
                startActivity(intent);
            }
        });
        FavoriteBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FaovoriteReadActivity2.class);
                startActivity(intent);
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("this application is developped by Abdelouahed under the orientation of Meisam" +
                        " please for more information please visit our web site");
                builder.setNegativeButton("Dismissed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity.this,webViewActivity2.class);
                        intent.putExtra("url","https://www.google.com/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });

    }
    public void initBtn(){
        SeeAllBooks=findViewById(R.id.allBooks);
        AlreadyRead=findViewById(R.id.AlreadyRead);
        CurrentlyRead=findViewById(R.id.CurrentBooks);
        WishBooks=findViewById(R.id.wishList);
        FavoriteBooks=findViewById(R.id.favoriteList);
        About=findViewById(R.id.about);
      }
}