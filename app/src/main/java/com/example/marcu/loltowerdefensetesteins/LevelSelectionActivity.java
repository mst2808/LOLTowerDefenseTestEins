package com.example.marcu.loltowerdefensetesteins;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LevelSelectionActivity extends AppCompatActivity {

    private Intent intent;
    public final int LEVEL_BUTTON_COUNT = 5;
    public static final String CURRENT_LEVEL = "CurrentLevel";
    public Button[][] buttons = new Button[LEVEL_BUTTON_COUNT][LEVEL_BUTTON_COUNT];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        GridLayout mainLayout = (GridLayout) findViewById(R.id.content);
        mainLayout.setColumnCount(LEVEL_BUTTON_COUNT);
        mainLayout.setRowCount(LEVEL_BUTTON_COUNT);

        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setText("" + (i * LEVEL_BUTTON_COUNT + j + 1));
                buttons[i][j].setId(i * LEVEL_BUTTON_COUNT + j + 1);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        starteLevel("1");
                    }
                });
                mainLayout.addView(buttons[i][j]);
            }
        }

    }

    private void starteLevel(String currentLevel ) {

        intent = getIntent();
        intent.setClass(this, PlayLevelActivity.class);

        intent.putExtra(CURRENT_LEVEL, currentLevel);
        startActivity(intent);

        
    }

}
