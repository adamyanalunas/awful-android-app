package com.example.adam.buggsbunny.net;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FetchService extends Service {
    public FetchService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
