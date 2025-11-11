package com.example.lab3.ui.truyen;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.lab3.MainActivity;
import com.example.lab3.adapter.TopicAdapter;
import com.example.lab3.data.AssetsRepo;
import com.example.lab3.databinding.M001FrgTopicBinding;
import com.example.lab3.model.Topic;

import java.util.List;

public class M001TopicFrg extends Fragment {
    private M001FrgTopicBinding vb;
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inf, @Nullable ViewGroup parent, @Nullable Bundle b) {
        vb = M001FrgTopicBinding.inflate(inf, parent, false);
        return vb.getRoot();
    }
    @Override public void onViewCreated(@NonNull View v, @Nullable Bundle b) {
        List<Topic> topics = new AssetsRepo(requireContext()).getTopics();
        vb.rvTopics.setLayoutManager(new LinearLayoutManager(getContext()));
        vb.rvTopics.setAdapter(new TopicAdapter(topics, t ->
                ((MainActivity)requireActivity()).gotoM002Screen(t.id, t.name)
        ));
    }
}
