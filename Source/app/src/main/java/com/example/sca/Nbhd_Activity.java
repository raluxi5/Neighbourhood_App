package com.example.sca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Nbhd_Activity extends AppCompatActivity {

    private ListView nbhd_charact;
    private ListAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nbhd_features);

        Toolbar toolbar = findViewById(R.id.toolbar10);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nbhd_charact = findViewById(R.id.charact_list);
        adapter = new ListAdapter3(Nbhd_Activity.this,Map_Activity.feature_names);
        nbhd_charact.setAdapter(adapter);

        nbhd_charact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Intent arts = new Intent(Nbhd_Activity.this, Arts.class);
                        startActivity(arts);
                        break;
                    case 1:
                        Intent merkur = new Intent(Nbhd_Activity.this, MerkurShop.class);
                        startActivity(merkur);
                        break;
                    case 2:
                        Intent royal = new Intent(Nbhd_Activity.this, RoyalHotel.class);
                        startActivity(royal);
                        break;
                    case 3:
                        Intent artmeis = new Intent(Nbhd_Activity.this, ArtemisHospital.class);
                        startActivity(artmeis);
                        break;
                }

            }
        });


    }



    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }
}
