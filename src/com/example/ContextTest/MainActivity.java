package com.example.ContextTest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 这个getApplication()是从Activity中获取到的，在attach的时候得到的对象：
        MyApplication myApplication = (MyApplication) getApplication();
        Log.d(TAG, "getApplication() = " + myApplication);//com.example.ContextTest.MyApplication@399a22a1
        // 这个是调用的ContextWrapper中的mBase.getApplicationContext()
        Context appContext = getApplicationContext();
        Log.d(TAG, "getApplicationContext() = " + appContext);//com.example.ContextTest.MyApplication@399a22a1

        // 上面的两个对象，是同一个对象
        //****************************************************************************************************//
        // 从下面这两个对比可以看出，Activity和Application中获取的BaseContext对象不同，但都是ContextImpl对象
        Context activityBaseContext = getBaseContext();
        Log.d(TAG, "MainActivity getBaseContext() = " + activityBaseContext);//android.app.ContextImpl@26b3fcc6

        Context appBaseContext = myApplication.getBaseContext();
        Log.d(TAG, "MyApplication getBaseContext() = " + appBaseContext);//android.app.ContextImpl@18cb2487
    }
}
