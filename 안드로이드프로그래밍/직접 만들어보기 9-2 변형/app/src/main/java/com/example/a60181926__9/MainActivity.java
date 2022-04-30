package com.example.a60181926__9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/*기존의 프로젝트 : 매 도형을 그릴 때 마다 이전 도형이 사라짐.
* 이를 수정하여 도형을 그릴때 이전의 도형들이 남아있게 설정*/

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;
    static boolean isfinished = false;
    static List<MyShape> myshape = new ArrayList<MyShape>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("간단 그림판 (개선)");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0, 4, 0, "빨강");
        sMenu.add(0, 5, 0, "초록");
        sMenu.add(0, 6, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.GREEN;
                return true;
            case 6:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyShape {
        int shapeType; // 도형 종류
        int startX, startY, stopX, stopY; // 도형의 2점
        int color; // 도형 색상

        MyShape(int shapeType, int startX, int startY, int stopX, int stopY, int color){
            this.shapeType = shapeType;
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.color = color;
        }
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    isfinished = false;
                    break;
                case MotionEvent.ACTION_MOVE:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    isfinished = false;
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    myshape.add(new MyShape(curShape, startX, startY, stopX, stopY, curColor));
                    isfinished = true;
                    this.invalidate();
                    break;
            }
            return true;
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            for(int i=0; i<myshape.size(); i++){
                MyShape me = myshape.get(i);
                paint.setColor(me.color);
                switch (me.shapeType) {
                    case LINE:
                        canvas.drawLine(me.startX, me.startY, me.stopX, me.stopY, paint);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(me.stopX - me.startX, 2)
                                + Math.pow(me.stopY - me.startY, 2));
                        canvas.drawCircle(me.startX, me.startY, radius, paint);
                        break;
                    case RECTANGLE:
                        Rect rect = new Rect(me.startX, me.startY, me.stopX, me.stopY);
                        canvas.drawRect(rect, paint);
                        break;
                }
            }
            if(isfinished==false){
                paint.setColor(curColor);
                switch (curShape) {
                    case LINE:
                        canvas.drawLine(startX, startY, stopX, stopY, paint);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                                + Math.pow(stopY - startY, 2));
                        canvas.drawCircle(startX, startY, radius, paint);
                        break;
                    case RECTANGLE:
                        Rect rect = new Rect(startX, startY, stopX, stopY);
                        canvas.drawRect(rect, paint);
                        break;
                }
            }
        }
    }
}
