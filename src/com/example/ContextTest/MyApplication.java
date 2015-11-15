package com.example.ContextTest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by dr on 11/12/15.
 */
public class MyApplication extends Application{
    private static final String TAG = "MyApplication";

    public MyApplication() {
        Log.d(TAG, "MyApplication()");
        //String packageName = getPackageName();
        //Log.d("TAG", "package name is " + packageName);
        // 崩溃了，信息如下，说明现在的getPackageName()还不可用
        /**
         * 11-12 11:05:59.405    8197-8197/com.example.ContextTest E/AndroidRuntime﹕ FATAL EXCEPTION: main
         Process: com.example.ContextTest, PID: 8197
         java.lang.RuntimeException: Unable to instantiate application com.example.ContextTest.MyApplication: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String android.content.Context.getPackageName()' on a null object reference
         at android.app.LoadedApk.makeApplication(LoadedApk.java:564)
         at android.app.ActivityThread.handleBindApplication(ActivityThread.java:4555)
         at android.app.ActivityThread.access$1600(ActivityThread.java:147)
         at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1374)
         at android.os.Handler.dispatchMessage(Handler.java:102)
         at android.os.Looper.loop(Looper.java:135)
         at android.app.ActivityThread.main(ActivityThread.java:5285)
         at java.lang.reflect.Method.invoke(Native Method)
         at java.lang.reflect.Method.invoke(Method.java:372)
         at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:898)
         at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:693)
         Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String android.content.Context.getPackageName()' on a null object reference
         at android.content.ContextWrapper.getPackageName(ContextWrapper.java:137)
         at com.example.ContextTest.MyApplication.<init>(MyApplication.java:14)
         at java.lang.reflect.Constructor.newInstance(Native Method)
         at java.lang.Class.newInstance(Class.java:1572)
         at android.app.Instrumentation.newApplication(Instrumentation.java:994)
         at android.app.Instrumentation.newApplication(Instrumentation.java:979)
         at android.app.LoadedApk.makeApplication(LoadedApk.java:559)
                     at android.app.ActivityThread.handleBindApplication(ActivityThread.java:4555)
                     at android.app.ActivityThread.access$1600(ActivityThread.java:147)
                     at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1374)
                     at android.os.Handler.dispatchMessage(Handler.java:102)
                     at android.os.Looper.loop(Looper.java:135)
                     at android.app.ActivityThread.main(ActivityThread.java:5285)
                     at java.lang.reflect.Method.invoke(Native Method)
                     at java.lang.reflect.Method.invoke(Method.java:372)
                     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:898)
                     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:693)

         */
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        // 此处即可正常使用getPackageName()了
        String packageName = getPackageName();
        Log.d(TAG, "package name is " + packageName);
    }

    @Override
    protected void attachBaseContext(Context base) {
        // 在这里调用Context的方法会崩溃
        super.attachBaseContext(base);
        // 在这里可以正常调用Context的方法
    }

    // 非得提供getInstance方法的标准写法：
    private static MyApplication app;

    public static MyApplication getInstance() {
        return app;
    }

    // 这个是需要的，app = this;
    //@Override
    //public void onCreate() {
    //    super.onCreate();
    //    app = this;
    //}
}
