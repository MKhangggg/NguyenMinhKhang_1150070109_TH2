package com.example.lab3.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String P="lab3_prefs", K_ROT="rot";
    public static void setRotation(Context c, boolean v){
        SharedPreferences sp=c.getSharedPreferences(P, Context.MODE_PRIVATE);
        sp.edit().putBoolean(K_ROT,v).apply();
    }
    public static boolean getRotation(Context c){
        return c.getSharedPreferences(P, Context.MODE_PRIVATE).getBoolean(K_ROT,true);
    }
}
