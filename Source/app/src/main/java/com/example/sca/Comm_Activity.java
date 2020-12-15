package com.example.sca;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Comm_Activity extends AppCompatActivity {

    private ListView comments_list;
    ListAdapter2 adapter;
    //usernames of the users who made a comment
    ArrayList<String> userNames = new ArrayList<String>();
    //comments of the users
    ArrayList<String> userComments = new ArrayList<String>();

    TextView org_post;
    TextView org_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comments);


        Toolbar toolbar = findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);
        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        org_user = findViewById(R.id.org_user);
        org_post = findViewById(R.id.org_post);
        org_user.setText(ChatPosts_Activity.userNAMES.get(ChatPosts_Activity.position));
        org_post.setText(ChatPosts_Activity.userPOSTS.get(ChatPosts_Activity.position));

        comments_list = findViewById(R.id.comments_list);

        userNames.add("Anna Wardh");
        userNames.add("Otto Kringer");
        userComments.add("Hey! Yes, I empathize entirely with you. Xoxo");
        userComments.add("Yeah man! Send me your phone number!");
        userNames.addAll(WriteComm_Activity.user_commentators);
        userComments.addAll(WriteComm_Activity.written_comments);

        adapter = new ListAdapter2(Comm_Activity.this, userNames,userComments);

        comments_list.setAdapter(adapter);






    }
    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }



}
