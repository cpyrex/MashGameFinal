package com.chazknox.mashgamefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;



public class JobActivity extends AppCompatActivity {

        public EditText job1EditText;
        public EditText job2EditText;
        public EditText job3EditText;
        public EditText job4EditText;
        public EditText job5EditText;

        public ArrayList<String> jobArrList = new ArrayList<String>();
        public Random random = new Random();

        //String job1 = "";
        String msg  = "";
        String msg1 = "";
        String msg2 = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_job);

            //get values from previous screen
            Bundle data = getIntent().getExtras();
            //check to see if dat iks null, prevents exceptions
            if(data == null){
                return;
            }
            msg  = data.getString("mry");
            msg1  = data.getString("kids");


            job1EditText = (EditText) findViewById(R.id.job1EditText);
            job2EditText = (EditText) findViewById(R.id.job2EditText);
            job3EditText = (EditText) findViewById(R.id.job3EditText);
            job4EditText = (EditText) findViewById(R.id.job4EditText);
            job5EditText = (EditText) findViewById(R.id.job5EditText);

            //add strings to the arraylist
            jobArrList.add(job1EditText.getText().toString());
            jobArrList.add(job2EditText.getText().toString());
            jobArrList.add(job3EditText.getText().toString());
            jobArrList.add(job4EditText.getText().toString());
            jobArrList.add(job5EditText.getText().toString());

            //randomly pick string
            int index = random.nextInt(jobArrList.size());
            msg2 = jobArrList.get(index);

        }

        public void jobSubmitButtonClick(View view) {

            Intent intent = new Intent(this, HomeActivity.class);

            intent.putExtra("mry", msg);
            intent.putExtra("kids", msg1);
            intent.putExtra("job", msg2);
            startActivity(intent);
        }

        public void jobCancelButtonClick(View view) {
        }
    }
