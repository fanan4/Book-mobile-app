package com.example.ui_androidapp;

public class Books {
    private int id;
    private String Name;
    private String Author;
    private String imgUrl;
    private int Pages;
    private String shortDesc;
    private String longDesc;
    private boolean extandable;


    public Books(int id, String name, String author, String imgUrl, int pages, String shortDesc, String longDesc) {
        this.id = id;
        Name = name;
        Author = author;
        this.imgUrl = imgUrl;
        Pages = pages;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        extandable=false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getPages() {
        return Pages;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public boolean getExtandable() {
        return extandable;
    }

    public void setExtandable(boolean extandable) {
        this.extandable = extandable;
    }
}
