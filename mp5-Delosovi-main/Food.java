package com.example.foodieapp;

public class Food {

    private String title;
    private String info;
    private int imageResource;

    Food(String title, String info){

        this.title = title;
        this.info = info;
    }

    Food(String title, String info, int imageResource){
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;

    }

    public String getTitle(){

        return title;
    }
    public String getInfo(){

        return info;
    }

    public int getImageID(){

        return imageResource;
    }






}
