package com.novoda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by andreykazakov on 26.03.16.
 */
public class ChoicePage extends Activity {

    CriteriaManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_page);
        //cm = (CriteriaManager) getIntent().getSerializableExtra("CritManager");
    }

    public void onClick(View view) {
        Intent intent = new Intent(ChoicePage.this, MainActivity.class);
        //intent.putExtra("CritManager",cm);
        startActivity(intent);
    }


    public void onClickRandom(View view) {
        Intent intent = new Intent(ChoicePage.this, RandomizerActivity.class);
        //intent.putExtra("CritManager",cm);
        startActivity(intent);
    }

}
