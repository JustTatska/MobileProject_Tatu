package com.example.mobileproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Activity for searching through different search engines
public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initializes the search buttons and sets their click listeners
        Button googleButton = findViewById(R.id.btn_google);
        Button bingButton = findViewById(R.id.btn_bing);
        Button duckDuckGoButton = findViewById(R.id.btn_duckduckgo);

        // Set up listeners to open chosen search engine when buttons are clicked
        googleButton.setOnClickListener(v -> openSearchEngine("https://www.google.com"));
        bingButton.setOnClickListener(v -> openSearchEngine("https://www.bing.com"));
        duckDuckGoButton.setOnClickListener(v -> openSearchEngine("https://www.duckduckgo.com"));
    }


    // Opens the specified URL in a web browser.
    private void openSearchEngine(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
