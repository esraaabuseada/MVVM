package com.example.mvvm.Model;

public class CounterLogic
{
    private static int counter ;
    public void setCounter (int value)
    {
        counter+=1 ;

    }
    public int getCounter()
    {
        return counter;
    }

}
