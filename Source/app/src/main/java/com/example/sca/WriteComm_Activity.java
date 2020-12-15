package com.example.sca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class WriteComm_Activity extends AppCompatActivity {

    private TextView commentator;
    private EditText comment;
    private Button commB;

    public static ArrayList<String> user_commentators = new ArrayList<String>();
    public static ArrayList<String> written_comments = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_comment);


        //Actionbar and logo
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setIcon(R.drawable.logo3);

        //enable back button
        //actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        commentator = findViewById(R.id.commentator);
        comment = findViewById(R.id.comment);
        commB = findViewById(R.id.commB);


        if(ChatPosts_Activity.count == 0)
            commentator.setText(Create_Acc.USERNAME_MESSAGE_create);
        else if(ChatPosts_Activity.count == 1)
            commentator.setText(LoginActivity.USERNAME_MESSAGE_login);

       commB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_commentators.add(commentator.getText().toString());
                written_comments.add(comment.getText().toString());
                Toast.makeText(WriteComm_Activity.this, "Your comment was succesfully added! " ,
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(WriteComm_Activity.this, Comm_Activity.class));
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }


}
