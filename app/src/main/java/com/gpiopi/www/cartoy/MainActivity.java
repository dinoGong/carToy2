package com.gpiopi.www.cartoy;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("HandlerLeak")
    private Handler uiHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    //System.out.println("handleMessage thread id " + Thread.currentThread().getId());
                    //System.out.println("msg.arg1:" + msg.arg1);
                    //System.out.println("msg.arg2:" + msg.arg2);
                    String inmsg=(String)msg.obj;


                    //((TextView)MainActivity.this.findViewById(R.id.button)).setText(inmsg);
                    break;
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_up = (Button) findViewById(R.id.button_up);
        Button button_down = (Button) findViewById(R.id.button_down);
        Button button_left = (Button) findViewById(R.id.button_left);
        Button button_right = (Button) findViewById(R.id.button_right);
        Button button_conn = (Button) findViewById(R.id.button_CONN);

        setTitle("蓝牙遥控车2");


        final Ble ble=new Ble(this,uiHandler,"A4:C1:38:77:05:2E","0000ffe0-0000-1000-8000-00805f9b34fb","0000ffe1-0000-1000-8000-00805f9b34fb","0000ffe1-0000-1000-8000-00805f9b34fb");

        ble.conn();

        button_conn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View view) {
                ble.conn();
            }
        });

        button_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    ble.write(("5").getBytes());
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    ble.write(("1").getBytes());
                }
                return false;
            }
        });

        button_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    ble.write(("5").getBytes());
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    ble.write(("2").getBytes());
                }
                return false;
            }
        });

        button_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    ble.write(("5").getBytes());
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    ble.write(("3").getBytes());
                }
                return false;
            }
        });

        button_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    ble.write(("5").getBytes());
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    ble.write(("4").getBytes());
                }
                return false;
            }
        });

    }

}
