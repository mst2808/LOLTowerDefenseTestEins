package com.example.marcu.loltowerdefensetesteins;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by marcu on 27.12.2015.
 */
public class BoardPanel {

    // Konstanten
    public static final int NUMBER_ROWS = 40;
    public static final int NUMBER_COLS = 60;

    public static final Character GRASS_ID = '1';
    public static final Character DIRT_ID = '2';
    public static final Character DIRT_PATH_ID = '3';
    public static final Character STARTFIELD_ID = '4';
    public static final Character GOAL_ID = '5';

    private Bitmap grass;
    private Bitmap dirt;
    private Bitmap start;
    private Bitmap goal;

    // Game-Komponenten
    //private Wave[] waves = new Wave[20];
    public static long BLOCK_SIZE;
    private int currentWave = 1;
    private MapLoader mapLoader;
    private static ArrayList<Point> startPoints = new ArrayList<Point>();
    public static Character[][] blocks = new Character[NUMBER_COLS][NUMBER_ROWS];

    public BoardPanel(Context context, Intent intent) {

        mapLoader = new MapLoader(intent.getStringExtra(LevelSelectionActivity.CURRENT_LEVEL));

        BLOCK_SIZE = Math.round(intent.getFloatExtra(LaunchActivity.DISPLAY_HEIGHT, 10) / NUMBER_ROWS);

        grass = BitmapFactory.decodeResource(context.getResources(), R.drawable.grass);
        dirt = BitmapFactory.decodeResource(context.getResources(), R.drawable.dirt);
        start = BitmapFactory.decodeResource(context.getResources(), R.drawable.startblock);
        goal = BitmapFactory.decodeResource(context.getResources(), R.drawable.goalblock);




    }

    public void drawBoardPanel(Canvas canvas, Paint paint) {

        for(int x = 0; x < NUMBER_COLS; x++) {
            for(int y = 0; y < NUMBER_ROWS; y++) {
                if(blocks[x][y] == GRASS_ID) drawGrass(canvas, paint, x, y);
                else if(blocks[x][y] == DIRT_ID || blocks[x][y] == DIRT_PATH_ID ) drawDirt(canvas, paint, x, y);
                else if(blocks[x][y] == STARTFIELD_ID) drawStart(canvas, paint, x, y);
                else if(blocks[x][y] == GOAL_ID) drawGoal(canvas, paint, x, y);
                else System.out.println("ung�ltiger Wert");
            }
        }

        for(int i = 0; i <= NUMBER_ROWS; i++) {
            canvas.drawLine(0, i*BLOCK_SIZE, NUMBER_COLS * BLOCK_SIZE, i*BLOCK_SIZE, paint);
        }

        for(int i = 0; i <= NUMBER_COLS; i++) {
            canvas.drawLine(i*BLOCK_SIZE, 0, i*BLOCK_SIZE, NUMBER_ROWS * BLOCK_SIZE, paint);
        }

    }

    private void drawDirt(Canvas canvas, Paint paint, int x, int y) {
        // TODO Auto-generated method stub
        canvas.drawBitmap(dirt, x * BLOCK_SIZE, y * BLOCK_SIZE, paint);
    }

    private void drawGrass(Canvas canvas, Paint paint, int x, int y) {
        // TODO Auto-generated method stub
        canvas.drawBitmap(grass, x * BLOCK_SIZE, y * BLOCK_SIZE, paint);
    }

    private void drawStart(Canvas canvas, Paint paint, int x, int y) {
        // TODO Auto-generated method stub
        canvas.drawBitmap(start, x * BLOCK_SIZE, y * BLOCK_SIZE, paint);
    }

    private void drawGoal(Canvas canvas, Paint paint, int x, int y) {
        // TODO Auto-generated method stub
        canvas.drawBitmap(goal, x * BLOCK_SIZE, y * BLOCK_SIZE, paint);
    }

}
