package pom.poly.com.trymakeviewbymyself.myView.v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.View;

import pom.poly.com.trymakeviewbymyself.R;

/**
 * Created by User on 12/10/2015.
 */
public class MyView extends View {
    private Paint paint;


    public MyView(Context context) {//for program use
        super(context);
        init();


    }


    public MyView(Context context, AttributeSet attrs) {//for XML use
        super(context, attrs);
        init();

    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //First se the paint, paint define the draw style
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        //Text
        canvas.drawText("Hello", 0, 70, paint);
        paint.setStyle(Paint.Style.STROKE);

        //draw aLine
        canvas.drawLine(0, 100, 100, 100, paint);
        paint.setColor(Color.RED);
        // canvas.drawRect(10, 150, 90, 270, paint);

        //Draw Rect
        RectF r = new RectF(10, 150, 90, 270);
        canvas.drawRect(r, paint);
        RectF rf = new RectF(10, 280, 90, 320);
        //canvas.drawRect(rf, paint);
        paint.setColor(Color.GRAY);
        canvas.drawRoundRect(rf, 40, 40, paint);
        //draw a BitMap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.p_04);
        Bitmap bitmap1 = ThumbnailUtils.extractThumbnail(bitmap, bitmap.getWidth() / 6, bitmap.getHeight() / 6);
        canvas.drawBitmap(bitmap1, 10, 400, paint);

    }
}
