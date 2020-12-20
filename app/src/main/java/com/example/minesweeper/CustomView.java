package com.example.minesweeper;

//Import statements
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import android.widget.Toast;

//Class for customview
public class CustomView extends View {

//Paint variables
    private Paint paintBackground;
    private Paint paintLine;
    private Paint paintShown;

    private Paint rectPaint;


    Rect square;
    int sideLength;

    private Paint black;
    private Paint white;
    private Paint gray;

    public CustomView(Context c, AttributeSet as){
        super(c, as);
        //init(null, 0);
        paintBackground = new Paint();
        paintBackground.setColor(Color.BLACK);
        paintBackground.setStyle(Paint.Style.FILL);

        paintLine = new Paint();
        paintLine.setColor(Color.WHITE);
        paintLine.setStrokeWidth(7);

        paintShown = new Paint();
        paintShown.setColor(Color.GRAY);

    }
/*
    public CustomView(Context c, AttributeSet as){
        super(c, as);
        init(as, 0);
    }

    public void init(AttributeSet as, int defStyle){
        //set background colour
        setBackgroundColor(Color.WHITE);


    }

 */

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        drawGameBoard(canvas);
    }

    private void drawGameBoard(Canvas canvas){
        //area
        canvas.drawRect(0,0,getWidth(),getHeight(),paintBackground);

        //horizontal lines
        canvas.drawLine(0,getHeight()/10, getWidth(), getHeight()/10, paintLine);
        canvas.drawLine(0,2 * getHeight()/10, getWidth(), 2 * getHeight()/10, paintLine);
        canvas.drawLine(0,3 * getHeight()/10, getWidth(), 3 * getHeight()/10, paintLine);
        canvas.drawLine(0,4 * getHeight()/10, getWidth(), 4 * getHeight()/10, paintLine);
        canvas.drawLine(0,5 * getHeight()/10, getWidth(), 5 * getHeight()/10, paintLine);
        canvas.drawLine(0,6 * getHeight()/10, getWidth(), 6 * getHeight()/10, paintLine);
        canvas.drawLine(0,7 * getHeight()/10, getWidth(), 7 * getHeight()/10, paintLine);
        canvas.drawLine(0,8 * getHeight()/10, getWidth(), 8 * getHeight()/10, paintLine);
        canvas.drawLine(0,9 * getHeight()/10, getWidth(), 9 * getHeight()/10, paintLine);

        //vertical lines
        canvas.drawLine(getWidth()/10, 0,  getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(2 * getWidth()/10, 0, 2 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(3 * getWidth()/10, 0, 3 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(4 * getWidth()/10, 0, 4 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(5 * getWidth()/10, 0, 5 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(6 * getWidth()/10, 0, 6 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(7 * getWidth()/10, 0, 7 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(8 * getWidth()/10, 0, 8 * getWidth()/10, getHeight(), paintLine);
        canvas.drawLine(9 * getWidth()/10, 0, 9 * getWidth()/10, getHeight(), paintLine);

    }






    /*

    //method to draw the board
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        setPadding(10,10,10,10);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();

        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setColor(0xFF000000);

        int xorigin = 10;
        int yorigin = 5;
        sideLength = (getWidth()/4) - 160;
        int rectBounds = sideLength + 10;

        square = new Rect(xorigin, yorigin, sideLength, sideLength);

        int i;
        int j;
        float x;
        float y;

        x = paddingLeft;
        y = paddingTop;

        //loop for multiple rows of squares
        //loop for columns
        for (i = 0; i <= 9; i++){

            //save canvas origin
            canvas.save();
            //loop for rows
            for (j = 0; j <= 9; j++){
                canvas.save();

                //move origin of column
                canvas.translate((i * rectBounds), (j * rectBounds));

                //draw it
                canvas.drawRect(square, rectPaint);

                //restore to origin
                canvas.restore();
                }
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        //get where event happened
       float x = event.getX();
       float y = event.getY();

       //width and side length of the touch area
       float width = getWidth();
       float height = sideLength * 10;

       float rowHeight = height/9;
       float colWidth = width/9;

       //get square that was touched
        int row = 0;
        int col = 0;
        int[][] rowCol = new int[10][10];

        int i, j;
        for(i=1; i<=9; i++) {
            if (x < (i * colWidth)) {
                col = i;
                break;
            }
        }

        for (j=1; j<=10; j++) {
            if (y < (j * rowHeight)) {
                row = j;
                break;
            }
        }

        Toast.makeText(getContext(), "Row:" + row + "Col:" + col, Toast.LENGTH_SHORT).show();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                rectPaint.setStyle(Paint.Style.FILL);
                rectPaint.setColor(Color.GRAY);
                rectPaint.setColor(Color.parseColor("#808080"));

                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d("LOG", "Move");
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                Log.d("LOG", "UP");
                invalidate();
                break;



        }

        return  super.onTouchEvent(event);



    }

     */



}