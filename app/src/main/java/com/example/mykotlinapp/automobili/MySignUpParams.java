package com.example.mykotlinapp.automobili;

import android.content.Context;
import android.content.Intent;

public class MySignUpParams {
  public String ime;
  public String prezime;
  public String username;
  public String password;
  public Context ctx;
  public Intent intent;

    public MySignUpParams(String ime, String prezime, String username, String password,Context ctx,Intent itx) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.ctx=ctx;
        this.intent=itx;
    }
}
