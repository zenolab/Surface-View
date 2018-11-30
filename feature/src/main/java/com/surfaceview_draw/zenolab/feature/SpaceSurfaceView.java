package com.surfaceview_draw.zenolab.feature;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

public class SpaceSurfaceView extends SurfaceView implements Runnable{

    Thread thread = null;
    SurfaceHolder surfaceHolder;
    volatile boolean running = false;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Random random;

    public SpaceSurfaceView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        surfaceHolder = getHolder();
        random = new Random();
        onResumeMySurfaceView();
    }

    public void onResumeMySurfaceView(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void onPauseMySurfaceView(){
        boolean retry = true;
        running = false;
        while(retry){
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(running){
            if(surfaceHolder.getSurface().isValid()){
                Canvas canvas = surfaceHolder.lockCanvas();
                //... actual drawing on canvas

               // paint.setStyle(Paint.Style.STROKE);
                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeWidth(5);

                int w = canvas.getWidth();
                int h = canvas.getHeight();
                int x = random.nextInt(w-1);
                int y = random.nextInt(h-1);
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                paint.setColor(0xff000000 + (r << 8) + (g << 32) + b);
                canvas.drawPoint(x, y, paint);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

}