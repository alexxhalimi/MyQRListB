package com.example.barodegeneratorscanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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

public class Activity_SignUp extends AppCompatActivity {
    TextInputEditText name ,lname,email,pass,conPass;
    Button SignUp;
    String strEmail="";
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE| WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        name=findViewById(R.id.name);
        lname=findViewById(R.id.lastName);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        conPass=findViewById(R.id.confirmPassword);
        SignUp=findViewById(R.id.signup);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference().child("stock").child("signup");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                   arrayList.add(dataSnapshot.getKey());
                    Log.i("size", "onDataChange: "+arrayList.size());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremsil=email.getText().toString().replace("@","-").replace(".","_");
                    
                if (name.getText().toString().length()>0)
                {
                    if (lname.getText().toString().length()>0)
                    {
                        if (email.getText().toString().length()>0)
                        {
                            if (pass.getText().toString().length()>0)
                            {
                                if (conPass.getText().toString().length()>0)
                                {
                                    if (pass.getText().toString().matches(conPass.getText().toString()))
                                    {
                                        int count=0;
                                        for (int i=0;i<arrayList.size();i++)
                                        {
                                            if (stremsil.matches(arrayList.get(i)))
                                            {
                                                count++;
                                            }
                                            
                                        }
                                        if (count==0) {

                                            ModelClass modelClass = new ModelClass(name.getText().toString(), lname.getText().toString(), email.getText().toString(), pass.getText().toString(), conPass.getText().toString());
                                            root.child(stremsil).setValue(modelClass);
                                            name.setText("");
                                            lname.setText("");
                                            email.setText("");
                                            pass.setText("");
                                            conPass.setText("");
                                            Toast.makeText(Activity_SignUp.this, "SignUp Seccessively", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(Activity_SignUp.this, Login.class));
                                            finish();
                                        }
                                        else 
                                        {
                                            Toast.makeText(Activity_SignUp.this, "Email already exist", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else
                                    {

                                    }
                                }
                                else
                                {
                                    conPass.setError("enter confirm pass");
                                }
                            }
                            else
                            {
                                pass.setError("Enter password");
                            }
                        }
                        else
                        {
                        email.setError("enter email");
                        }
                    }
                    else
                    {

                    }
                }
                else
                {

                }
            }
        });
    }
}