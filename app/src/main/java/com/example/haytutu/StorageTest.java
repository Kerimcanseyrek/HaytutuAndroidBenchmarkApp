package com.example.haytutu;

import static android.content.Context.MODE_PRIVATE;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;

public class StorageTest {
    File file;
    public StorageTest() throws IOException {
        file = new File(Environment.getExternalStorageDirectory() + "/" + File.separator + "test.txt");
        file.createNewFile();
    }
    public long test() {
        long startTime = new Date().getTime();

        long endTime = new Date().getTime();
        return endTime-startTime;

    }

    private void writeData() throws IOException {
        OutputStream fo = new FileOutputStream(file);
        fo.write(data(100000));
        fo.close();
        System.out.println("file created: "+file);
    }
    private void deleteFile()
    {
        file.delete();
    }
    private byte[] data(int length)
    {
        byte[] b = new byte[length];
        new Random().nextBytes(b);
        return b;
    }
}
