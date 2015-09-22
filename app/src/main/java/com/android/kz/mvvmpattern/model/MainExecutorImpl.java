package com.android.kz.mvvmpattern.model;

import android.os.AsyncTask;

import com.android.kz.mvvmpattern.otto.MVVMBus;
import com.android.kz.mvvmpattern.otto.event.GetDateEvent;
import com.android.kz.mvvmpattern.otto.event.GetDateResultEvent;
import com.android.kz.mvvmpattern.utils.LogUtil;
import com.android.kz.mvvmpattern.webservice.TestServiceAdapter;
import com.android.kz.mvvmpattern.webservice.response.DateTimeResponse;
import com.squareup.otto.Subscribe;

import java.io.IOException;

import retrofit.Call;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:48 PM
 */
public class MainExecutorImpl implements MainExecutor {

    public MainExecutorImpl() {
        MVVMBus.getInstance().register(this);
    }

    @Override
    public void close() {
        MVVMBus.getInstance().unregister(this);
    }

    @Subscribe
    public void receivedGetIPAddressEvent(GetDateEvent event) {
        LogUtil.d("---- MainExecutor ----  received get date event ----");
        new GetIPAddressTask().execute();
    }

    class GetIPAddressTask extends AsyncTask<Void, Void, DateTimeResponse> {
        @Override
        protected DateTimeResponse doInBackground(Void... voids) {
            try {
                LogUtil.d("---- MainExecutor ----  do get date webservice ----");
                Call<DateTimeResponse> getDateCall = TestServiceAdapter.getInstance().getTestService().getDate();
                DateTimeResponse dateTimeResponse = getDateCall.execute().body();
                return dateTimeResponse;
            } catch (IOException e) {
            }
            return new DateTimeResponse();
        }

        @Override
        protected void onPostExecute(DateTimeResponse dateTimeResponse) {
            LogUtil.d("---- MainExecutor ----  send date webservice result ----  time : " + dateTimeResponse.getTime());
            LogUtil.d("---- MainExecutor ----  send date webservice result ----  milli sec : " + dateTimeResponse.getMilliseconds_since_epoch());
            LogUtil.d("---- MainExecutor ----  send date webservice result ----  data : " + dateTimeResponse.getDate());

            DateTimeViewItem dateTimeViewItem = new DateTimeViewItem(
                    dateTimeResponse.getTime(),
                    dateTimeResponse.getMilliseconds_since_epoch(),
                    dateTimeResponse.getDate()
            );

            // Send result event back to presenter
            GetDateResultEvent resultEvent = new GetDateResultEvent();
            resultEvent.setDateTimeViewItem(dateTimeViewItem);
            MVVMBus.getInstance().post(resultEvent);
        }
    }
}
