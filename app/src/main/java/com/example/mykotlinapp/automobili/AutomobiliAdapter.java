package com.example.mykotlinapp.automobili;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mykotlinapp.R;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sawyer on 5/31/2017.
 */

public class AutomobiliAdapter extends ArrayAdapter {
    @SerializedName("list")
      List   list;
    @SerializedName("ctx")  Context ctx;
       public AutomobiliAdapter(Context context, int resource) {
        super(context, resource);
        this.ctx=context;
        list=new ArrayList();
    }

        public void add(Auto object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {

        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        NamirniceHolder namirniceHolder;

            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_namirnice,parent,false);
            namirniceHolder =new NamirniceHolder();
            namirniceHolder.naziv= row.findViewById(R.id.naziv);
       //     namirniceHolder.kalorije=(TextView)row.findViewById(R.id.kalorije);
            namirniceHolder.marka= row.findViewById(R.id.marka);
         //   namirniceHolder.hidrati=(TextView)row.findViewById(R.id.hidrati);
          //  namirniceHolder.proteini=(TextView)row.findViewById(R.id.proteini);
          //  namirniceHolder.masti=(TextView)row.findViewById(R.id.masti);
           namirniceHolder.slika= row.findViewById(R.id.slika);

            row.setTag(namirniceHolder);


            namirniceHolder =(NamirniceHolder)row.getTag();

           Auto namirnice=(Auto) this.getItem(position);
        namirniceHolder.naziv.setText(namirnice.getNaziv());
      namirniceHolder.marka.setText(namirnice.getMarka());
     //   namirniceHolder.hidrati.setText(namirnice.getHidrati());
     //   namirniceHolder.proteini.setText(namirnice.getProteini());
     //   namirniceHolder.masti.setText(namirnice.getMasti());
       // namirniceHolder.kategorija.setText(namirnice.getKategorija());
        // namirniceHolder.slika.setImageBitmap(namirnice.getSlika());
        //if(row!=null)


     Bitmap bm = BitmapFactory.decodeByteArray(namirnice.getSlika(), 0, namirnice.getSlika().length);

      namirniceHolder.slika.setImageBitmap(bm);
        return row;
    }
    static class NamirniceHolder
    {
        @SerializedName("naziv")
        TextView naziv;
        @SerializedName("marka")
        TextView marka;
        ImageView slika;

    }
    public String getSome()
    {
         Auto auto=(Auto)this.getItem(0);
        return auto.getNaziv()+" "+auto.getMarka();
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }


}