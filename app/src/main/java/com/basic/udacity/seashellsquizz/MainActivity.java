package com.basic.udacity.seashellsquizz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.question_1_answer) RadioButton answerOneRadioButton;
    @BindView(R.id.question_2_answer) RadioButton answerTwoRadioButton;
    @BindView(R.id.question_3_answer) RadioButton answerThreeRadioButton;
    @BindView(R.id.question_4_answer) EditText answerFourEditText;
    @BindView(R.id.question_5_answer) RadioButton answerFiveRadioButton;
    @BindView(R.id.question_6_answer_1) CheckBox choiceOneCheckBox;
    @BindView(R.id.question_6_answer_2) CheckBox choiceTwoCheckBox;
    @BindView(R.id.question_6_answer_3) CheckBox choiceThreeCheckBox;
    @BindView(R.id.question_6_answer_4) CheckBox choiceFourCheckBox;
    @BindView(R.id.question_7_answer) RadioButton answerSevenRadioButton;
    @BindView(R.id.question_8_answer) EditText answerEightEditText;
    @BindView(R.id.question_9_answer) RadioButton answerNineRadioButton;
    @BindView(R.id.question_10_answer) EditText answerTenEditText;
    @BindView(R.id.submit_button) Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResults();
            }
        });
    }


    public int calculateScore () {
        int score = 0;

        // Handle question 1
        if (answerOneRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 2
        if (answerTwoRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 3
        if (answerThreeRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 4
        String answerFour  =  answerFourEditText.getText().toString().toLowerCase().trim();
        if(answerFour.equals(getString(R.string.question_4_answer_var_1))
                || answerFour.equals(getString(R.string.question_4_answer_var_2))) {
            score ++;
        }

        // Handle question 5
        if (answerFiveRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 6
        if(!choiceOneCheckBox.isChecked() && !choiceTwoCheckBox.isChecked()
                && choiceThreeCheckBox.isChecked() && choiceFourCheckBox.isChecked()) {
            score ++;
        }

        // Handle question 7
        if (answerSevenRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 8
        String answerEight  =  answerEightEditText.getText().toString().toLowerCase().trim();
        if(answerEight.equals(getString(R.string.question_8_answer_var_1))
                || answerEight.equals(getString(R.string.question_8_answer_var_2))) {
            score ++;
        }

        // Handle question 9
        if (answerNineRadioButton.isChecked()) {
            score ++;
        }

        // Handle question 10
        String answerTen  =  answerTenEditText.getText().toString().toLowerCase().trim();
        if(answerTen.equals(getString(R.string.question_10_answer_var_1))
                || answerTen.equals(getString(R.string.question_10_answer_var_2))) {
            score ++;
        }

        return score;
    }

    private void displayResults() {
        // Final score
        int score = calculateScore();
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

