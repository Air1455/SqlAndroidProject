package com.example.sqlandroidproject.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlandroidproject.R;
import com.example.sqlandroidproject.model.User;
import com.example.sqlandroidproject.model.bddSQLaccess;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeMessage;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText ageEditText;
    private EditText jobEditText;
    private Button goButton;
    private User user;
    private Context context;
    private static bddSQLaccess bddSQLaccess;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        firstNameEditText = findViewById ( R.id.inputTextFirstName );
        lastNameEditText = findViewById ( R.id.inputTextLastName );
        ageEditText = findViewById ( R.id.inputTextAge );
        jobEditText = findViewById ( R.id.inputTextJob );
        goButton = findViewById ( R.id.goButton );
        welcomeMessage = findViewById ( R.id.welcomeMessage );
        context = getApplicationContext ();
        bddSQLaccess = new bddSQLaccess ( context );

        goButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText ().toString ();
                String lastName = lastNameEditText.getText ().toString ();
                int age = Integer.parseInt ( ageEditText.getText ().toString () );
                String job = jobEditText.getText ().toString ();

                user = new User(firstName, lastName, age, job);
                bddSQLaccess.ajout ( user );

                User user2 = bddSQLaccess.recupLastInput ();


                String fulltext = "Bienvenue " + user2.getFirstName () + " " + user2.getLastName () + ".\n" + user2.getAge () + " ans\nProfession : " + user2.getJob ();
                Toast.makeText ( context, fulltext, Toast.LENGTH_SHORT ).show ();
                welcomeMessage.setText ( fulltext );
            }
        } );




    }
}
