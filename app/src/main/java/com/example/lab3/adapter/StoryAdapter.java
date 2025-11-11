package com.example.lab3.adapter;

import android.app.Activity;
import android.view.*;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab3.R;
import com.example.lab3.model.Story;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.VH> {
    public interface OnItemClick { void onClick(Story s, int index); }

    private final List<Story> data;
    private final OnItemClick cb;

    public StoryAdapter(List<Story> d, OnItemClick c) {
        data = d;
        cb = c;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvTitle, tvBrief;
        ImageButton btnBack;

        VH(@NonNull View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvBrief = v.findViewById(R.id.tvBrief);
            btnBack = v.findViewById(R.id.btnBack);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int vType) {
        return new VH(LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_story, p, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Story s = data.get(pos);
        h.tvTitle.setText(s.title);
        h.tvBrief.setText(s.brief);
        h.itemView.setOnClickListener(v -> cb.onClick(s, pos));
        if (h.btnBack != null) {
            h.btnBack.setOnClickListener(v -> {
                if (v.getContext() instanceof Activity) {
                    ((Activity) v.getContext()).finish();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
