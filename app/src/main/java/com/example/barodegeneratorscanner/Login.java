package com.example.barodegeneratorscanner;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    TextInputEditText username,password;
    Button signin,signup;
    TextView signinwithGoogle;
    ArrayList<ModelClass>arrayList=new ArrayList<>();
    TextView headr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.textInputEditText);
        password=findViewById(R.id.textInputEditText2);
        signin=findViewById(R.id.button);
        signup=findViewById(R.id.signup);
        signinwithGoogle = findViewById(R.id.signInWithGoogle);
        signinwithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SigninWithGoogle.class));
            }
        });
        headr=findViewById(R.id.header);
        headr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
        arrayList.clear();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference().child("stock").child("signup");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ModelClass model = dataSnapshot.getValue(ModelClass.class);

                    arrayList.add(model);
                    Log.i("size", "onDataChange: "+arrayList.size());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().length()>0)
                {
                    if (password.getText().toString().length()>0)
                    {
                        int count=0;
                        for (int i=0;i<arrayList.size();i++) {
                            if (username.getText().toString().matches(arrayList.get(i).getEmail()) && password.getText().toString().matches(arrayList.get(i).getPass())) {
                               count++;
                                startActivity(new Intent(Login.this,MainActivity.class));
                                finish();
                            }

                        }
                        if (count==0)
                        {
                            Toast.makeText(Login.this,"Invalid username or password",Toast.LENGTH_LONG).show();
                            password.setText("");
                        }
                    }
                }
                else
                {
                    username.setError("enter user name");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Activity_SignUp.class));
            }
        });
    }
}