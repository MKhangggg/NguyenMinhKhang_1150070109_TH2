package com.example.lab3.ui.truyen;

import android.os.Bundle;
import android.os.Handler;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.lab3.MainActivity;
import com.example.lab3.R;

public class M000SplashFrg extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inf, @Nullable ViewGroup parent, @Nullable Bundle b) {
        return inf.inflate(R.layout.m000_frg_splash, parent, false);
    }
    @Override public void onViewCreated(@NonNull View v, @Nullable Bundle b) {
        new Handler().postDelayed(()-> ((MainActivity)requireActivity()).gotoM001Screen(), 2000);
    }
}
