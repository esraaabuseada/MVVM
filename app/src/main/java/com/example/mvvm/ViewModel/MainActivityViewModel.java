package com.example.mvvm.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.mvvm.Model.CounterLogic;
import com.example.mvvm.Model.DataRetrieving;

public class MainActivityViewModel extends ViewModel
{
  private MutableLiveData<Integer> mCounter , mcc;
  private DataRetrieving dataRet ;
  private CounterLogic counterLogic = new CounterLogic();
  public void init()
  {
      if(mCounter == null)
      {
          mCounter=new MutableLiveData<>() ;
      }

          dataRet = DataRetrieving.getInstance();
          mcc = dataRet.getIncrementValue();

          mCounter.setValue(mcc.getValue());
     }

//  }

  public MutableLiveData<Integer> getCounter()
  {


      return  mCounter;


  }
  public int counterResult()
  {
      return mCounter.getValue() +1;
  }
  

}
