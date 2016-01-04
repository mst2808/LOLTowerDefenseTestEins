package com.example.marcu.loltowerdefensetesteins;

import android.content.Context;
import android.graphics.Point;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import level.Level001;

public class MapLoader {

	private String readLine;
	private int currentRow = 0;
	
	private Character[][] mapNumbers = new Character[BoardPanel.NUMBER_COLS][BoardPanel.NUMBER_ROWS];
	private ArrayList<Point> startPoints = new ArrayList<Point>();

	private Level level;
	
	
	public MapLoader( String currentLevelNumber) {
		// TODO Auto-generated constructor stub

		if(currentLevelNumber.equals("1")) level = new Level001();

		for(int currentRow = 0; currentRow < BoardPanel.NUMBER_ROWS; currentRow++) {
			for(int curentCol = 0; curentCol < BoardPanel.NUMBER_COLS; curentCol++) {
				mapNumbers[curentCol][currentRow] = level.getLevel()[currentRow].charAt(curentCol);
			}
		}
		 
	}
	
	public Character[][] getLevelArray() {		
		return mapNumbers;		
	}

	public ArrayList<Point> getStartPoints() {
		// TODO Auto-generated method stub
		return startPoints;
	}
	
}
