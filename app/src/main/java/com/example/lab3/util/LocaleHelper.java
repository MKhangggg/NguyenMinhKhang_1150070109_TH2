package com.example.lab3.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import java.util.Locale;

public class LocaleHelper {
    public static void changeLocale(Context ctx, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration c = new Configuration(ctx.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 24) c.setLocale(locale); else c.locale = locale;
        ctx.getResources().updateConfiguration(c, ctx.getResources().getDisplayMetrics());
    }
}
