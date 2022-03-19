package com.example.lab2_3;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {
    private static final String TAG = "MyListener";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void ON_CREATE() {
        System.out.println("MyObserver:ON_CREATE");
        Log.d(TAG,"onCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void ON_START() {
        System.out.println("MyObserver:ON_START");
        Log.d(TAG,"onCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ON_RESUME() {
        System.out.println("MyObserver:ON_RESUME");
        Log.d(TAG,"onResume()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void ON_PAUSE() {
        System.out.println("MyObserver:ON_PAUSE");
        Log.d(TAG,"onPause()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void ON_STOP() {
        System.out.println("MyObserver:ON_STOP");
        Log.d(TAG,"onStop()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void ON_DESTROY() {
        System.out.println("MyObserver:ON_DESTROY");
        Log.d(TAG,"onDestroy() ");
    }
}