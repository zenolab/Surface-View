package com.surfaceview_draw.zenolab.feature;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class RoundDrawView extends View {

    Paint paint;
    Path path;
    String text;

    public RoundDrawView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(12);
        paint.setTextSize(50);
        path = new Path();
        text = "All of the view classes defined in the Android framework extend View class";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(255, 0, 0, 0);



        //outside text
        path.reset();
        path.addCircle(550, 700, 300, Path.Direction.CW);
        paint.setColor(Color.WHITE);
        canvas.drawTextOnPath(text, path, 90, 90, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        //+
        //inside text
        path.reset();
        path.addCircle(550, 700, 300, Path.Direction.CCW);
        paint.setColor(Color.argb(255,153,0,204));
        canvas.drawTextOnPath(text, path, 90, 90, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        //++
        path.reset();
        path.addCircle(550, 700, 300, Path.Direction.CW);
        paint.setColor(Color.argb(255,255,204,0));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

    }

}