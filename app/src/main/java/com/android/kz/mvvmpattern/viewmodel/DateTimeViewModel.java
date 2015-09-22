package com.android.kz.mvvmpattern.viewmodel;

import android.content.res.Resources;
import android.databinding.ObservableField;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.kz.mvvmpattern.model.MainExecutor;
import com.android.kz.mvvmpattern.model.MainExecutorImpl;
import com.android.kz.mvvmpattern.otto.MVVMBus;
import com.android.kz.mvvmpattern.otto.event.GetDateEvent;
import com.android.kz.mvvmpattern.otto.event.GetDateResultEvent;
import com.squareup.otto.Subscribe;

/**
 * User: Kevin
 * Date: 22/09/15
 * Time: 4:21 PM
 */
public class DateTimeViewModel {

    public ObservableField timeText = new ObservableField();
    public ObservableField milliSecText = new ObservableField();
    public ObservableField dateText = new ObservableField();

    private Resources resources;
    private MainExecutor executor;

    public DateTimeViewModel(Resources resources) {
        this.resources = resources;
        MVVMBus.getInstance().register(this);
        executor = new MainExecutorImpl();
    }

    public void close() {
        MVVMBus.getInstance().unregister(this);
        executor.close();
    }

    public void testBtnClicked() {
        MVVMBus.getInstance().post(new GetDateEvent());
    }

    @Subscribe
    public void receivedResultEvent(GetDateResultEvent resultEvent) {
        timeText.set(resultEvent.getDateTimeViewItem().time);
        milliSecText.set(resultEvent.getDateTimeViewItem().milliSec);
        dateText.set(resultEvent.getDateTimeViewItem().date);
    }
}
