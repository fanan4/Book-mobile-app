package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FaovoriteReadActivity2 extends AppCompatActivity {
    private RecyclerView FavoriteRecyclerView;
    private RecViewAdaprter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faovorite_read2);
        FavoriteRecyclerView=findViewById(R.id.FavoriteRecyclerView);
        adapter=new RecViewAdaprter(this,"Favorite");
        adapter.setBooks(Utils.getInstance(this).getFavoriteBooks());
        FavoriteRecyclerView.setAdapter(adapter);
        FavoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}