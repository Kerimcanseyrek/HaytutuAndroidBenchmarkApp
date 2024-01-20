package com.example.haytutu;

import android.os.Debug;

public class MemoryTest {

    public Debug.MemoryInfo memoryInfo;

    public MemoryTest(Debug.MemoryInfo memoryInfo) {
        this.memoryInfo = memoryInfo;
        Debug.getMemoryInfo(memoryInfo);
    }

    public int getTotalClean(String type)
    {
        if(type == "private")
        {
            return memoryInfo.getTotalPrivateClean();
        }
        else
        {
            return memoryInfo.getTotalSharedClean();
        }

    }
    public int getTotalDirty(String type)
    {
        if(type == "private")
        {
            return memoryInfo.getTotalPrivateDirty();
        }
        else
        {
            return memoryInfo.getTotalSharedDirty();
        }

    }

}
