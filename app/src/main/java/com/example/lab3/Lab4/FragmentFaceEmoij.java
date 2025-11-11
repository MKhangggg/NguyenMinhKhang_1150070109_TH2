package com.example.lab3.Lab4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

import com.example.lab3.R;

import java.util.Random;

public class FragmentFaceEmoij extends Fragment implements View.OnClickListener {
    private static final int[] IDS = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4,
            R.id.iv_face5, R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};
    private Context ctx;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.m001_frg_face_emoji, container, false);
        for (int id : IDS) root.findViewById(id).setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        showToast(((ImageView) v).getDrawable());
    }

    private void showToast(Drawable drawable) {
        Toast t = new Toast(ctx);
        ImageView img = new ImageView(ctx);
        img.setImageDrawable(drawable);
        t.setView(img);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}
