package com.example.sca;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Create_Acc extends AppCompatActivity {

    //layout elements
    private TextView entryText;
    private EditText firstName;
    private EditText lastName;
    private EditText street;
    private EditText number;
    private EditText zipcode;
    private EditText city;
    private Spinner userStatus;
    private EditText email;
    private EditText userName;
    private EditText password;
    private Button registerButton;

    //to be transmitted!
    public static String USERNAME_MESSAGE_create;

    public static boolean createaccount = false;

    //Spinner for status - deutsch
    private ArrayList<String> statuse_de = new ArrayList<String>(){{
        add("Status");
        add("Bewohner");
        add("Gast");
    }};
    //Spinner for status - englisch
    private ArrayList<String> statuse_en = new ArrayList<String>(){{
        add("Status");
        add("Resident");
        add("Guest");
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc);


        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.logo3);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //layout elements
        entryText = findViewById(R.id.entryText);
        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        street = findViewById(R.id.Street);
        number = findViewById(R.id.Number);
        zipcode = findViewById(R.id.ZIP);
        city = findViewById(R.id.City);

        //set language to spinner
        if(MainActivity.language_check==0) {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    new ArrayList<String>(statuse_de)
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            userStatus = findViewById(R.id.Status);
            userStatus.setAdapter(adapter);
        }else{
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    new ArrayList<String>(statuse_en)
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            userStatus = findViewById(R.id.Status);
            userStatus.setAdapter(adapter);
        }

        email = findViewById(R.id.Email);
        userName = findViewById(R.id.Username_reg);
        password = findViewById(R.id.Password);

        registerButton = findViewById(R.id.buttonRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = "fname";
                String lname = "lname";
                String Semail = "Semail";
                String Susername = "Susername";
                String Spassword = "Spassword";
                fname = firstName.getText().toString();
                lname = lastName.getText().toString();
                Semail = email.getText().toString();
                Susername = userName.getText().toString();
                Spassword = password.getText().toString();

                //not a correct registration errors
                if(fname=="fname" || lname=="lname" || Susername=="Susername" || Semail=="Semail" || Spassword=="Spassword" || Spassword.length()<=6) {
                    Toast.makeText(Create_Acc.this, "Couldn't create account!",
                            Toast.LENGTH_SHORT).show();
                    if (fname == null) {
                        firstName.setError("This field is mandatory!");
                        firstName.setFocusable(true);
                    } else if (lname == null) {
                        lastName.setError("This field is mandatory!");
                        lastName.setFocusable(true);
                    } else if (Semail == null) {
                        email.setError("This field is mandatory");
                        email.setFocusable(true);
                    } else if (Susername == null) {
                        userName.setError("This field is mandatory");
                        userName.setFocusable(true);
                    } else if (Spassword == null) {
                        password.setError("This field is mandatory");
                        password.setFocusable(true);
                    } else if (Spassword.length() <= 6) {
                        password.setError("Password length at least 6 characters");
                        password.setFocusable(true);
                    }
                }else {
                    createaccount = true;
                    ChatPosts_Activity.count = 0;
                    USERNAME_MESSAGE_create = Susername;
                    Toast.makeText(Create_Acc.this, R.string.toasttest_success,
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Create_Acc.this, Next_onCreateAccount.class));
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
