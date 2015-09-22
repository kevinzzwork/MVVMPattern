package com.android.kz.mvvmpattern.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.kz.mvvmpattern.R;
import com.android.kz.mvvmpattern.databinding.ActivityMainBinding;
import com.android.kz.mvvmpattern.viewmodel.DateTimeViewModel;


public class MainActivity extends AppCompatActivity {

    private DateTimeViewModel dateTimeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dateTimeViewModel = new DateTimeViewModel( getResources() );
        binding.setDateTimeViewModel(dateTimeViewModel);
        binding.testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateTimeViewModel.testBtnClicked();
            }
        });
    }

    @Override
    protected void onDestroy() {
        dateTimeViewModel.close();
        super.onDestroy();
    }
}
