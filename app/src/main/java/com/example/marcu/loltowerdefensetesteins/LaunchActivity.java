package com.example.marcu.loltowerdefensetesteins;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LaunchActivity extends Activity {

    public final static String DISPLAY_WIDTH = "Width";
    public final static String DISPLAY_HEIGHT = "Height";

    private DisplayMetrics dm;
    private float displayWidth;
    private float displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dm = getResources().getDisplayMetrics();
        displayWidth = dm.density * dm.widthPixels - 100;
        displayHeight = dm.density * dm.heightPixels - 100;
        setContentView(R.layout.activity_launch);

    }

    public void onPlayButtonClick(View view) {

        Intent intent = new Intent(this, LevelSelectionActivity.class);
        intent.putExtra(DISPLAY_HEIGHT, displayHeight);
        intent.putExtra(DISPLAY_WIDTH, displayWidth);
        startActivity(intent);

    }



}
