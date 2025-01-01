package com.example.mobileproject;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Main Activity of the app that serves as the entry point to the other activities
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the "Open Calculator" button and sets its click listener
        Button openCalculatorButton = findViewById(R.id.openCalculatorButton);
        openCalculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

        // Initializes the "Open Search Activity" button and sets its click listener
        Button openSearchActivityButton = findViewById(R.id.btn_open_search_activity);
        openSearchActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        // Initializes the "Open Contacts" button and sets its click listener
        Button openContactsButton = findViewById(R.id.btn_open_contacts);
        openContactsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
            startActivity(intent);
        });

        // Initializes the "Login" button and sets its click listener
        Button loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
