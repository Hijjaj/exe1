package com.example.a20200140042_exe1_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityHasil extends AppCompatActivity {
    ImageButton add;
    EditText mtask,mjetask,mtimetask;
    TextView TeAnda;
    String task,jetask,timetask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        add = findViewById(R.id.add);
        mtask = findViewById(R.id.mtask);
        mjetask = findViewById(R.id.mjetask);
        mtimetask = findViewById(R.id.mtimetask);
        TeAnda = findViewById(R.id.Anda);
        Bundle bundle = getIntent().getExtras();
        String anda = bundle.getString("c");
        String anda2 = bundle.getString("a");
        if(anda.isEmpty()){
            TeAnda.setText(anda2);
        }else{
        TeAnda.setText(anda);}
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnsubmit){
            Intent e = new Intent(getApplicationContext(),ActivityTampil.class);
            startActivity(e);
        }
        if (item.getItemId() == R.id.mnlogout){
            Intent f = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(f);
        }
        return super.onOptionsItemSelected(item);
    }

    public void validasi(){
        task = mtask.getText().toString();
        jetask = mjetask.getText().toString();
        timetask = mtimetask.getText().toString();
        if(task.isEmpty() && jetask.isEmpty() && timetask.isEmpty()){
            mtask.setError("nama task");
            mjetask.setError("jenis task");
            mtimetask.setError("lama task");
        }
        else{
            Bundle butask = new Bundle();
            butask.putString("f",task.trim());
            butask.putString("g",jetask.trim());
            butask.putString("h",timetask.trim());
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            Intent d = new Intent(getApplicationContext(),ActivityTampil.class);
            d.putExtras(butask);
            startActivity(d);


        }

    }
}