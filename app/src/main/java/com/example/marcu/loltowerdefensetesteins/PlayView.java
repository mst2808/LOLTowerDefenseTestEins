package com.example.marcu.loltowerdefensetesteins;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by marcu on 27.12.2015.
 */
public class PlayView extends View implements Runnable{

    public static final String ACTION_PLAYSCENE_BACK_BUTTON_PRESSED = "PlayBackButtonIsPressed";
    //	public static final String ACTION_PLAYSCENE_FORWARD_BUTTON_PRESSED = "PlayForwardButtonIsPressed";

    private Thread th = new Thread(this);

    // GUI-Komponenten
    private InformationPanel infoPanel;
    private ShopPanel shopPanel;
    private BoardPanel boardPanel;

    // Konstanten
    private static final int FPS = 60;


    public PlayView(Context context, Intent intent) {
        super(context);

        infoPanel = new InformationPanel();
        shopPanel = new ShopPanel();
        boardPanel = new BoardPanel(this.getContext(), intent);

        th.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        boardPanel.drawBoardPanel(canvas, paint);


    }


    public void update() {
        postInvalidate();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                Thread.sleep(1000 / FPS);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
