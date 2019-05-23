package com.example.mykotlinapp.automobili;

public class MyTaskParams {
   public RecyclerViewAdapter automobiliAdapter;
   public Integer broj;


    public MyTaskParams(RecyclerViewAdapter at, Integer broj) {
        this.automobiliAdapter = at;
        this.broj=broj;

    }
}