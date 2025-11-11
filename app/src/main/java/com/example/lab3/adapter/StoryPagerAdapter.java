package com.example.lab3.adapter;

import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab3.R;
import com.example.lab3.model.Story;
import java.util.List;

public class StoryPagerAdapter extends RecyclerView.Adapter<StoryPagerAdapter.VH> {
    private final List<Story> data;
    public StoryPagerAdapter(List<Story> d){ data=d; }

    static class VH extends RecyclerView.ViewHolder{
        TextView tvTitle, tvContent;
        VH(@NonNull View v){ super(v);
            tvTitle=v.findViewById(R.id.tvStoryTitle);
            tvContent=v.findViewById(R.id.tvContent);
        }
    }
    @NonNull public VH onCreateViewHolder(@NonNull ViewGroup p,int viewType){
        View v=LayoutInflater.from(p.getContext()).inflate(R.layout.item_story_page,p,false);
        return new VH(v);
    }
    public void onBindViewHolder(@NonNull VH h,int pos){
        Story s=data.get(pos);
        h.tvTitle.setText(s.title);
        h.tvContent.setText(s.content);
    }
    public int getItemCount(){ return data.size(); }
}
