package com.example.leedam.myapplication768;

import java.io.Serializable;
/**
 * Created by leedam on 16. 8. 18..
 */
import java.io.Serializable;
//objectinputStream으로 저장하기 위해서 serializable한다. 단순히 빈 객체.
public class Point implements Serializable{

    int x, y;//정의 x, y좌표
    boolean isStart=false;//라인의 시작점
    int colorState;
    //생성자에서 필드에 저장할 값을 얻어온다.
    public Point(int x, int y, boolean isStart){
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }
    public Point(int x, int y, boolean isStart, int colorState){
        this.x = x;
        this.y = y;
        this.isStart = isStart;
        this.colorState = colorState;
    }

}