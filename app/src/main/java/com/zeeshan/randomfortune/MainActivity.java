package com.zeeshan.randomfortune;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
      nextInt() isn't the best for generating truly random results.
      Time to skew it and do it the+ zeeshan way.
      Populate a list with 50 numbers, shuffle that list and then pick 6.
      You have your guaranteed set of random numbers :)
     */
    public void click(View v) {
        TextView rndNumber = (TextView) findViewById(R.id.rndText);
        List<Integer> mainList = new ArrayList<>();
        List<Integer> starList = new ArrayList<>();
        rndNumber.setText("");

        //populate list for five main numbers
        for (int i = 1; i <=50; i++) {
            mainList.add(i);
        }

        //populate list for 2 lucky stars.
        for (int i = 1; i <=11; i++) {
            starList.add(i);
        }

        //Shuffle both lists for randomness
        Collections.shuffle(mainList);
        Collections.shuffle(starList);

        //Obtain first 5 numbers and store result
        int num1 = mainList.get(0);
        int num2 = mainList.get(1);
        int num3 = mainList.get(2);
        int num4 = mainList.get(3);
        int num5 = mainList.get(4);

        //obtain first 2 lucky stars and store result
        int firstStar = starList.get(0);
        int secondStar = starList.get(1);

        //convert int to strings.
        String number1 = String.valueOf(num1);
        String number2 = String.valueOf(num2);
        String number3 = String.valueOf(num3);
        String number4 = String.valueOf(num4);
        String number5 = String.valueOf(num5);

        String starOne = String.valueOf(firstStar);
        String starTwo = String.valueOf(secondStar);

       //Concatenate strings
       rndNumber.setText(number1 + "," + number2 + "," + number3 + "," + number4 + "," + number5
               + " " + starOne + "," + starTwo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
