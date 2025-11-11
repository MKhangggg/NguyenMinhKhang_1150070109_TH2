package com.example.lab3.adapter;

import android.app.Activity;
import android.view.*;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab3.R;
import com.example.lab3.model.Topic;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.VH> {
    public interface OnItemClick { void onClick(Topic t); }

    private final List<Topic> data;
    private final OnItemClick cb;

    public TopicAdapter(List<Topic> d, OnItemClick c) {
        data = d;
        cb = c;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivIcon;
        ImageButton btnBack;

        VH(@NonNull View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            ivIcon = v.findViewById(R.id.ivIcon);
            btnBack = v.findViewById(R.id.btnBack);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int vType) {
        return new VH(LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_topic, p, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Topic t = data.get(pos);
        h.tvName.setText(t.name);
        h.itemView.setOnClickListener(v -> cb.onClick(t));

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
