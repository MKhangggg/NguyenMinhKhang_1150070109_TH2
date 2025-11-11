package com.example.lab3.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

public class MenuActivity extends AppCompatActivity {
    private static final int[] IMGS = {
            R.drawable.ic_mess, R.drawable.ic_hotel, R.drawable.ic_restaurant
    };
    private static final String[] TOPICS = {
            "Essentials", "At the Hotel", "At the Restaurant"
    };
    private static final String[][] WORDS = {
            {"Hello", "Goodbye", "Thanks"},
            {"Room", "Key", "Reception"},
            {"Menu", "Bill", "Table"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout lnMain = findViewById(R.id.ln_main);
        Button btnEmoji = new Button(this);
        btnEmoji.setText("Open Emoij");
        btnEmoji.setOnClickListener(v -> startActivity(new Intent(this, FaceEmoijActivity.class)));

        Button btnLogout = new Button(this);
        btnLogout.setText("Logout");
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        // Add buttons top
        lnMain.addView(btnEmoji);
        lnMain.addView(btnLogout);

        // Add topic list
        for (int i = 0; i < TOPICS.length; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_topic_lab4, null);
            ((ImageView) v.findViewById(R.id.iv_topic)).setImageResource(IMGS[i]);
            ((TextView) v.findViewById(R.id.tv_topic)).setText(TOPICS[i]);
            int idx = i;
            v.setOnClickListener(view ->
                    Toast.makeText(this, String.join(", ", WORDS[idx]), Toast.LENGTH_SHORT).show());
            lnMain.addView(v);
        }
    }
}
