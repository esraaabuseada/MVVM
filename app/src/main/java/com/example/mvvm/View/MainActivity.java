package com.example.mvvm.View;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm.Model.CounterLogic;
import com.example.mvvm.R;
import com.example.mvvm.ViewModel.MainActivityViewModel;

import java.util.logging.LoggingPermission;


public class MainActivity extends AppCompatActivity {

    TextView textView ;
    Button button ;
    MainActivityViewModel mainActivityViewModel ;
    CounterLogic counterLogic ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        counterLogic = new CounterLogic();
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getCounter().observe(this, new Observer<Integer>() {

            @Override
            public void onChanged(@Nullable Integer integer) {
              //  counterLogic.setCounter(integer);
                textView.setText(integer+"");

    }
});

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           mainActivityViewModel.init();

        }
    });
    }
}
