package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadActivity2 extends AppCompatActivity {
    private RecyclerView recyclerViewCurrently;
    private RecViewAdaprter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_read2);
        recyclerViewCurrently=findViewById(R.id.CurrentRecyclerView);
        adapter= new RecViewAdaprter(this,"CurrentlyReadingBook");
        adapter.setBooks(Utils.getInstance(this).getCurrentlyReadingBooks());
        recyclerViewCurrently.setAdapter(adapter);
        recyclerViewCurrently.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
    }
