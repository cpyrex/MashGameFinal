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

public class KidsActivity extends AppCompatActivity {


    public EditText kids1EditText;
    public EditText kids2EditText;
    public EditText kids3EditText;
    public EditText kids4EditText;
    public EditText kids5EditText;

    public ArrayList<String> kidsArrList = new ArrayList<String>();
    public Random random = new Random();

    String kid1 = "";
    String msg = "";
    String msg1 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get values from previous screen
        Bundle data = getIntent().getExtras();
        //check to see if dat iks null, prevents exceptions
        if(data == null){
            return;
        }

        msg  = data.getString("mry");



        kids1EditText = (EditText) findViewById(R.id.kids1EditText);
        kids2EditText = (EditText) findViewById(R.id.kids2EditText);
        kids3EditText = (EditText) findViewById(R.id.kids3EditText);
        kids4EditText = (EditText) findViewById(R.id.kids4EditText);
        kids5EditText = (EditText) findViewById(R.id.kids5EditText);

        //add strings to the arraylist
        kidsArrList.add(kids1EditText.getText().toString());
        kidsArrList.add(kids2EditText.getText().toString());
        kidsArrList.add(kids3EditText.getText().toString());
        kidsArrList.add(kids4EditText.getText().toString());
        kidsArrList.add(kids5EditText.getText().toString());

        //randomly pick string
        int index = random.nextInt(kidsArrList.size());
        msg1 = kidsArrList.get(index);



    }



    public void kidsSubmitButtonClick(View view) {

       Intent intent = new Intent(this, JobActivity.class);

        intent.putExtra("mry", msg);
        intent.putExtra("kids", msg1);
        startActivity(intent);
    }

    public void kidsCancelButtonClick(View view) {

    }
}


