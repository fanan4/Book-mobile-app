package com.example.ui_androidapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static  Utils instance;
   /*private static ArrayList<Books> AllBooks;
    private static ArrayList<Books> AlreadyReadBooks;
    private static ArrayList<Books> WantToReadBooks;
    private static ArrayList<Books> CurrentlyReadingBooks;
    private static ArrayList<Books> favoriteBooks;*/
    private SharedPreferences sharedPreferences;
    private static final String Data_base="myDataBase",ALL_BOOK="AllBook",ALREADY_READ="AlreadyReadBook";
    private static final String WANT_READ="WantReadBook",FAVORITE="favorite",CURRENTLY_READ="CurrentlyReadBook";


    private Utils(Context context) {
        sharedPreferences=context.getSharedPreferences(Data_base,Context.MODE_PRIVATE);
        if(getAllBooks()==null){
            initData();
        }
        if(getAlreadyReadBooks()==null){
            ArrayList<Books> book=new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(ALREADY_READ,gson.toJson(book));
            editor.commit();
        }
        if(getCurrentlyReadingBooks()==null){
            ArrayList<Books> book=new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(CURRENTLY_READ,gson.toJson(book));
            editor.commit();
        }
        if(getWantToReadBooks()==null){
            ArrayList<Books> book=new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(WANT_READ,gson.toJson(book));
            editor.commit();
        }
        if(getFavoriteBooks()==null){
            ArrayList<Books> book=new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(FAVORITE,gson.toJson(book));
            editor.commit();
        }

    }
    private  void initData(){
        ArrayList<Books> book=new ArrayList<>();
        book.add(new Books(1,"Unlimeted Power","Tony Robbins","https://newchapter.lk/wp-content/uploads/2020/11/unlimited-power.jpg",448,"best book","if you have ever drreamed of a beeter life"));
        book.add(new Books(2,"the secret","Tony Robbins","https://cdn.shopify.com/s/files/1/0281/5331/5388/products/Secret-Rhonda-Byrne.jpg?v=1613126039",448,"best book","if you have ever drreamed of a beeter life"));
        Gson gson=new Gson();
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(ALL_BOOK,gson.toJson(book));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if(instance!=null){
            return instance;
        }
        else{
            instance= new Utils(context);
            return  instance;
        }

    }

    public  ArrayList<Books> getAllBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> book=gson.fromJson(sharedPreferences.getString(ALL_BOOK,null),type);
        return book;
    }

    public ArrayList<Books> getAlreadyReadBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> book=gson.fromJson(sharedPreferences.getString(ALREADY_READ,null),type);
        return book;
    }

    public ArrayList<Books> getWantToReadBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> book=gson.fromJson(sharedPreferences.getString(WANT_READ,null),type);
        return book;
    }

    public ArrayList<Books> getCurrentlyReadingBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> book=gson.fromJson(sharedPreferences.getString(CURRENTLY_READ,null),type);
        return book;
    }

    public ArrayList<Books> getFavoriteBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> book=gson.fromJson(sharedPreferences.getString(FAVORITE,null),type);
        return book;
    }
    public Books getBookID(int id){
        ArrayList<Books> books=getAllBooks();
        if(books!=null){
            for(Books b:books){
                if(b.getId()==id){
                    return b;
                }
        }

        }
        return null;
    }
    //add a book to AlreadyReadBook
    public boolean AddBookToAlreadyList(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books;
        books=getAlreadyReadBooks();
        if(book!=null) {
            if (books.add(book)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ);
                editor.putString(ALREADY_READ, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
            return false;
    }
    public boolean AddBookToWantReeadList(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books;
        books=getWantToReadBooks();
        if(book!=null) {
            if (books.add(book)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_READ);
                editor.putString(WANT_READ, gson.toJson(books));
                editor.commit();
                return true;
            }
        }

        return false;
    }
    public boolean AddBookToCurretlyReadList(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books;
        books=getCurrentlyReadingBooks();
        if(book!=null) {
            if (books.add(book)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READ);
                editor.putString(CURRENTLY_READ, gson.toJson(books));
                editor.commit();
                return true;
            }
        }

            return false;
    }
    public boolean AddBookToFavoriteList(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books=new ArrayList<>();
        books=getFavoriteBooks();
        if(book!=null) {
            if (books.add(book)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE);
                editor.putString(FAVORITE, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
            return false;

    }
    public boolean DeleteFromCurrentlyReadBooks(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books=new ArrayList<>();
        books=getCurrentlyReadingBooks();
        if(book!=null) {
            for (Books b:books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READ);
                        editor.putString(CURRENTLY_READ, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }

            return false;
    }
    public boolean DeleteFromWantReadBooks(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books=new ArrayList<>();
        books=getWantToReadBooks();
            if(book!=null) {
                for (Books b:books){
                    if(b.getId()==book.getId()){
                        if(books.remove(b)){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove(WANT_READ);
                            editor.putString(WANT_READ, gson.toJson(books));
                            editor.commit();
                            return true;
                        }
                    }
                }

            }
            return false;
    }
    public boolean DeleteFromAlreadyReadBooks(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books=new ArrayList<>();
        books=getAlreadyReadBooks();
        if(book!=null) {
            for (Books b:books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ);
                        editor.putString(ALREADY_READ, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
            return false;
        }

    public boolean DeleteFromFavoriteBook(Books book){
        Gson gson=new Gson();
        ArrayList<Books> books=new ArrayList<>();
        books=getFavoriteBooks();
        if(book!=null) {
            for (Books b:books){
                if(b.getId()==book.getId()){
                    if(books.remove(b)){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE);
                        editor.putString(FAVORITE, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }

            return false;
        }
    }


