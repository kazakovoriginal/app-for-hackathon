package com.novoda;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by andreykazakov on 26.03.16.
 */
public class FinalActivity extends Activity {

    HashMap<Button,CriteriaBoolean> HM = new HashMap<Button, CriteriaBoolean>();

    private View.OnClickListener listener    =   new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (HM.get((Button)v).getBool()){
                v.setBackgroundColor(Color.BLACK);
                HM.put((Button) v, new CriteriaBoolean(HM.get((Button)v).getCriteria(), false));

            }
            else {
                v.setBackgroundColor(Color.GRAY);
                HM.put((Button)v,new CriteriaBoolean(HM.get((Button)v).getCriteria(), true));
            }



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);

        CriteriaManager.select("cities");
        ArrayList<City> cities = CriteriaManager.getSelectedCities();
        Button btn[] = new Button[cities.size()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.final_act);
        if(cities.size() == 0) {
            TextView tv = new TextView(this);
            tv.setText("Нет результатов");
            layout.addView(tv);
        }

        for (int i = 0; i < cities.size(); i++) {
            btn[i] = new Button(this);
            btn[i].setText(cities.get(i).getName());
            btn[i].setOnClickListener(listener);
            HM.put(btn[i], new CriteriaBoolean(cities.get(i), false));

            layout.addView(btn[i]);
        }

    }

}
