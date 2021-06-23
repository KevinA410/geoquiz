package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtQuestion;
    private Button btnTrue;
    private Button btnFalse;
    private Button btnPrev;
    private Button btnNext;
    private Button btnCheat;

    private int currentIndex;
    private Question[] questions = {
            new Question(R.string.questionOceans, true),
            new Question(R.string.questionMideast, false),
            new Question(R.string.questionAfrica, false),
            new Question(R.string.questionAmericas, true),
            new Question(R.string.questionAsia, true)
    };

    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);

        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                checkAnswer(true);
            }
        });

        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                checkAnswer(false);
            }
        });

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                if(currentIndex > 0) {
                    currentIndex -= 1;
                    updateQuestion();
                }
            }
        });

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                if(currentIndex < questions.length-1){
                    currentIndex += 1;
                    updateQuestion();
                }
            }
        });

        btnCheat = (Button) findViewById(R.id.btnCheat);
        btnCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Intent i = new Intent(MainActivity.this, CheatActivity.class);
                i.putExtra(CheatActivity.EXTRA_ANSWER, questions[currentIndex].getAnswer());
                startActivity(i);
            }
        });

        currentIndex = (savedInstanceState != null) ? savedInstanceState.getInt(KEY_INDEX, 0) : 0;
        updateQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, currentIndex);
    }

    //METHODS
    private void updateQuestion(){
        int question = questions[currentIndex].getQuestion();
        txtQuestion.setText(question);
    }

    private void checkAnswer(boolean userPressed){
        boolean answer = questions[currentIndex].getAnswer();
        int message = (answer == userPressed) ? R.string.correctToast : R.string.incorrectToast;

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}