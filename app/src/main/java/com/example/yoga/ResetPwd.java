package com.example.yoga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPwd extends AppCompatActivity {

    private Button done;
    EditText et_password, et_repassword;
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);


        et_password = findViewById(R.id.editTextTextPersonName2);
        et_repassword = findViewById(R.id.editTextTextPersonName4);
        done =(Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });
    }

    private void validateFields() {
        String password, repassword;
        password = et_password.getText().toString();
        repassword=et_repassword.getText().toString();
        if (!(password.isEmpty())) {
            if (!(repassword.isEmpty())) {
                if (password.matches(PasswordPattern)) {
                    if (repassword.equals(password)) {
                    Toast.makeText(ResetPwd.this, "Password reset successful!", Toast.LENGTH_SHORT).show();
                    LogUser();
                } else {
                    et_repassword.setError("Password does not match");
                }
            }else {
                    et_password.setError("Password length should be 8-24");

                }
            } else {
                et_repassword.setError("Please fill this");
            }
        } else {
            et_password.setError("Please fill this");
        }
    }

    private void LogUser() {
            Intent intent = new Intent(ResetPwd.this, LoginActivity.class);
            startActivity(intent);
    }

}