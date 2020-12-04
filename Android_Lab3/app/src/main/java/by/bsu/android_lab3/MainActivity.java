package by.bsu.android_lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import by.bsu.android_lab3.service.BGColorService;

public class MainActivity extends AppCompatActivity {

    private BGColorService bgColorService;
    private boolean isBGColorServiceBound = false;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BGColorService.BGColorServiceBinder binder = (BGColorService.BGColorServiceBinder) iBinder;
            bgColorService = binder.getService();
            isBGColorServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBGColorServiceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BGColorService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBGColorServiceBound) {
            Intent intent = new Intent(this, BGColorService.class);
            unbindService(serviceConnection);
            isBGColorServiceBound = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.white_bg:
                bgColorService.setWhiteBGColor(findViewById(R.id.main_view));
                return true;
            case R.id.red_bg:
                bgColorService.setRedBGColor(findViewById(R.id.main_view));
                return true;
            case R.id.blue_bg:
                bgColorService.setBlueBGColor(findViewById(R.id.main_view));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}