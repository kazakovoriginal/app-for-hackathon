package com.novoda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * Created by andreykazakov on 26.03.16.
 */
public class StartPage extends Activity{

    CriteriaManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        CriteriaManager.setFile("test.json");
        CriteriaManager.parseAllFromFile();

//        Intent intent = new Intent(StartPage.this, ChoicePage.class);
////        intent.putExtra("CritManager", cm);
//
//        startActivity(intent);
    }


    public void onClick(View view) {
        Intent intent = new Intent(StartPage.this, ChoicePage.class);
        //intent.putExtra("CritManager",cm);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_hello_world, menu);
        return true;
    }
}
