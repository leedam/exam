package com.example.leedam.myapplication768;

/**
 * Created by LEE DAM on 2016-09-05.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class MyView extends View {
    //필요한 멤버필드 정의하기
    ArrayList<com.example.leedam.myapplication768.Point> list;

    //상태값을 상수로 정의
    private Bitmap bitmap;
    static final int POINT1_STATE = 0;
    static final int POINT2_STATE = 1;
    static final int POINT3_STATE = 2;
    static final int POINT4_STATE = 3;
    static final int POINT5_STATE = 4;
  //  static final int POINT6_STATE = 5;
    //static final int ERASER_STATE = 3;
    //현재 색의 상태값을 저장할 변수
    int colorState = POINT1_STATE;
    //Paint 객체를 저장할 배열 객체 생성하기
    Paint[] paintList = new Paint[5];

    public MyView(Context context) {
        super(context);
        init();//초기화
    }

    //xml에 view를 추가시 인자2개짜리 생성자가 필요하다!!!!!!!!!!!
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();//초기화
    }

    //초기화 하는 메소드
    public void init() {
        //arraylist 객체 생성하기
        list = new ArrayList<Point>();
        //선을 그림 Paint 객체 생성 및 초기화
        Paint Point1Paint = new Paint();
        Point1Paint.setColor(Color.BLACK);
        Point1Paint.setStrokeWidth(1); //선의 굵기
        Point1Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기

        Paint Point2Paint = new Paint();
        Point2Paint.setColor(Color.BLACK);
        Point2Paint.setStrokeWidth(3); //선의 굵기
        Point2Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기

        Paint Point3Paint = new Paint();
        Point3Paint.setColor(Color.BLACK);
        Point3Paint.setStrokeWidth(5); //선의 굵기
        Point3Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기

        Paint Point4Paint = new Paint();
        Point4Paint.setColor(Color.BLACK);
        Point4Paint.setStrokeWidth(7); //선의 굵기
        Point4Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기

        Paint Point5Paint = new Paint();
        Point5Paint.setColor(Color.BLACK);
        Point5Paint.setStrokeWidth(9); //선의 굵기
        Point5Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기

       /* Paint Point6Paint = new Paint();
        Point6Paint.setColor(Color.BLACK);
        Point6Paint.setStrokeWidth(11); //선의 굵기
        Point6Paint.setAntiAlias(true);//경계면을 부드럽게 처리하기
*/

     /*   Paint eraserPaint = new Paint();
        eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        eraserPaint.setStrokeWidth(30);
        eraserPaint.setAntiAlias(true);
        //페인트 객체를 배열에 저장한다.
*/
        paintList[0] = Point1Paint;
        paintList[1] = Point2Paint;
        paintList[2] = Point3Paint;
        paintList[3] = Point4Paint;
        paintList[4] = Point5Paint;
       // paintList[5] = Point6Paint;

        //      paintList[3] = eraserPaint;

    }

    //화면을 그리는 메소드
    @Override
    protected void onDraw(Canvas canvas) {
        //배경을 흰색으로
        super.onDraw(canvas);

        //bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);

       // canvas.drawBitmap(bitmap);
        canvas.drawColor(Color.WHITE);
        //배열에 저장된 Point 객체의 좌표값을 이용해서 선을 그린다.
        for (int i = 0; i < list.size(); i++) {
            //배열에서 i번째 인덱스에 있는 Point 객체를 얻어온다.
            Point p = list.get(i);
            //해당 인텍스의 isStart 값이 true가 아니라면
//시작점이 아니므로 바로 전 point 객체와 연결한다.
            if (!(p.isStart)) canvas.drawLine(list.get(i - 1).x, //시작점x
                    list.get(i - 1).y, //시작점y
                    list.get(i).x, //도착점x
                    list.get(i).y, //도착점y
                    paintList[list.get(i).colorState]); //선의 속성을 가지고 있는 paint객체
        }

    }

    //터치 입력을 받기 위해서
    @Override
    public boolean onTouchEvent(MotionEvent event) {//event에 터치점 좌표가 들어온다.
        //이벤트가 일어난 곳의 좌표 얻어오기
        int eventX = (int) event.getX();
        int eventY = (int) event.getY();
        //이벤트의 종류에 따라서 다른 동작을 하게 한다.
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //액션 다운 이벤트가 발생하면 라인의 시작점이 된다.
                Point p = new Point(eventX, eventY, true, colorState);
                //생성한 객체를 배열에 담는다.
                list.add(p);
                break;
            case MotionEvent.ACTION_MOVE:
                //액션 무브 이벤트가 발생하면 시작점이 아니다 isStart=false
                Point p2 = new Point(eventX, eventY, false, colorState);
                list.add(p2);
                //화면 갱신하기
                invalidate();
                break;
        }


        return true;
    }
}