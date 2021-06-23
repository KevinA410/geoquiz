package com.example.geoquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER = "mainActivity.extra_answer";
    private boolean answer;

    private TextView txtAnswer;
    private Button btnShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answer = getIntent().getBooleanExtra(EXTRA_ANSWER, false);

        txtAnswer = (TextView) findViewById(R.id.txtAnswer);

        btnShowAnswer = (Button) findViewById(R.id.btnShowAnswer);
        btnShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnswer.setText(answer ? R.string.btnTrue : R.string.btnFalse);
            }
        });
    }
}
