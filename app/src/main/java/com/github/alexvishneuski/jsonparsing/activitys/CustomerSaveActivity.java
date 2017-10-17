package com.github.alexvishneuski.jsonparsing.activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.alexvishneuski.jsonparsing.R;

public class CustomerSaveActivity extends AppCompatActivity {

        //private ICalculator mCalculator = new Calculator();
        private EditText mInputEditText;
    private TextView mResultTextView;

        private View mSaveButton;

        @Override
        protected void onCreate(@Nullable Bundle pSavedInstanceState) {
            super.onCreate(pSavedInstanceState);
            setContentView(R.layout.activity_customer_save);
            initView();
        }

        @Override
        protected void onStart() {
            super.onStart();
        }



        private void initView() {
            mInputEditText = (EditText) findViewById(R.id.input_field_edit_text);
            mSaveButton = findViewById(R.id.save_button);
            mSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                /*String result = mCalculator.evaluate(mInputEditText.getText().toString());
                showResult(result);*/
                     new CustomerAsyncTask().execute(new Pair<Context, String>(CustomerSaveActivity.this, "Manfred"));
                    //new UserListLoader().execute(CalculatorActivity.this);
                }
            });

            mInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                /*int length = editable.length();
                if (length > 0) {
                    mCalculateButton.setEnabled(true);
                } else {
                    mCalculateButton.setEnabled(false);
                }*/
                }
            });

            mResultTextView = (TextView) findViewById(R.id.result_text_view);
        }

        private void showResult(String result) {
            mResultTextView.setText(result);
        }


    }


