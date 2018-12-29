package privat.houyi.com.demo.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import privat.houyi.com.demo.IScheduleListener;
import privat.houyi.com.demo.IScheduleManager;
import privat.houyi.com.demo.entity.Language;

/**
 * Create by zhuxiao on 2018/12/29 0029 14:31
 * email:xxxx
 */
public class LanguageRemoteService extends Service {
    private static final String TAG = "LanguageRemoteService";
    private List<Language> studyLanguage = new ArrayList<>();
    IScheduleListener listener;
    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e(TAG, "Handler:" + studyLanguage.size() + "," + Thread.currentThread().getName());
            Toast.makeText(getBaseContext(), "left count:" + studyLanguage.size(), 2000).show();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private Binder mBinder = new IScheduleManager.Stub() {
        @Override
        public void study(Language language) throws RemoteException {
            studyLanguage.add(language);
            Log.e(TAG, "study: left count:" + studyLanguage.size() + "," + Thread.currentThread().getName());
            mainHandle.sendEmptyMessage(1);
        }

        @Override
        public void forget(Language language) throws RemoteException {
            studyLanguage.remove(language);
            Log.e(TAG, "study: left count:" + studyLanguage.size());
            mainHandle.sendEmptyMessage(1);
        }

        @Override
        public void schedule(IScheduleListener listener) throws RemoteException {
        }
    };
}
