package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AlreadyReadActivity2 extends AppCompatActivity {
    private RecyclerView recyclerViewAlready;
    private RecViewAdaprter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read2);
        recyclerViewAlready=findViewById(R.id.AlreadyReadRecyclerView);
        adapter= new RecViewAdaprter(this,"AlreadyRead");
        adapter.setBooks(Utils.getInstance(this). getAlreadyReadBooks());
        recyclerViewAlready.setAdapter(adapter);
        recyclerViewAlready.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(AlreadyReadActivity2.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
}