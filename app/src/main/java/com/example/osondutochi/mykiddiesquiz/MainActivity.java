package com.example.osondutochi.mykiddiesquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private TextView questionNumberTextView;

    private Button optionAButton;
    private Button optionBButton;
    private Button optionCButton;
    private Button optionDButton;

//    private Button previousButton;
//    private Button nextButton;

    private int correctAnswerCounter = 0;
    private int totalNumberOfQuestion = 0;
    private String questionCorrectAnswer;

    //Create an instance of the QuestionLibrary Class.
    private QuestionLibrary questionLibrary = new QuestionLibrary();

    //Get the length of the question from the QuestionLibrary class.
    private int questionLengthCounter = questionLibrary.questionPull.length;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializerVariables();

        optionAButton.setOnClickListener(this);
        optionBButton.setOnClickListener(this);
        optionCButton.setOnClickListener(this);
        optionDButton.setOnClickListener(this);

//        ArrayList<Integer> number = new ArrayList<Integer>();
//        questionLengthCounter = questionLibrary.questionPull.length;
//        for (int i = 0; i <= questionLengthCounter; i++) {
//            number.add(i);
//        }

        random = new Random();
        NextQuestionInTheQueue(random.nextInt(questionLengthCounter));

    }

    private void initializerVariables() {
        questionTextView = findViewById(R.id.question_TextView);
        questionNumberTextView = findViewById(R.id.questionNumber_TextView);

        optionAButton = findViewById(R.id.optionA_Button);
        optionBButton = findViewById(R.id.optionB_Button);
        optionCButton = findViewById(R.id.optionC_Button);
        optionDButton = findViewById(R.id.optionD_Button);

//        previousButton = findViewById(R.id.previous_Button);
//        nextButton = findViewById(R.id.next_Button);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.optionA_Button:
                if (optionAButton.getText() == questionCorrectAnswer) {
                    correctAnswerCounter = correctAnswerCounter +1;
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                else {
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                break;
            case R.id.optionB_Button:
                if (optionAButton.getText() == questionCorrectAnswer) {
                    correctAnswerCounter = correctAnswerCounter +1;
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                else {
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                break;

            case R.id.optionC_Button:
                if (optionAButton.getText() == questionCorrectAnswer) {
                    correctAnswerCounter = correctAnswerCounter +1;
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                else {
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                break;

            case R.id.optionD_Button:
                if (optionAButton.getText() == questionCorrectAnswer) {
                    correctAnswerCounter = correctAnswerCounter +1;
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                else {
                    questionNumberTextView.setText("Question: " + totalNumberOfQuestion);
                    NextQuestionInTheQueue(random.nextInt(questionLengthCounter));
                }
                break;
        }
    }

    private void NextQuestionInTheQueue(int i) {
        if (totalNumberOfQuestion < questionLibrary.questionPull.length) {
            //Setting the question counter to its current number and displaying it.
            totalNumberOfQuestion ++;
            questionNumberTextView.setText("Question: " + totalNumberOfQuestion);

            //Pull the each question and their corresponding options.
            questionTextView.setText(questionLibrary.getEachQuestion(i));
            optionAButton.setText(questionLibrary.getChoice1(i));
            optionBButton.setText(questionLibrary.getChoice2(i));
            optionCButton.setText(questionLibrary.getChoice3(i));
            optionDButton.setText(questionLibrary.getChoice4(i));

            //Now lets fetch the correct answers and pass it to the questionCorrectAnswer String.
            questionCorrectAnswer = questionLibrary.getCorrectAnswers(i);
        }
        else {
            Toast.makeText(this, "It's the end of the quiz!", Toast.LENGTH_SHORT).show();

            //Start a new Activity to display the final score
            Intent displayResultIntent = new Intent(MainActivity.this, ResultActivity.class);
            displayResultIntent.putExtra("finalScores", correctAnswerCounter);
            startActivity(displayResultIntent);
        }
    }
}
