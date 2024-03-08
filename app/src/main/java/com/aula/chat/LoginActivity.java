package com.aula.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aula.teste.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText emailText,senhaText;
    TextView login,register;
    String email,senha;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        onClick();

    }
    @Override
    protected void onStart(){
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this, ChatActivity.class));
            finish();
        }
    }
    private Boolean verificacao(){
        email = emailText.getText().toString().trim();
        senha = senhaText.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            emailText.setError("Erro");
            emailText.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(senha)){
            senhaText.setError("Erro");
            senhaText.requestFocus();
            return false;
        }
        return true;
    }
    private void init(){
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        emailText = findViewById(R.id.emailText);
        senhaText = findViewById(R.id.senhaText);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

    }
    private void onClick(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificacao()){
                    login();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void login(){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.trim(),senha.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>(){
                    @Override
                    public void onSuccess(AuthResult authResult){
                        String username = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                        Intent intent = new Intent(LoginActivity.this,ChatActivity.class);
                        intent.putExtra("name",username);
                        startActivity(intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if(e instanceof FirebaseAuthInvalidCredentialsException){
                            Toast.makeText(LoginActivity.this, "Usuario não existe", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Auth falhou", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}