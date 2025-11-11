package com.example.lab3.ui.truyen;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.lab3.adapter.StoryPagerAdapter;
import com.example.lab3.databinding.M003FrgStoryDetailBinding;
import com.example.lab3.model.Story;
import java.util.ArrayList;

public class M003StoryDetailFrg extends Fragment {
    private static final String ARG_LIST="list", ARG_INDEX="index";
    public static M003StoryDetailFrg newInstance(ArrayList<Story> list, int index){
        Bundle b=new Bundle();
        b.putSerializable(ARG_LIST, list);
        b.putInt(ARG_INDEX, index);
        M003StoryDetailFrg f=new M003StoryDetailFrg();
        f.setArguments(b); return f;
    }

    private M003FrgStoryDetailBinding vb;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inf, @Nullable ViewGroup parent, @Nullable Bundle b) {
        vb = M003FrgStoryDetailBinding.inflate(inf, parent, false);
        return vb.getRoot();
    }
    @Override public void onViewCreated(@NonNull View v, @Nullable Bundle b) {
        ArrayList<Story> list = (ArrayList<Story>) getArguments().getSerializable(ARG_LIST);
        int index = getArguments().getInt(ARG_INDEX, 0);
        vb.viewPager.setAdapter(new StoryPagerAdapter(list));
        vb.viewPager.setCurrentItem(index, false);
    }
}
