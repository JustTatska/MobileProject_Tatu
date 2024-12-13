package com.example.mobileproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button googleButton = findViewById(R.id.btn_google);
        Button bingButton = findViewById(R.id.btn_bing);
        Button duckDuckGoButton = findViewById(R.id.btn_duckduckgo);

        googleButton.setOnClickListener(v -> openSearchEngine("https://www.google.com"));
        bingButton.setOnClickListener(v -> openSearchEngine("https://www.bing.com"));
        duckDuckGoButton.setOnClickListener(v -> openSearchEngine("https://www.duckduckgo.com"));
    }

    private void openSearchEngine(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
