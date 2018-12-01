package com.surfaceview_draw.zenolab.feature;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class DrawView extends View {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    Paint black = new Paint();

    public DrawView(Context context) {
        super(context);

        black.setColor(Color.BLACK);
        black.setStrokeWidth(8);
    }
    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawColor(Color.CYAN);

        float startX;
        float stopX;
        float startY;
        float stopY;

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int gridSize = 5;

        //Align
        int gridSpacing = Math.min(width, height) / gridSize;
        int boardSize = gridSize * gridSpacing;

        int xOffset = (width - boardSize)/2;
        // int yOffset = (height - boardSize)/2;
        // or
        int yOffset = height / 2 - width / 2;


        //Vertical Grid-lines
        for (int i = 0; i < gridSize+1; i++) {

            startX = xOffset + i*gridSpacing;
            startY = yOffset;

            stopX = startX;
            stopY = startY + boardSize;

            canvas.drawLine(startX, startY, stopX, stopY, black);

        }

        //Horizontal Grid-lines
        for (int i = 0; i < gridSize+1; i++) {

            startX = xOffset;
            startY = yOffset + i*gridSpacing;

            stopX = startX + boardSize;
            stopY = startY;

            canvas.drawLine(startX, startY, stopX, stopY, black);
        }


    }

/*
    //onMeasure() -Define a specific size for view component to fit(adapt) on layout
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.v(LOG_TAG , "--onMeasure()--");

        Log.v(LOG_TAG , MeasureSpec.toString(widthMeasureSpec));
        Log.v(LOG_TAG , MeasureSpec.toString(heightMeasureSpec));


      // int desiredWidth = 100;
      // int desiredHeight = 100;

        int desiredWidth = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight();
        int desiredHeight = getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom();



        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        //MUST CALL THIS!
        setMeasuredDimension(width, height);

    }
  */
    //onLayout() -в ызывается для расположения элемента внутри контейнера;
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(LOG_TAG , "-- onLayout()--");
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);
        Log.d(LOG_TAG ,"-- onSizeChanged() -- ");

    }

}