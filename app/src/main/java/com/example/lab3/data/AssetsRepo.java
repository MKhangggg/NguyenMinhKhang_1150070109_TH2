package com.example.lab3.data;

import android.content.Context;
import com.example.lab3.model.Story;
import com.example.lab3.model.Topic;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

public class AssetsRepo {
    private final Context ctx;
    private final Gson gson = new Gson();
    public AssetsRepo(Context ctx){ this.ctx = ctx; }

    public List<Topic> getTopics(){
        Type t = new TypeToken<List<Topic>>(){}.getType();
        return gson.fromJson(JsonUtils.readAsset(ctx,"topics.json"), t);
    }

    public List<Story> getStoriesByTopic(String topicId){
        String file = "stories_" + topicId + ".json";
        Type t = new TypeToken<List<Story>>(){}.getType();
        List<Story> list = gson.fromJson(JsonUtils.readAsset(ctx, file), t);
        if (list==null) list = new ArrayList<>();
        Collections.sort(list, Comparator.comparing(s->s.title));
        return list;
    }
}