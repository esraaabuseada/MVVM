package com.example.mvvm.Model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

public class DataRetrieving
{
 private static  DataRetrieving instance ;
 private int incrementValue ;
 private CounterLogic counterLogic = new CounterLogic();

 public static DataRetrieving getInstance()
 {
     if(instance == null)
     {
         instance = new DataRetrieving();
     }
     return  instance;
 }

 public MutableLiveData<Integer> getIncrementValue()
    {
        incrementValue=counterLogic.getCounter();
        setIncrementValue();

     MutableLiveData<Integer> data = new MutableLiveData<>();
     data.setValue(incrementValue);
        Log.v("Hercules",incrementValue+" Inside getIncrementValue");
     return  data ;
    }
    private  void setIncrementValue()
    {
        //incrementValue = 1;
        counterLogic.setCounter(incrementValue);
        incrementValue = counterLogic.getCounter();

    }
}
