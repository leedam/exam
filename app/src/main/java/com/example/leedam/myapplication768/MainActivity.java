package com.example.leedam.myapplication768;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import org.apache.http.HttpResponse;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    MyView myView;
    Button point_btn, line_btn, rect_btn, circle_btn, man_btn, fill_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView)findViewById(R.id.myView);

        point_btn = (Button)findViewById(R.id.point_btn);
        line_btn = (Button)findViewById(R.id.line_btn);
        rect_btn = (Button)findViewById(R.id.rect_btn);
        circle_btn = (Button)findViewById(R.id.circle_btn);
        man_btn = (Button)findViewById(R.id.man_btn);
        fill_btn = (Button)findViewById(R.id.fill_btn);

        fill_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String sMessage = "https://www.youtube.com/watch?v=5hDZbroaQDc"; // 보내는 메시지를 받아옴
                String result = SendByHttp(sMessage); // 메시지를 서버에 보냄
                String[][] parsedData = jsonParserList(); // 받은 메시지를 json 파싱

                tvRecvData.setText(result);	// 받은 메시지를 화면에 보여주기
            }
        });
    }

    //inflate정적인 객체를 view에 전개, 전개하는 객체는 getMenuInflater에서 불러온다.
    public void changeColor(View v){

        point_btn.setTextColor(Color.WHITE);
        line_btn.setTextColor(Color.WHITE);
        rect_btn.setTextColor(Color.WHITE);
        circle_btn.setTextColor(Color.WHITE);
        man_btn.setTextColor(Color.WHITE);
        //fill_btn.setTextColor(Color.WHITE);

        switch(v.getId()){

            case R.id.point_btn : myView.colorState= myView.POINT1_STATE; point_btn.setTextColor(Color.BLACK); break;
            case R.id.line_btn : myView.colorState= myView.POINT2_STATE; line_btn.setTextColor(Color.BLUE); break;
            case R.id.rect_btn : myView.colorState= myView.POINT3_STATE; rect_btn.setTextColor(Color.YELLOW);break;
            case R.id.circle_btn : myView.colorState= myView.POINT4_STATE; circle_btn.setTextColor(Color.BLACK); break;
            case R.id.man_btn : myView.colorState= myView.POINT5_STATE; man_btn.setTextColor(Color.BLUE); break;
            //case R.id.fill_btn : myView.colorState= myView.POINT6_STATE; fill_btn.setTextColor(Color.YELLOW);break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //메세지 생성
        String msg="";
        switch(item.getItemId()){
            case R.id.storage:
                msg="저장하기";
                break;
            case R.id.click_init:
                msg="초기화";
                break;
            case R.id.back:
                msg="돌아가기";
                break;
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        return false;
    }


}
