package ru.hw_team.lev.model.loaders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;


public class BaseObserver<T> extends BroadcastReceiver {

    private BaseLoader<T> mLoader;

    public BaseObserver(BaseLoader<T> pLoader,String...filters) {
        mLoader = pLoader;
        IntentFilter filter= new IntentFilter();
        for(String action : filters){
            filter.addAction(action);
        }
        mLoader.getContext().registerReceiver(this, filter);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mLoader.onContentChanged();
    }
}
