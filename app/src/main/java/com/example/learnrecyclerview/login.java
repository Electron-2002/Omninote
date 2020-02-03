package com.example.learnrecyclerview;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private EditText Usrnm;
    private EditText Pswrd;
    private Button Login;
    private Button Reg;

    SharedPreferences sharedpreferences;

    String User, Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        sharedpreferences = getApplicationContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);

        Usrnm = findViewById(R.id.lusername);
        Pswrd = findViewById(R.id.lpassword);
        Login = findViewById(R.id.login);
        Reg = findViewById(R.id.regi);

        User = sharedpreferences.getString("Username", null);
        Pass = sharedpreferences.getString("Password", null);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Usrnm.getText().toString().equals(User) && Pswrd.getText().toString().equals(Pass)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    finish();
                    startActivity(intent);
                } else if (Usrnm.getText().toString().equals(User) && (!(Pswrd.getText().toString().equals(Pass)))) {

                    Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No such user registered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registration.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
