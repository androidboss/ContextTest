package com.example.ContextTest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by dr on 11/12/15.
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive context.getApplicationContext() = " + context.getApplicationContext());
        // 这里就没有context.getApplication()了,所以说getApplicationContext()应用范围更广
        // 但是结合MainActivity中onCreate中得知，这里得到的对象，就是MyApplication对象本身
    }
}
