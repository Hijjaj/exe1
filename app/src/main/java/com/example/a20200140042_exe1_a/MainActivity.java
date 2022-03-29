package com.example.a20200140042_exe1_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signin,register;
    EditText mnama,mpassword;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin = findViewById(R.id.btSignin);
        register = findViewById(R.id.btregister);
        mnama = findViewById(R.id.edmnama);
        mpassword = findViewById(R.id.edmpassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),Register.class);
                startActivity(a);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }

    public void validasi(){
        nama = mnama.getText().toString();
        password = mpassword.getText().toString();
        String email = "Hijjaj";
        String pass = "123";
        if(nama.isEmpty() && password.isEmpty()){
            mnama.setError("Nama harus diisi");
            mpassword.setError("Password harus diisi");
            Toast.makeText(getApplicationContext(), "Nama dan Password salah", Toast.LENGTH_SHORT).show();




        }else
        if(nama.equals(email)&& password.equals(pass)){
            Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
            Bundle b = new Bundle();
            b.putString("a",nama.trim());
            b.putString("b",password.trim());

            Intent i = new Intent(getApplicationContext(),ActivityHasil.class);
            i.putExtras(b);


            startActivity(i);
        }else if(nama.equalsIgnoreCase(email)){
            Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_SHORT).show();
        }else if(password.equalsIgnoreCase(pass)) {
            Toast.makeText(getApplicationContext(), "Nama salah", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Nama dan Password salah", Toast.LENGTH_SHORT).show();
        }


    }

}
