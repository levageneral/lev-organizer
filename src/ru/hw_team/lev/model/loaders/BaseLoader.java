package ru.hw_team.lev.model.loaders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;


public abstract class BaseLoader<T> extends AsyncTaskLoader<List<T>> {

    private List<T> mItems;

    private final InterestedConfigChanges mLastConfig = new InterestedConfigChanges();

    private BroadcastReceiver mObserver;

    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(List<T> pList) {

        if (isReset() && pList != null) {
            onReleaseResources(pList);
        }

        mItems = pList;

        if (isStarted()) {
            super.deliverResult(pList);
        }

        if (pList != null) {
            onReleaseResources(pList);
        }
    }

    /**
     * Handles a request to start the Loader.
     */
    @Override
    protected void onStartLoading() {
        if (mItems != null) {
            deliverResult(mItems);
        }

        if (mObserver == null) {
            mObserver = createObserver();
        }

        boolean configChange = mLastConfig.applyNewConfig(getContext().getResources());

        if (takeContentChanged() || mItems == null || configChange) {
            forceLoad();
        }
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    /**
     * Handles a request to cancel a load.
     */
    @Override
    public void onCanceled(List<T> apps) {
        super.onCanceled(apps);
        onReleaseResources(apps);
    }

    /**
     * Handles a request to completely reset the Loader.
     */
    @Override
    protected void onReset() {
        super.onReset();

        onStopLoading();

        if (mItems != null) {
            onReleaseResources(mItems);
            mItems = null;
        }

        if (mObserver != null) {
            getContext().unregisterReceiver(mObserver);
            mObserver = null;
        }
    }


    protected void onReleaseResources(List<T> pList) {

    }

    protected abstract BroadcastReceiver createObserver();
}