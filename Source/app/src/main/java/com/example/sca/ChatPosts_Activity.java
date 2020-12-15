package com.example.sca;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ChatPosts_Activity extends AppCompatActivity implements ListAdapter1.customButtonListener{

    private TextView username1;
    private EditText post1;
    private Button postButton;


    private ListView posts_list;
    ListAdapter1 adapter;
    //usernames of the users who made a post
    public static ArrayList<String> userNAMES = new ArrayList<String>();
    //posts of the users
    public static ArrayList<String> userPOSTS = new ArrayList<String>();
    //count for choosing the username from login or for create account
    //0 for create account
    //1 for login
    public static int count=2;
    //position of the post
    public static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatposts);

        Toolbar toolbar = findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        username1 = findViewById(R.id.username);
        //username1 set text from register or login page USERNAME_MESSAGE
        if(count == 0)
            username1.setText(Create_Acc.USERNAME_MESSAGE_create);
        else if(count == 1)
            username1.setText(LoginActivity.USERNAME_MESSAGE_login);

        post1 = findViewById(R.id.post);
        post1.getText().toString();
        postButton = findViewById(R.id.postB);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0)
                    userNAMES.add(Create_Acc.USERNAME_MESSAGE_create);
                else if(count == 1)
                    userNAMES.add(LoginActivity.USERNAME_MESSAGE_login);
                userPOSTS.add(post1.getText().toString());
                //startActivity(new Intent(ChatPosts_Activity.this,ChatPosts_Activity.class));
            }
        });

        posts_list = findViewById(R.id.posts_list);

        userNAMES.add("Michael Blue");
        userNAMES.add("Jane Radzinski");
        userPOSTS.add("I want to know more about that new coffee house that has opened on the Jasonerie Street. Please contact me if you are interested in grabbing a coffee :).");
        userPOSTS.add("I love the feeling in this neighbourhood! It s a sense of community I haven't experienced before!");

        adapter = new ListAdapter1(ChatPosts_Activity.this, userNAMES,userPOSTS);
        adapter.setCustomButtonListner(ChatPosts_Activity.this);
        posts_list.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public void onButtonClickListner(int position, String value) {
        this.position = position;
        Intent result = new Intent(ChatPosts_Activity.this, WriteComm_Activity.class);
        startActivity(result);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.action_write:
           showSoftKeyboard(post1);
    }
        return(super.onOptionsItemSelected(item));
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }


    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }

}
