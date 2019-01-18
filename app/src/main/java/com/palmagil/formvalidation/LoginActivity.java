package com.palmagil.formvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.palmagil.formvalidation.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // Initialization
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreateAccount;
    String username, password;
    int formsuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);

        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin :
                // Function of button Login once it was clicked

                formsuccess= 2; // 2 since we do have 2 objects to validate

                username = etUsername.getText() .toString();
                password = etPassword.getText() .toString();

                // Check if username is null
                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--; // always minus 1 the formsuccess if the form has an error
                }
                // Check if password is null
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--; // always minus 1 the formsuccess if the form has an error

                }
                // Check if form is successfully validated
                if (formsuccess == 2) {
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tvCreateAccount:
                Intent signup = new Intent(this, SignupActivity.class);
                startActivity (signup);
                break;
        }
    }
}