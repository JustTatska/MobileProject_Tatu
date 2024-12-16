package com.example.mobileproject2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button secondActivityBtn = (Button) findViewById(R.id.SecondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("come.example.mobileproject.Testdrive", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });
        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "https://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);

                // Debugging logs
                PackageManager pm = getPackageManager();
                List<ResolveInfo> activities = pm.queryIntentActivities(gotoGoogle, PackageManager.MATCH_DEFAULT_ONLY);

                if (activities.isEmpty()) {
                    Log.e("MainActivity", "No app can handle this intent");
                    Toast.makeText(MainActivity.this, "No app available to handle this link", Toast.LENGTH_SHORT).show();
                } else {
                    for (ResolveInfo info : activities) {
                        Log.d("MainActivity", "App available to handle intent: " + info.activityInfo.packageName);
                    }
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}