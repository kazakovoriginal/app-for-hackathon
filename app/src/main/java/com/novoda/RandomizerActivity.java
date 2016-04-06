package com.novoda;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by andreykazakov on 26.03.16.
 */
public class RandomizerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizer);

//        Randomizer rand = new Randomizer();
        ArrayList<String> res = new ArrayList<>();
        try {
             res = Randomizer.methodName();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }






//in your OnCreate() method

        String result = "";

        result = "Страна: " + res.get(1) + "\n Место: " + res.get(2) + "\n Развлечения: " + res.get(0) + "\n Описание : Рекомендованный способ добраться - на самолёте. " + res.get(3);

        TextView myAwesomeTextView = new TextView(this);

        myAwesomeTextView.setText(result);

        LinearLayout layout = (LinearLayout) findViewById(R.id.random);

        myAwesomeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        myAwesomeTextView.setTextColor(Color.BLACK);

        layout.addView(myAwesomeTextView);


        //cm = (CriteriaManager) getIntent().getSerializableExtra("CritManager");
    }

}
