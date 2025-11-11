package com.example.lab3.data;

import android.content.Context;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonUtils {
    public static String readAsset(Context ctx, String name) {
        try (InputStream is = ctx.getAssets().open(name)) {
            byte[] b = new byte[is.available()];
            is.read(b);
            return new String(b, StandardCharsets.UTF_8);
        } catch (Exception e) { return "[]"; }
    }
}
