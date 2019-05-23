package com.example.mykotlinapp.automobili;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.mykotlinapp.R;
import com.example.mykotlinapp.view.GalleryActivity;
import de.hdodenhof.circleimageview.CircleImageView;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private List<Auto> list;

    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        list=new LinkedList<>();
        mContext = context;
    }
    public void add(Auto object)
    {
        list.add(object);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Auto auto=(Auto) list.get(position);
        holder.imageName.setText(auto.getNaziv());
      //  namirniceHolder.marka.setText(namirnice.getMarka());
        //   namirniceHolder.hidrati.setText(namirnice.getHidrati());
        //   namirniceHolder.proteini.setText(namirnice.getProteini());
        //   namirniceHolder.masti.setText(namirnice.getMasti());
        // namirniceHolder.kategorija.setText(namirnice.getKategorija());
        // namirniceHolder.slika.setImageBitmap(namirnice.getSlika());
        //if(row!=null)


        Bitmap bm = BitmapFactory.decodeByteArray(auto.getSlika(), 0, auto.getSlika().length);

        holder.image.setImageBitmap(bm);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + ((Auto) list.get(position)).naziv);

                Toast.makeText(mContext,((Auto) list.get(position)).naziv, Toast.LENGTH_SHORT).show();

            //    Intent intent = new Intent(mContext, GalleryActivity.class);

              //  intent.putExtra("image_name", (list.get(position)).naziv);
                //mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















