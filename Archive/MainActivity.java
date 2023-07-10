package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button btnKt;
    RadioButton bienso,cmnd,email;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matching();
        btnKt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                Pattern pattern = null;
                if (email.isChecked()) {
                    String regex = "\\w+@\\w+\\.w+";
                    pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(text);
                    if (matcher.matches() == true) {
                        show.setText("Email Hop Le");
                    } else {
                        show.setText("Email Khong Hop Le");
                    }

                } else if (cmnd.isChecked()) {
                    String regex = "\\d{12}";
                    show.setText("Ban Dang Chon CMND");
                } else if (bienso.isChecked()) {
                    String regex = "41|5\\d-[A-Z]\\d-\\d{3}.{2}";
                    show.setText("Ban Dang Chon Bien So");
                } else {
                    show.setText("Ban Chua Chon");
                }
            }

        });
        }
    void matching(){
        input = findViewById(R.id.userInput);
        btnKt = findViewById(R.id.kiemtra);
        bienso = findViewById(R.id.bienso);
        cmnd = findViewById(R.id.cmnd);
        email = findViewById(R.id.email);
        show = findViewById(R.id.show);
    }

    }
