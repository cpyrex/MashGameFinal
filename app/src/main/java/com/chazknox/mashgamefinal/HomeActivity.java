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

public class HomeActivity extends AppCompatActivity {

    public EditText home1EditText;
    public EditText home2EditText;
    public EditText home3EditText;
    public EditText home4EditText;
    public EditText home5EditText;

    public ArrayList<String> homeArrList = new ArrayList<String>();
    public Random random = new Random();

    String msg  = "";
    String msg1 = "";
    String msg2 = "";
    String msg3 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //get values from previous screen
        Bundle data = getIntent().getExtras();
        //check to see if data is null, prevents exceptions
        if(data == null){
            return;
        }
        msg  = data.getString("mry");
        msg1 = data.getString("kids");
        msg2 = data.getString("job");


        home1EditText = (EditText) findViewById(R.id.home1EditText);
        home2EditText = (EditText) findViewById(R.id.home2EditText);
        home3EditText = (EditText) findViewById(R.id.home3EditText);
        home4EditText = (EditText) findViewById(R.id.home4EditText);
        home5EditText = (EditText) findViewById(R.id.home5EditText);

        //add strings to the arraylist
        homeArrList.add(home1EditText.getText().toString());
        homeArrList.add(home2EditText.getText().toString());
        homeArrList.add(home3EditText.getText().toString());
        homeArrList.add(home4EditText.getText().toString());
        homeArrList.add(home5EditText.getText().toString());

        //randomly pick string
        int index = random.nextInt(homeArrList.size());
        msg3 = homeArrList.get(index);
        /*if(msg3 == null) {
            System.out.println("Help Help Help!!!!!!!!!1");
        }*/
    }

    public void homeSubmitButtonClick(View view) {

        Intent intent = new Intent(this, ResultsActivity.class);
        //msg3 = "Help";
        intent.putExtra("mry", msg);
        intent.putExtra("kids", msg1);
        intent.putExtra("job", msg2);
        intent.putExtra("home", msg3);
        startActivity(intent);

    }

    public void homeCancelButtonClick(View view) {
    }
}
