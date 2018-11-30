package com.surfaceview_draw.zenolab.feature;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class TouchSurfaceView extends SurfaceView {

    private Path path;
    private SurfaceHolder surfaceHolder;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TouchSurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            path = new Path();
            path.moveTo(event.getX(), event.getY());
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            path.lineTo(event.getX(), event.getY());
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            path.lineTo(event.getX(), event.getY());
        }

        if(path != null){
           Canvas  canvas = surfaceHolder.lockCanvas();
            canvas.drawPath(path, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

        return true;
    }

}


