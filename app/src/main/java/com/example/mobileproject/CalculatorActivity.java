package com.example.mobileproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button addBtn = findViewById(R.id.addBtn);
        EditText firstNumEditText = findViewById(R.id.firstNumEditText);
        EditText secondNumEditText = findViewById(R.id.secondNumEditText);
        TextView resultTextView = findViewById(R.id.resultTextView);

        addBtn.setOnClickListener(v -> {
            try {
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                resultTextView.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                resultTextView.setText(getString(R.string.invalid_input));
            }
        });
    }
}
