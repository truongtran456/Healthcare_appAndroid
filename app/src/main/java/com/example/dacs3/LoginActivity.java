package com.example.dacs3;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserName, editTextPassword;
    private Button buttonLogin;

    TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName=findViewById(R.id.editTextUserName);
        editTextPassword=findViewById(R.id.editTextTextPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLogin_onClick(view);
            }
        });
        signUp=findViewById(R.id.buttonSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSignUp_onClick(view);
            }
        });
    }

    public void buttonLogin_onClick(View view) {
        AccountDB accountDB = new AccountDB(getApplicationContext());
        String username = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
        Account account = accountDB.login(username, password);
        if (account == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.invalid_account);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("account", account);
            startActivity(intent);
        }
    }

    public void buttonSignUp_onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}