package com.example.marcu.loltowerdefensetesteins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by marcu on 27.12.2015.
 */
public class PlayLevelActivity extends Activity{

    private Intent intent;
    private PlayView playView;


    // Konstanten



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();
        playView = new PlayView(this.getApplicationContext(), intent);

        setContentView(playView);

    }




}

