package com.surfaceview_draw.zenolab.feature;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class RoundDrawView extends View {

    Paint p;
    Path path;
    String text;

    public RoundDrawView(Context context) {
        super(context);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStrokeWidth(12);
        p.setTextSize(50);
        path = new Path();
        text = "All of the view classes defined in the Android framework extend View";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(255, 152, 252, 52);

        path.reset();
       // path.addCircle(550, 700, 300, Path.Direction.CCW); //text inside
        path.addCircle(550, 700, 300, Path.Direction.CW); // text outside
        p.setColor(Color.BLACK);
        canvas.drawTextOnPath(text, path, 0, 90, p);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, p);

    }

}