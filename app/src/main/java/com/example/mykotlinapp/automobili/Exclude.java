package com.example.mykotlinapp.automobili;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

public class Exclude implements ExclusionStrategy{






        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            SerializedName ns = f.getAnnotation(SerializedName.class);
            return ns == null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> arg0) {
            // TODO Auto-generated method stub
            return false;
        }


    }

