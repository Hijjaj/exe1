package com.example.a20200140042_exe1_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button register;
    EditText mnama,memail,mpassword,mrepassword;
    String nama,email,password,repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.button);
        mnama = findViewById(R.id.regmnama);
        memail = findViewById(R.id.regmemail);
        mpassword = findViewById(R.id.regmpass);
        mrepassword = findViewById(R.id.regmrepass);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }
    public void validasi(){
        nama = mnama.getText().toString();
        email = memail.getText().toString();
        password = mpassword.getText().toString();
        repassword = mrepassword.getText().toString();
        if(nama.isEmpty() && email.isEmpty() && password.isEmpty() && repassword.isEmpty()){
            mnama.setError("Nama harus diisi");
            memail.setError("Email harus diisi");
            mpassword.setError("Password harus diisi");
            mrepassword.setError("Repassword harus diisi");
        }
        if(repassword.equals(password)){
            Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
            Bundle bunama = new Bundle();
            bunama.putString("c",nama.trim());
            Intent c = new Intent(getApplicationContext(),ActivityHasil.class);
            c.putExtras(bunama);
            startActivity(c);
        }
        else{
            Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_LONG).show();
        }
    }
}