package com.example.sca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class WriteFeedback extends AppCompatActivity {

    public static ArrayList<String> user_names = new ArrayList<String>();
    public static ArrayList<String> user_feedbacks = new ArrayList<String>();

    private TextView name;
    private EditText feedback;
    private Button feedB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefeedback);

        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Actionbar and logo
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setIcon(R.drawable.logo3);

        //enable back button
        //actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.name);
        feedback = findViewById(R.id.feedback);

        if(ChatPosts_Activity.count == 0)
            name.setText(Create_Acc.USERNAME_MESSAGE_create);
        else if(ChatPosts_Activity.count == 1)
            name.setText(LoginActivity.USERNAME_MESSAGE_login);

        feedB = findViewById(R.id.feedB);
        feedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_names.add(name.getText().toString());
                user_feedbacks.add(feedback.getText().toString());
                Toast.makeText(WriteFeedback.this, "Your feedback was succesfully sent! " ,
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(WriteFeedback.this, Arts.class));
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }



}
