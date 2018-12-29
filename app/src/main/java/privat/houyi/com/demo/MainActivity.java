package privat.houyi.com.demo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import privat.houyi.com.demo.entity.Language;
import privat.houyi.com.demo.server.LanguageRemoteService;

public class MainActivity extends AppCompatActivity {
    IScheduleManager iScheduleManager;
    Language language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }


    public void add(View v) {
        if (iScheduleManager != null) {
            language = new Language("最新", "一周", "是");
            try {
                iScheduleManager.study(language);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(View v) {
        if (language != null) {
            if (iScheduleManager != null) {
                try {
                    iScheduleManager.forget(language);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void bindService() {
        Intent intent = new Intent(this, LanguageRemoteService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iScheduleManager = IScheduleManager.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iScheduleManager = null;
        }
    };
}
