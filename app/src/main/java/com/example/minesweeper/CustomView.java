package com.example.minesweeper;

//Import statements
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.minesweeper.MinefieldArray;
import com.google.android.material.textview.MaterialTextView;


//Class for customview
public class CustomView extends View {

//Paint variables
    private Paint paintBackground;
    private Paint paintLine;
    private Paint paintShown;
    private Paint paintMine;
    private Paint paintText;
    private boolean gameOver  = false;

    public CustomView(Context c, AttributeSet as){
        super(c, as);
        //colours for the lines and squares
        paintBackground = new Paint();
        paintBackground.setColor(Color.BLACK);
        paintBackground.setStyle(Paint.Style.FILL);

        paintLine = new Paint();
        paintLine.setColor(Color.WHITE);
        paintLine.setStrokeWidth(7);

        paintShown = new Paint();
        paintShown.setColor(Color.GRAY);

        paintMine = new Paint();
        paintMine.setColor(Color.RED);

        paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(80);


        //instance for placed mines
        MinefieldArray.getInstance().placeMines();


    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //draw gameboard
        drawGameBoard(canvas);
        //draw mines
        drawMinefield(canvas);
        //draw updates board
        drawPlayerView(canvas);
    }

    //Game board drawn lines on background
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

    //draw the mines
    public void drawMinefield(Canvas canvas){
        for(int i = 0; i < 10; i++ ){
            for (int j = 0; j < 10; j++){
                float xOrig = (i) * getWidth()/10;
                float yOrig = (j) * getHeight()/10;
                if (MinefieldArray.getInstance().getBoardCell(i,j) == MinefieldArray.Mine){
                    canvas.drawRect(xOrig, yOrig, yOrig + getWidth()/10, yOrig +getHeight()/10, paintMine);
                    canvas.drawText("M", xOrig, yOrig + getHeight()/10, paintText);
                }
            }
        }
    }



    //players view
    private void drawPlayerView(Canvas canvas){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                float xOrig = (i) * getWidth()/10;
                float yOrig = (j) * getHeight()/10;
                if(MinefieldArray.getInstance().getCoveredCell(i,j) == MinefieldArray.Covered){
                    canvas.drawRect(xOrig,yOrig,xOrig + getWidth()/10, yOrig + getHeight()/10, paintBackground);
                }
                else if (MinefieldArray.getInstance().getCoveredCell(i, j) == MinefieldArray.Uncovered){
                    canvas.drawRect(xOrig,yOrig,xOrig + getWidth()/10, yOrig + getHeight()/10, paintShown);
                }
            }
        }

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




    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if(gameOver){
                MinefieldArray.getInstance().resetBoard();
                MinefieldArray.getInstance().placeMines();
                MinefieldArray.getInstance().countMines();
                invalidate();
                gameOver = false;
            }
            else {

                int x = ((int) event.getX() / (getWidth() / 10));
                int y = ((int) event.getY() / (getHeight() / 10));
                touched(x, y);
                mineFound();
            }
           invalidate();

        }
        return super.onTouchEvent(event);
    }

    //touch method to deal with touched areass
    public void touched(int x, int y){
        //uncover tile when touched
        if(x < 10 && y < 10 && MinefieldArray.getInstance().getCoveredCell(x, y) == MinefieldArray.Covered
        && MinefieldArray.getInstance().getActionType() == MinefieldArray.Revealed){
            MinefieldArray.getInstance().setCoveredState(x,y, MinefieldArray.getInstance().getUncovered());
        }
    }

    //Check for if a mine is found
    private void mineFound(){
        if (MinefieldArray.getInstance().noMineHit() && !(MinefieldArray.getInstance().checkLoss())){
            gameOver = true;
        }
        else if (MinefieldArray.getInstance().checkLoss()){
            gameOver = true;
        }

    }




}

