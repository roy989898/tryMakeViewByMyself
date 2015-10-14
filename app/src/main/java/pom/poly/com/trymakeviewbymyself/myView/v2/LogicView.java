package pom.poly.com.trymakeviewbymyself.myView.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by User on 14/10/2015.
 */
public class LogicView extends View {
    private Paint paint = new Paint();
    private int rx = 0;
    private MyThread myThread = null;
    private String showString = "show me";
    private RectF rectF = new RectF(0, 40, 600, 640);
    private float sweepAngle = 0;

    public LogicView(Context context) {
        super(context);
    }


    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(200);
        canvas.drawText(showString, rx, 300, paint);
        canvas.drawArc(rectF, 0, sweepAngle, true, paint);//why true?
        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        }
        //invalidate(); //cal by ui thread
        //postInvalidate();
        //canvas.drawText("hi",rx,300,paint);
    }

    class MyThread extends Thread {

        @Override
        public void run() {
            Random random = new Random();
            super.run();

            while (true) {
                if (rx > getWidth()) {
                    rx = 0 - (int) paint.measureText(showString);
                }
                if (sweepAngle > 360) {
                    sweepAngle = 0;
                }

                paint.setARGB(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));//important
                rx = rx + 20;
                sweepAngle += 2;
                postInvalidate();//call by non-UI thread
                try {
                    Thread.sleep(30);//important !!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
