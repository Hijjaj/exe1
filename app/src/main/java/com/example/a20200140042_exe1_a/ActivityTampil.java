package com.example.a20200140042_exe1_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityTampil extends AppCompatActivity {
    TextView hamtask,hamjetask,hamtitask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        hamtask = findViewById(R.id.hamtask);
        hamjetask = findViewById(R.id.hamjetask);
        hamtitask = findViewById(R.id.hamtitask);
        Bundle bundle = getIntent().getExtras();
        String isi1 = bundle.getString("f");
        String isi2 = bundle.getString("g");
        String isi3 = bundle.getString("h");
        hamtask.setText(isi1);
        hamjetask.setText(isi2);
        hamtitask.setText(isi3);
    }
}