package com.android.kz.mvvmpattern.webservice;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:57 PM
 */
public class TestServiceAdapter {
    private final static String END_POINT = "http://date.jsontest.com/";

    private TestService testService;

    private static class TestServiceAdapterHolder {
        private static final TestServiceAdapter MVP_BUS_HOLDER = new TestServiceAdapter(END_POINT);
    }

    public static TestServiceAdapter getInstance() {
        return TestServiceAdapterHolder.MVP_BUS_HOLDER;
    }

    private TestServiceAdapter(String endPoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .build();

        testService = retrofit.create(TestService.class);
    }

    public TestService getTestService() {
        return testService;
    }

}
