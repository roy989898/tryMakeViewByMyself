package pom.poly.com.trymakeviewbymyself.myView.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by User on 14/10/2015.
 */
public abstract class BasicView extends View {

    private MyThread myThread = null;
    private boolean running = true;


    public BasicView(Context context) {
        super(context);
    }

    public BasicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void drawsub(Canvas canvas);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        } else {
            drawsub(canvas);
        }
        //invalidate(); //cal by ui thread
        //postInvalidate();
        //canvas.drawText("hi",rx,300,paint);
    }

    protected abstract void logic();

    @Override
    protected void onDetachedFromWindow() {
        running=false;
        super.onDetachedFromWindow();
        System.out.println("in onDetachedFromWindow");
    }

    class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (running) {
                logic();
                postInvalidate();//call by non-UI thread
                System.out.println("thread still running");
                try {
                    Thread.sleep(30);//important !!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}


