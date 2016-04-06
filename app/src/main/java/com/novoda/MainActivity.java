package com.novoda;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by andreykazakov on 25.03.16.
 */
public class MainActivity extends Activity {

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
        setContentView(R.layout.activity_main);
        //загрузка
        //cm = (CriteriaManager)getIntent().getSerializableExtra("CritManager");
        ArrayList<Season> seasons = CriteriaManager.getSelectedSeasons();
        Button btn[] = new Button[seasons.size()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.test);

        for (int i=0; i<seasons.size();i++){
            btn[i] = new Button(this);
            btn[i].setText(seasons.get(i).getName());
            btn[i].setOnClickListener(listener);
            HM.put(btn[i], new CriteriaBoolean(seasons.get(i), false));



            layout.addView(btn[i]);
        }



        Button last_btn = new Button(this);
        last_btn.setText("Далее");

        last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (CriteriaBoolean cb : HM.values()) {
                    if (cb.getBool()) {
                        CriteriaManager.select("seasons", ((Season) cb.getCriteria()).getId());
                    }
                }

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);

            }

        });

        last_btn.setBackgroundColor(Color.BLUE);
        layout.addView(last_btn);
    }




//    public void onToggleButtonClick(View button) {
//        Toast.makeText(
//                getApplicationContext(),
//                Boolean.toString(((ToggleButton) button).isChecked()),
//                Toast.LENGTH_SHORT).show();
//    }

//    public void onClick(View view) {
//        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
//        startActivity(intent);
//    }

}


