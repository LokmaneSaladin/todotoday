package com.example.todotoday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mGreeting;
    private EditText mInputName;
    private Button bStartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreeting = (TextView)findViewById(R.id.activity_main_question);
        mInputName = (EditText)findViewById(R.id.activity_main_name_input);
        bStartButton = (Button)findViewById(R.id.activity_main_start_button);

        bStartButton.setEnabled(false);
        mInputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bStartButton.setEnabled(isNameCorrect(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean isNameCorrect(String name){
        return name.matches ("\\w+\\.?");
    }
}