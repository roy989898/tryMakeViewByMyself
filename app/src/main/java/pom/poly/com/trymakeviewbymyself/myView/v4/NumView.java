package pom.poly.com.trymakeviewbymyself.myView.v4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import pom.poly.com.trymakeviewbymyself.R;
import pom.poly.com.trymakeviewbymyself.myView.v3.BasicView;

/**
 * Created by User on 14/10/2015.
 */
public class NumView extends BasicView {
    private Paint paint = new Paint();
    private String showText = "I love you";
    private int linenum=4;

    public NumView(Context context) {
        super(context);
    }

    public NumView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.NumView);
        linenum=ta.getInt(R.styleable.NumView_linenum,0);
        ta.recycle();//release the TypedArray
    }

    @Override
    protected void drawsub(Canvas canvas) {
        int textSize=100;
        for (int i = 0; i < linenum; i++) {
            textSize = textSize + i*10;
            paint.setTextSize(textSize);
            canvas.drawText(showText, 0, textSize + textSize*i, paint);
        }


    }

    @Override
    protected void logic() {

    }
}
