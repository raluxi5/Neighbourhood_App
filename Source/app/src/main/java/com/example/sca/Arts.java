package com.example.sca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Arts extends AppCompatActivity {

    private ListView feedback_list;
    private ListAdapter2 adapter;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> feedbacks = new ArrayList<String>();
    private Button writefeedB;
    private TextView address;
    private TextView openingh;
    private TextView phonenr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arts_activity);

        Toolbar toolbar = findViewById(R.id.toolbar13);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        address = findViewById(R.id.textView2);
        openingh = findViewById(R.id.textView3);
        phonenr = findViewById(R.id.textView4);

        feedback_list = findViewById(R.id.feedbacks);

        names.add("Jane Doe");
        names.add("Michelle Kringer");
        feedbacks.add("Review1");
        feedbacks.add("Review2");
        names.addAll(WriteFeedback.user_names);
        feedbacks.addAll(WriteFeedback.user_feedbacks);

        adapter = new ListAdapter2(Arts.this, names,feedbacks);

        feedback_list.setAdapter(adapter);

        writefeedB = findViewById(R.id.button);
        writefeedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Arts.this,WriteFeedback.class));
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }
}
