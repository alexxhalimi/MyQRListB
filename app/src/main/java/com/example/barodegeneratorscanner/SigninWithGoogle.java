package com.example.barodegeneratorscanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.api.services.drive.DriveScopes;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Collections;

public class SigninWithGoogle extends AppCompatActivity {

    EditText RegEmail,RegPassword;
    Button Regbtn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_with_google);
     ini();
        Regbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = RegEmail.getText().toString();
                String password1 = RegPassword.getText().toString();
                if (TextUtils.isEmpty( email1 ) || TextUtils.isEmpty( password1 )){
                    Toast.makeText(SigninWithGoogle.this, "Enter email and Password", Toast.LENGTH_SHORT ).show();
                } else {
                    regis(email1,password1);
                }

            }
        } );
    }

    private void regis(String email1, String password1) {
        auth.createUserWithEmailAndPassword( email1,password1 ).addOnCompleteListener( SigninWithGoogle .this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText( SigninWithGoogle.this, "Successfully Register", Toast.LENGTH_SHORT ).show();
             Intent intent=new Intent(SigninWithGoogle.this,MainActivity.class);
             startActivity(intent);
                }else {
                    Toast.makeText( SigninWithGoogle.this, "failed", Toast.LENGTH_SHORT ).show();
                }

            }
        } );
    }

    private void ini() {
        RegEmail = findViewById( R.id.ed_email );
        RegPassword = findViewById( R.id.ed_password );
        Regbtn = findViewById( R.id.btn_register2 );
        auth = FirebaseAuth.getInstance();
    }


}