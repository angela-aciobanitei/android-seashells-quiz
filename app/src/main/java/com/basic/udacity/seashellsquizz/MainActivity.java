package com.basic.udacity.seashellsquizz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        // this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers (View view) {
        int score = 0;

        // Handle question 1
        RadioButton answerOneRadioButton = (RadioButton)findViewById(R.id.question_1_answer);
        if (answerOneRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 2
        RadioButton answerTwoRadioButton = (RadioButton)findViewById(R.id.question_2_answer);
        if (answerTwoRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 3
        RadioButton answerThreeRadioButton = (RadioButton)findViewById(R.id.question_3_answer);
        if (answerThreeRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 4
        EditText answerFourEditText = (EditText)findViewById(R.id.question_4_answer);
        String answerFour  =  answerFourEditText.getText().toString().toLowerCase().trim();
        if(answerFour.equals("wentletrap") || answerFour.equals("wentletraps")) {
            score += 1;
        }

        // Handle question 5
        RadioButton answerFiveRadioButton = (RadioButton)findViewById(R.id.question_5_answer);
        if (answerFiveRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 6
        CheckBox choiceOneCheckBox = (CheckBox)findViewById(R.id.question_6_answer_1);
        boolean  choiceOne = choiceOneCheckBox.isChecked();

        CheckBox choiceTwoCheckBox = (CheckBox)findViewById(R.id.question_6_answer_2);
        boolean  choiceTwo = choiceTwoCheckBox.isChecked();

        CheckBox choiceThreeCheckBox = (CheckBox)findViewById(R.id.question_6_answer_3);
        boolean  choiceThree = choiceThreeCheckBox.isChecked();

        CheckBox choiceFourCheckBox = (CheckBox)findViewById(R.id.question_6_answer_4);
        boolean  choiceFour = choiceFourCheckBox.isChecked();

        if(!choiceOne && !choiceTwo && choiceThree && choiceFour) {
            score +=1;
        }

        // Handle question 7
        RadioButton answerSevenRadioButton = (RadioButton)findViewById(R.id.question_7_answer);
        if (answerSevenRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 8
        EditText answerEightEditText = (EditText)findViewById(R.id.question_8_answer);
        String answerEight  =  answerEightEditText.getText().toString().toLowerCase().trim();
        if(answerEight.equals("cockle") || answerEight.equals("cockles")) {
            score +=1;
        }

        // Handle question 9
        RadioButton answerNineRadioButton = (RadioButton)findViewById(R.id.question_9_answer);
        if (answerNineRadioButton.isChecked()) {
            score +=1;
        }

        // Handle question 10
        EditText answerTenEditText = (EditText)findViewById(R.id.question_10_answer);
        String answerTen  =  answerTenEditText.getText().toString().toLowerCase().trim();
        if(answerTen.equals("ark") || answerTen.equals("arks")) {
            score +=1;
        }

        // Final score
        CharSequence displayResults;
        if (score == 10){
            displayResults = "Perfect! You scored 10 out of 10";
        }
        else {
            displayResults = "Try again. You scored " + score + " out of 10";
        }

        // Set up a Toast to display the the results.
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, displayResults, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

