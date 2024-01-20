package com.example.haytutu;

import android.os.Process;

import java.util.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CpuTest {

    CpuTest()
    {
        timeElapsedPI = 0;
        timeElapsedSort = 0;
        isReady = false;
    }
    private long timeElapsedPI;
    private long timeElapsedSort;
    private boolean isReady;

    /*
    public void getCpuCalculationwithProcess()
    {
        calculatePI();
        timeElapsed = Process.getElapsedCpuTime();
        isReady = true;
        //return Process.getElapsedCpuTime();
    }
    */

    public boolean IsReady()
    {
        return isReady;
    }
    public long GetTimeElapsedPI()
    {
        return timeElapsedPI;
    }

    public long GetTimeElapsedSort()
    {
        return timeElapsedSort;
    }
    public void getCpuCalculationWithTimePI()
    {
        long startTime = new Date().getTime();
        calculatePI();
        long endTime = new Date().getTime();
        timeElapsedPI = endTime-startTime;
    }

    public void getCpuCalculationWithTimeSort()
    {
        long startTime = new Date().getTime();
        sortRandomArray();
        long endTime = new Date().getTime();
        timeElapsedSort = endTime-startTime;
    }

    public void sortRandomArray()
    {
        Random random = new Random();
        Integer[] array = new Integer[100000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        // Shuffle the array randomly
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);

        // Sort the array
        Arrays.sort(array);
    }
    private void calculatePI()
    {
        double i;// value of i user entered
        double sum = 0;
        for(i=0; i<100002123; i++){
            if(i%2 == 0) // if the remainder of `i/2` is 0
                sum += -1 / ( 2 * i - 1);
            else
                sum += 1 / (2 * i - 1);
        }
    }
}
