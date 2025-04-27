package com.example.dacs3;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword, editTextFullname, editTextEmail;
    private TextView  buttonSave;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.change_profile);

        editTextUsername=findViewById(R.id.editTextUserName);
        editTextPassword=findViewById(R.id.editTextPassWord);
        editTextFullname=findViewById(R.id.editTextFullName);
        editTextEmail=findViewById(R.id.editTextEmail);

        loadData();

        buttonSave=findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSave_onClick(view);
            }
        });

    }

    public void buttonSave_onClick(View view){
        try{
            AccountDB accountDB = new AccountDB(getApplicationContext());
            Account currentAccount = accountDB.find(account.getId());
            String newUsername= editTextUsername.getText().toString();
            Account temp = accountDB.checkUsername(newUsername);
            if (!newUsername.equalsIgnoreCase(currentAccount.getUsername()) && temp != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.username_exits);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
                return;
            }
            currentAccount.setUsername(editTextUsername.getText().toString());
            currentAccount.setFullname(editTextFullname.getText().toString());
            currentAccount.setEmail(editTextEmail.getText().toString());
            String password = editTextPassword.getText().toString();
            if(!password.isEmpty()){
                currentAccount.setPassword(editTextPassword.getText().toString());
            }
            if (accountDB.update(currentAccount)){
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.putExtra("account" , currentAccount);
                startActivity(intent);
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.failed);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }

        }catch(Exception e){
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

    private void loadData(){
        Intent intent = getIntent();
        account=(Account) intent.getSerializableExtra("account");
        editTextEmail.setText(account.getEmail());
        editTextFullname.setText(account.getFullname());
        editTextUsername.setText(account.getUsername());
    }
}