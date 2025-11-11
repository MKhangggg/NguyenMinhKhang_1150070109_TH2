package com.example.lab3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.lab3.databinding.ActivityMainBinding;
import com.example.lab3.model.Story;
import com.example.lab3.ui.truyen.M000SplashFrg;
import com.example.lab3.ui.truyen.M001TopicFrg;
import com.example.lab3.ui.truyen.M002StoryListFrg;
import com.example.lab3.ui.truyen.M003StoryDetailFrg;
import com.example.lab3.ui.animal.AnimalActivity;
import com.example.lab3.util.LocaleHelper;
import com.example.lab3.util.Prefs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding vb;
    private boolean allowRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(vb.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        allowRotation = Prefs.getRotation(this);
        applyRotation();
        showFrg(new M000SplashFrg());
    }

    private void applyRotation() {
        setRequestedOrientation(allowRotation ?
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED :
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void showFrg(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, f, null)
                .commit();
    }

    public void gotoM001Screen() {
        showFrg(new M001TopicFrg());
    }

    public void gotoM002Screen(String topicId, String topicName) {
        showFrg(M002StoryListFrg.newInstance(topicId, topicName));
    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    public void gotoM003Screen(ArrayList<Story> list, int startIndex) {
        showFrg(M003StoryDetailFrg.newInstance(list, startIndex));
    }
    public void gotoAnimalActivity() {
        Intent i = new Intent(this, AnimalActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_rotation).setChecked(allowRotation);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.lang_vi) {
            LocaleHelper.changeLocale(this, "vi");
            recreate();
            return true;
        }

        if (id == R.id.lang_en) {
            LocaleHelper.changeLocale(this, "en");
            recreate();
            return true;
        }

        if (id == R.id.action_rotation) {
            item.setChecked(!item.isChecked());
            allowRotation = item.isChecked();
            Prefs.setRotation(this, allowRotation);
            applyRotation();
            return true;
        }

        if (id == R.id.action_animal) {
            gotoAnimalActivity();
            return true;
        }
        if (id == R.id.action_open_lab4) {
            Intent i = new Intent(this, com.example.lab3.Lab4.LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
