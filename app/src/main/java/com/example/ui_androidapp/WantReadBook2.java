package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class WantReadBook2 extends AppCompatActivity {
    private RecyclerView recyclerViewWantRead;
    private RecViewAdaprter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_read_book2);
        recyclerViewWantRead=findViewById(R.id.WantReadRecyclerView);
        adapter= new RecViewAdaprter(this,"WantToRead");
        adapter.setBooks(Utils.getInstance(this). getWantToReadBooks());
        recyclerViewWantRead.setAdapter(adapter);
        recyclerViewWantRead.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
}
