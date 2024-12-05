package com.example.mobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    private TextView display;
    private final StringBuilder currentInput = new StringBuilder();
    private double firstOperand = 0;
    private String operator = null;

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "×";
    private static final String DIVIDE = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.display);

        View.OnClickListener buttonClickListener = this::onButtonClick;
        int[] buttonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
                R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,
                R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply, R.id.btn_divide,
                R.id.btn_equals, R.id.btn_clear
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(buttonClickListener);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "Clear":
                clear();
                break;
            case ADD:
            case SUBTRACT:
            case MULTIPLY:
            case DIVIDE:
                setOperator(buttonText);
                break;
            case "=":
                calculateResult();
                break;
            default:
                appendNumber(buttonText);
                break;
        }
    }

    private void clear() {
        currentInput.setLength(0);
        firstOperand = 0;
        operator = null;
        display.setText("0");
    }

    private void setOperator(String op) {
        if (currentInput.length() > 0) {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
        }
        operator = op;
    }

    private void appendNumber(String number) {
        if (currentInput.length() == 1 && currentInput.charAt(0) == '0') {
            currentInput.setLength(0);
        }
        currentInput.append(number);
        display.setText(currentInput.toString());
    }

    private void calculateResult() {
        if (currentInput.length() > 0 && operator != null) {
            double secondOperand = Double.parseDouble(currentInput.toString());
            double result;

            switch (operator) {
                case ADD:
                    result = firstOperand + secondOperand;
                    break;
                case SUBTRACT:
                    result = firstOperand - secondOperand;
                    break;
                case MULTIPLY:
                    result = firstOperand * secondOperand;
                    break;
                case DIVIDE:
                    if (secondOperand == 0) {
                        display.setText(getString(R.string.division_by_zero_error)); 
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
                default:
                    return;
            }

            display.setText(String.valueOf(result));
            currentInput.setLength(0);
            firstOperand = result;
            operator = null;
        }
    }
}
