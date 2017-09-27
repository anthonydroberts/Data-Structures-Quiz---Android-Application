package com.tonydroberts.datastructuresyou;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.tonydroberts.datastructuresyou.R.color.green;

public class MainActivity extends AppCompatActivity {
    private Questions bank = new Questions();

    private int score = 0; private int QuestionNum = 0; //tracking score and current question number(will be incremented every question)

    private ImageView ScoreBackground;
    private TextView ScoreView;
    private TextView QuestionView;
    private Button ButtonChoice1;
    private Button ButtonChoice2;
    private Button ButtonChoice3;
    private Button ButtonChoice4;
    private int correctAnswer; //(1-4, corresponding to each button)
    private String correctAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link it all together
        ScoreBackground = (ImageView) findViewById(R.id.score_background);
        ScoreView = (TextView)findViewById(R.id.score_text);
        QuestionView = (TextView)findViewById(R.id.question_text);
        ButtonChoice1 = (Button)findViewById(R.id.button1);
        ButtonChoice2 = (Button)findViewById(R.id.button2);
        ButtonChoice3 = (Button)findViewById(R.id.button3);
        ButtonChoice4 = (Button)findViewById(R.id.button4);

        bank.shuffle();
        nextQuestion(); // set the first question

        ButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (correctAnswer == 1){
                    updateScore(1);
                    nextQuestion();

                }else {
                    updateScore(0);
                    Toast.makeText(getApplicationContext(), "Correct answer was: "+correctAnswerText, Toast.LENGTH_LONG).show();
                    nextQuestion();
                }
            }
        });
        ButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (correctAnswer == 2){
                    updateScore(1);
                    nextQuestion();

                }else {
                    updateScore(0);
                    Toast.makeText(getApplicationContext(), "Correct answer was: "+correctAnswerText, Toast.LENGTH_LONG).show();
                    nextQuestion();
                }
            }
        });
        ButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (correctAnswer == 3){
                    updateScore(1);
                    nextQuestion();

                }else {
                    updateScore(0);
                    Toast.makeText(getApplicationContext(), "Correct answer was: "+correctAnswerText, Toast.LENGTH_LONG).show();
                    nextQuestion();
                }
            }
        });
        ButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (correctAnswer == 4){
                    updateScore(1);
                    nextQuestion();

                }else {
                    updateScore(0);
                    Toast.makeText(getApplicationContext(), "Correct answer was: "+correctAnswerText, Toast.LENGTH_LONG).show();
                    nextQuestion();
                }
            }
        });

    }

    private void nextQuestion(){
        if(QuestionNum >= bank.getBankSize()) {
            QuestionNum = 0;
            Toast.makeText(getApplicationContext(), "You finished the quiz! The questions are now re-shuffled!", Toast.LENGTH_LONG).show();
            bank.shuffle(); //reshuffle after user has completed the quiz once
        }
        QuestionView.setText(bank.getQuestion(QuestionNum));
        ButtonChoice1.setText(bank.getChoice1(QuestionNum));
        ButtonChoice2.setText(bank.getChoice2(QuestionNum));
        ButtonChoice3.setText(bank.getChoice3(QuestionNum));
        ButtonChoice4.setText(bank.getChoice4(QuestionNum));
        correctAnswer = bank.getCorrectAnswer(QuestionNum);
        if(correctAnswer == 1) correctAnswerText = ButtonChoice1.getText().toString();
        else if(correctAnswer == 2) correctAnswerText = ButtonChoice2.getText().toString();
        else if(correctAnswer == 3) correctAnswerText = ButtonChoice3.getText().toString();
        else if(correctAnswer == 4) correctAnswerText = ButtonChoice4.getText().toString();
        QuestionView.startAnimation(getBlinkAnimation());
        QuestionNum++;
    }


    private void updateScore(int correct) {
        if(correct == 1){
            ScoreBackground.setBackgroundColor(Color.parseColor("#5bc625"));
            ScoreView.startAnimation(getBlinkAnimation());
            score++;
            ScoreView.setText("" + score);
        }
        else{
            ScoreBackground.setBackgroundColor(Color.parseColor("#8c0f04"));
            ScoreView.startAnimation(getBlinkAnimation());
            score--;
            ScoreView.setText("" + score);
        }


    }


    public Animation getBlinkAnimation(){
        Animation animation = new AlphaAnimation(1, 0);         // Change alpha from fully visible to invisible
        animation.setDuration(350);
        animation.setInterpolator(new LinearInterpolator());    // do not alter animation rate
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);             // Reverse animation at the end so the button will fade back in

        return animation;
    }

}

