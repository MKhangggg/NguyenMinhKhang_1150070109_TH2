package com.example.lab3.ui.truyen;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.lab3.MainActivity;
import com.example.lab3.adapter.StoryAdapter;
import com.example.lab3.data.AssetsRepo;
import com.example.lab3.databinding.M002FrgStoryListBinding;
import com.example.lab3.model.Story;
import java.util.ArrayList;
import java.util.List;

public class M002StoryListFrg extends Fragment {
    private static final String ARG_TOPIC_ID="topicId", ARG_TOPIC_NAME="topicName";
    public static M002StoryListFrg newInstance(String topicId, String topicName){
        Bundle b=new Bundle(); b.putString(ARG_TOPIC_ID, topicId); b.putString(ARG_TOPIC_NAME, topicName);
        M002StoryListFrg f=new M002StoryListFrg(); f.setArguments(b); return f;
    }

    private M002FrgStoryListBinding vb;
    private List<Story> stories = new ArrayList<>();

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inf, @Nullable ViewGroup parent, @Nullable Bundle b) {
        vb = M002FrgStoryListBinding.inflate(inf, parent, false);
        return vb.getRoot();
    }

    @Override public void onViewCreated(@NonNull View v, @Nullable Bundle b) {
        String topicId = getArguments().getString(ARG_TOPIC_ID);
        String topicName = getArguments().getString(ARG_TOPIC_NAME);

        vb.tvTopic.setText(topicName);
        stories = new AssetsRepo(requireContext()).getStoriesByTopic(topicId);

        vb.rvStories.setLayoutManager(new LinearLayoutManager(getContext()));
        vb.rvStories.setAdapter(new StoryAdapter(stories, (s, index) ->
                ((MainActivity)requireActivity()).gotoM003Screen(new ArrayList<>(stories), index)
        ));
    }
}
