package com.example.sca;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;



public class LoginActivity extends AppCompatActivity {

    //views
    EditText username, mPasswordEt;
    Button mLoginBtn;

    //to be transmitted
    public static String USERNAME_MESSAGE_login;

    public static boolean login = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        username = findViewById(R.id.username_log);
        mPasswordEt = findViewById(R.id.passwordEt);
        mLoginBtn = findViewById(R.id.loginBtn);

        //handle login button click
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input username,password
                String usern = username.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();
                if (password.length()<=6){
                    //set error
                    mPasswordEt.setError("Password length at least 6 characters");
                    mPasswordEt.setFocusable(true);
                }
                else{
                    loginUser(usern,password); //login user
                    startActivity(new Intent(LoginActivity.this, Map_Activity.class));
                }
            }
        });


    }

    private void loginUser(String email, String password) {
        ChatPosts_Activity.count = 1;
        login = true;
        USERNAME_MESSAGE_login = username.getText().toString();
    }

    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }
}
