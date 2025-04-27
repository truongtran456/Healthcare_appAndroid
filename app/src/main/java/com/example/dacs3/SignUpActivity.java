package com.example.dacs3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextFullname, editTextEmail;
    private Button buttonSave;
    TextView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername=findViewById(R.id.editTextUserName);
        editTextPassword=findViewById(R.id.editTextPassWord);
        editTextFullname=findViewById(R.id.editTextFullName);
        editTextEmail=findViewById(R.id.editTextEmail);
        cancel=findViewById(R.id.buttonCancel);
        buttonSave=findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSave_onClick(view);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    public void buttonSave_onClick(View view){
        try {
            AccountDB accountDB = new AccountDB(getApplicationContext());
            Account account = new Account();
            account.setEmail(editTextEmail.getText().toString());
            account.setFullname(editTextFullname.getText().toString());
            account.setPassword(editTextPassword.getText().toString());
            account.setUsername(editTextUsername.getText().toString());
            Account temp = accountDB.checkUsername(editTextUsername.getText().toString());
            if (temp ==null){
                if(accountDB.create(account)){
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle(R.string.error);
                    builder.setMessage(R.string.can_not_create);
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.username_exits);
                builder.setPositiveButton(R.string.ok,(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                builder.show();
            }
        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(e.getMessage());
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
        }

    }
}