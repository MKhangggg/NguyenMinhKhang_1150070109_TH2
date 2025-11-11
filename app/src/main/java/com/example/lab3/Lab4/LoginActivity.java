package com.example.lab3.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPass;
    private TextView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            showCustomToast();
            Intent i = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(i);
        });
    }

    private void showCustomToast() {
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();

        View layout = LayoutInflater.from(this).inflate(R.layout.toast_custom, null);
        TextView tv = layout.findViewById(R.id.tvToast);
        tv.setText("Đăng nhập thành công:\n" + email);

        Toast t = new Toast(this);
        t.setView(layout);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}
