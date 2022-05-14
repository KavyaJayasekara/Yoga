package com.example.yoga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView tv_4;
    EditText et_username, et_email, et_password, et_repassword;
    private Button btn2;
    private String EmailPattern =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_username = findViewById(R.id.editTextTextPersonName3);
        et_email = findViewById(R.id.editTextTextPersonName5);
        et_password = findViewById(R.id.editTextTextPersonName2);
        et_repassword = findViewById(R.id.editTextTextPersonName4);
        tv_4 = findViewById(R.id.textView4);
        btn2 = (Button)findViewById(R.id.button);

        String text = "<font> Already have an account?</font> <font><b>LOGIN</b></font>";
        tv_4.setText(Html.fromHtml(text));

        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });
    }
    private void SignUpUser() {
        Intent intent = new Intent(SignUpActivity.this, Home.class);
        startActivity(intent);
    }

    private void validateFields() {
        //validate fields
        String username, email, password, repassword;
        username = et_username.getText().toString();
        email=et_email.getText().toString();
        password = et_password.getText().toString();
        repassword = et_repassword.getText().toString();

        if (!(username.isEmpty())) {
            if (!(email.isEmpty())) {
                if (!(password.isEmpty())) {
                    if (!(repassword.isEmpty())) {
                        if (email.matches(EmailPattern)) {
                            if (password.matches(PasswordPattern)) {
                                if (repassword.equals(password)) {
                                    SignUpUser();
                                    Toast.makeText(SignUpActivity.this, "Hello user " + username, Toast.LENGTH_SHORT).show();

                                } else {
                                    et_repassword.setError("Password does not match");
                                }
                            } else {
                                    et_password.setError("Password length should be 8-24");
                                }
                            } else {
                                et_email.setError("Invalid email");
                            }
                        } else {
                            et_repassword.setError("Please fill this");
                        }
                    } else {
                        et_password.setError("Please fill this");
                    }
                } else {
                    et_email.setError("Please fill this");
                }
            } else {
                et_username.setError("Please fill this");
            }
        }
    }






