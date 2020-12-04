package by.bsu.android_lab3.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import by.bsu.android_lab3.R;

public class BGColorService extends Service {

    public class BGColorServiceBinder extends Binder {
        public BGColorService getService() {
            return BGColorService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BGColorServiceBinder();
    }

    public void setWhiteBGColor(View view) {
        view.setBackgroundColor(Color.WHITE);
    }

    public void setRedBGColor(View view) {
        view.setBackgroundColor(Color.RED);
    }

    public void setBlueBGColor(View view) {
        view.setBackgroundColor(Color.BLUE);
    }
}