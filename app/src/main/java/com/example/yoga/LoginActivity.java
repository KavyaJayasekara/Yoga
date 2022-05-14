package com.example.yoga;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView tv_4, tv_3;
    private Button btn1;
    EditText et_username, et_password;
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.editTextTextPersonName1);
        et_password = findViewById(R.id.editTextTextPersonName2);
        tv_4 = findViewById(R.id.textView4);
        tv_3 = findViewById(R.id.textView3);

        String text = "<font> Don't have an account?</font> <font><b>SIGNUP</b></font>";
        tv_4.setText(Html.fromHtml(text));
        
        btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });

        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this,ResetPwd.class);
                startActivity(intent);
            }
        });
    }
    private void LogUser() {
        Intent intent = new Intent(LoginActivity.this, Home.class);
        startActivity(intent);
    }


    private void validateFields() {
        //validate fields
        String username, password;
        username = et_username.getText().toString();
        password = et_password.getText().toString();

        if (!(username.isEmpty())) {
            if (!(password.isEmpty())) {
                if (password.matches(PasswordPattern)) {
                    LogUser();
                    Toast.makeText(LoginActivity.this, "Hello user " + username, Toast.LENGTH_SHORT).show();
                } else {
                    et_password.setError("Password length should be 8-24");
                }
            } else {
                et_password.setError("Please fill this");
            }
        } else {
            et_username.setError("Please fill this");
        }
    }

}