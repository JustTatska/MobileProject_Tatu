package com.example.mobileproject3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.mobileproject3.ITEM_INDEX", -1);


        if(index > -1){
            int pic = getImage(index);
            ImageView img = findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getImage(int index){
        switch(index){
            case 0: return R.drawable.peach;
            case 1: return R.drawable.squash;
            case 2: return R.drawable.tomato;
            default: throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    private void scaleImg(ImageView img, int pic) {
        WindowManager windowManager = getWindowManager();
        Display screen = windowManager.getDefaultDisplay();
        Point size = new Point();
        screen.getSize(size);
        int screenWidth = size.x;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        int imgWidth = options.outWidth;

        if (imgWidth > screenWidth) {
            options.inSampleSize = Math.round((float) imgWidth / (float) screenWidth);
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }


}