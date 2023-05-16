package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    private Rect mRect = new Rect();
    private Rect mBounds = new Rect();

    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int mColorBackground;
    private int mColorHouse;
    private int mColorCircleYellow;
    private int mColorCircleOrange;
    private int mColorText;
    private int mCount = 0;
    private int mColorRumput;
    private int mColorDinding;
    private int mColorPintu;
    private int mColorJendela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.colorBackground, null);
        mColorHouse = ResourcesCompat.getColor(getResources(), R.color.colorHouse, null);
        mColorCircleYellow = ResourcesCompat.getColor(getResources(), R.color.ballonYellow, null);
        mColorCircleOrange = ResourcesCompat.getColor(getResources(), R.color.ballonOrange, null);
        mColorRumput = ResourcesCompat.getColor(getResources(), R.color.rumput, null);
        mColorDinding = ResourcesCompat.getColor(getResources(), R.color.dinding, null);
        mColorPintu = ResourcesCompat.getColor(getResources(), R.color.pintu, null);
        mColorJendela = ResourcesCompat.getColor(getResources(), R.color.jendela, null);
//        mColorText = ResourcesCompat.getColor(getResources(), R.color.black, null);

        // setting paint
        mPaint.setColor(mColorBackground);
        mPaintText.setColor(mColorText);
        mPaintText.setTextSize(70);

        // assign image view
        mImageView = findViewById(R.id.my_image_view);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view, mCount);
                mCount += 1;
            }
        });
    }

    private void drawSomething(View view, int mCount) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();

        // ambil separuh lebar & tinggi
        int halfWidth = vWidth / 2;
        int halfHeight = vHeight / 2;

        if (mCount == 0) {
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(mColorBackground);
        } else if (mCount == 1){
            //ni rumput
            mPaint.setColor(mColorRumput);
            mRect.set(halfWidth - 900, halfHeight+100, halfWidth +900, halfHeight + 1200);
            mCanvas.drawRect(mRect, mPaint);
        } else if (mCount == 2) {
            //ni atep
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.colorHouse, null));
            Point a = new Point(halfWidth - 200, halfHeight - 50);
            Point c = new Point(halfWidth + 200, halfHeight - 50);
            Point b = new Point(halfWidth, halfHeight - 300);

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);

            path.close();
            mCanvas.drawPath(path, mPaint);
        } else if (mCount == 3) {
            //ni dinding
            mPaint.setColor(mColorDinding);
            mRect.set(halfWidth - 200, halfHeight-50, halfWidth +200, halfHeight + 250);
            mCanvas.drawRect(mRect, mPaint);
        } else if (mCount ==4) {
            mPaint.setColor(mColorPintu);
            mRect.set(halfWidth - 50, halfHeight+50, halfWidth +50, halfHeight + 250);
            mCanvas.drawRect(mRect, mPaint);
        }else if (mCount == 5) {
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.ballonYellow, null));
            mCanvas.drawCircle(halfWidth + 30, halfHeight + 170, halfHeight / 70, mPaint);
        }else if (mCount == 6) {
            mPaint.setColor(mColorJendela);
            mRect.set(halfWidth - 170, halfHeight+50, halfWidth - 70, halfHeight + 150);
            mCanvas.drawRect(mRect, mPaint);
        }else if (mCount == 7) {
            mPaint.setColor(mColorHouse);
            mRect.set(halfWidth - 400, halfHeight - 100, halfWidth - 300, halfHeight + 200);
            mCanvas.drawRect(mRect, mPaint);
        } else if (mCount == 8) {
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.colorDaun, null));
            Point k = new Point(halfWidth - 500, halfHeight - 100);
            Point l = new Point(halfWidth - 200, halfHeight - 100);
            Point m = new Point(halfWidth - 340, halfHeight - 500);

            Path path1 = new Path();
            path1.setFillType(Path.FillType.EVEN_ODD);
            path1.lineTo(k.x, k.y);
            path1.lineTo(l.x, l.y);
            path1.lineTo(m.x, m.y);
            path1.lineTo(k.x, k.y);
            path1.close();
            mCanvas.drawPath(path1, mPaint);
        } else if (mCount == 9) {
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.ballonYellow, null));
            mCanvas.drawCircle(halfWidth + 200, halfHeight - 550, halfHeight / 6, mPaint);
        }
        view.invalidate();
    }
}