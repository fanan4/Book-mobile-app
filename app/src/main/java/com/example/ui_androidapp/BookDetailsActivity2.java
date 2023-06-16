package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookDetailsActivity2 extends AppCompatActivity {
    private ImageView BookImage;
    private Button CurrentRead,WantRead,AlreadyRead,Favorite;
    private TextView AuthorText,BookText,PagesNumber,DescText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        INIT();
        Intent intent=getIntent();
        if(intent!=null){
            int IdBook=intent.getIntExtra("BookId",-1);
            if(IdBook!=-1){
                Books incomingBook=Utils.getInstance(this). getBookID(IdBook);
                if(incomingBook!=null){
                    setData(incomingBook);
                    handleAlreadyBook(incomingBook);
                    handleWantReadBook(incomingBook);
                    handleCurrentlyReadBook(incomingBook);
                    handleFavoritesBook(incomingBook);
                }
            }
        }
    }
    //checking if incoming Books exist in AlreadyReadList in order to desabled the AlreadyRead BTtn
    //if it doesn't add it to the AlreadyReadyList
    public void handleAlreadyBook(Books book){
        ArrayList<Books> AlreadyBooks=Utils.getInstance(this).getAlreadyReadBooks();
        boolean ExistInAlreadyReadBook=false;
        for (Books b:AlreadyBooks){
            if(b.getId()==book.getId()){
                ExistInAlreadyReadBook=true;
            }
        }
        if(ExistInAlreadyReadBook){
            AlreadyRead.setEnabled(false);
        }
        else{
            AlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookDetailsActivity2.this).AddBookToAlreadyList(book)){
                        Toast.makeText(BookDetailsActivity2.this, "Book added", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(BookDetailsActivity2.this, "something went wrong pleae try again", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent=new Intent(BookDetailsActivity2.this,AlreadyReadActivity2.class);
                    BookDetailsActivity2.this.startActivity(intent);
                }
            });
        }
    }
    //checking if incoming Books exist in AlreadyReadList in order to desabled the AlreadyRead BTtn
    //if it doesn't add it to the AlreadyReadyList
    public void handleWantReadBook(Books book){
        ArrayList<Books> WantToReadBooks=Utils.getInstance(this).getWantToReadBooks();
        boolean ExistInReadBook=false;
        for (Books b:WantToReadBooks){
            if(b.getId()==book.getId()){
                ExistInReadBook=true;
            }
        }
        if(ExistInReadBook){
            WantRead.setEnabled(false);
        }
        else{
            WantRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookDetailsActivity2.this).AddBookToWantReeadList(book)){
                        Toast.makeText(BookDetailsActivity2.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookDetailsActivity2.this,WantReadBook2.class);
                        BookDetailsActivity2.this.startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookDetailsActivity2.this, "something went wrong pleae try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    //checking if incoming Books exist in AlreadyReadList in order to desabled the AlreadyRead BTtn
    //if it doesn't add it to the AlreadyReadyList
    public void  handleCurrentlyReadBook(Books book){
        ArrayList<Books> CurrentlyReadBooks=Utils.getInstance(this).getCurrentlyReadingBooks();
        boolean ExistInCurrentlyBook=false;
        for (Books b:CurrentlyReadBooks){
            if(b.getId()==book.getId()){
                ExistInCurrentlyBook=true;
            }
        }
        if( ExistInCurrentlyBook){
            CurrentRead.setEnabled(false);
        }
        else{
            CurrentRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookDetailsActivity2.this).AddBookToCurretlyReadList(book)){
                        Toast.makeText(BookDetailsActivity2.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookDetailsActivity2.this,CurrentlyReadActivity2.class);
                        BookDetailsActivity2.this.startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookDetailsActivity2.this, "something went wrong pleae try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    //checking if incoming Books exist in AlreadyReadList in order to desabled the AlreadyRead BTtn
    //if it doesn't add it to the AlreadyReadyList
    public void   handleFavoritesBook(Books book){
        ArrayList<Books> FavoriteReadBooks=Utils.getInstance(this).getFavoriteBooks();
        boolean ExistInFavoriteBook=false;
        for (Books b:FavoriteReadBooks){
            if(b.getId()==book.getId()){
                ExistInFavoriteBook=true;
            }
        }
        if( ExistInFavoriteBook){
            Favorite.setEnabled(false);
        }
        else{
            Favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookDetailsActivity2.this).AddBookToFavoriteList(book)){
                        Toast.makeText(BookDetailsActivity2.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookDetailsActivity2.this,FaovoriteReadActivity2.class);
                        BookDetailsActivity2.this.startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookDetailsActivity2.this, "something went wrong pleae try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    private  void INIT(){
        BookImage=findViewById(R.id.imageLogo);
        CurrentRead=findViewById(R.id.CurrentlyReading);
        WantRead=findViewById(R.id.wantToRead);
        AlreadyRead=findViewById(R.id.AlreadyRead);
        Favorite=findViewById(R.id.Favorites);
        AuthorText=findViewById(R.id.AuthorText);
        BookText=findViewById(R.id.BookNameText);
        PagesNumber=findViewById(R.id.PageNumber);
        DescText=findViewById(R.id.DescriptionText);
    }
    private void setData(Books book){
        AuthorText.setText(book.getAuthor());
        BookText.setText(book.getName());
        PagesNumber.setText(String.valueOf(book.getPages()));
        DescText.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImgUrl())
                .into(BookImage);
    }
}