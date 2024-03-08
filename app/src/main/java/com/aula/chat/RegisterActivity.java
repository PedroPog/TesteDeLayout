package com.aula.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    EditText userText,emailText,senhaText;
    TextView login,register;
    String email,senha,user;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        onClick();
    }
    private Boolean verificacao(){
        email = emailText.getText().toString().trim();
        senha = senhaText.getText().toString().trim();
        user = userText.getText().toString().trim();
        if(TextUtils.isEmpty(user)){
            userText.setError("Erro");
            userText.requestFocus();
            return false;
        }
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
        userText = findViewById(R.id.userText);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

    }
    private void onClick(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificacao()) {
                    register();
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(RegisterActivity.this, ChatActivity.class));
            finish();
        }
    }

    private void register() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.trim(),senha.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(user).build();
                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        firebaseUser.updateProfile(userProfileChangeRequest);

                        UserModel userModel = new UserModel(FirebaseAuth.getInstance().getUid(),user,email,senha);
                        databaseReference.child(FirebaseAuth.getInstance().getUid()).setValue(userModel);
                        Intent intent = new Intent(RegisterActivity.this,ChatActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Falha no registro!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}