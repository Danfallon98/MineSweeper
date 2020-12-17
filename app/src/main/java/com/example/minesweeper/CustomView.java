package com.example.minesweeper;

//Import statements
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

//Class for customview
public class CustomView extends View {

//Paint variables
    private TextPaint textPaint;
    private Paint rectPaint;


    Rect square;
    int sideLength;

    private Paint black, grey, white;

    public CustomView(Context c){
        super(c);
        init(null, 0);

    }

    public CustomView(Context c, AttributeSet as){
        super(c, as);
        init(as, 0);
    }

    public void init(AttributeSet as, int defStyle){
        //set background colour
        setBackgroundColor(Color.WHITE);


    }


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


}